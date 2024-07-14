package org.example.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Loja {
    private String nome;
    private Estoque estoque;
    private String statusDaCompra;
    Map<Cliente, List<Produto>> historicoDosClientes;

    public Loja(String nome, Estoque estoque) {
        this.nome = nome;
        this.estoque = estoque;
        this.historicoDosClientes = new HashMap();
    }

    public String getNome() {
        return this.nome;
    }

    public Estoque getEstoque() {
        return this.estoque;
    }

    public Map<Cliente, List<Produto>> getHistoricoDosClientes() {
        return this.historicoDosClientes;
    }

    public String fecharCompraDoCliente(Cliente cliente, int quantidade, int idProduto) {
        Iterator var4 = this.estoque.getProdutos().iterator();

        Produto prod;
        do {
            if (!var4.hasNext()) {
                return this.statusDaCompra = "Produto não encontrado";
            }

            prod = (Produto)var4.next();
        } while(prod.getId() != idProduto);

        if (prod.getQuantidade() >= quantidade) {
            prod.setQuantidade(prod.getQuantidade() - quantidade);
            prod.setValorTotal();
            Produto produto = new Produto(prod.getNome(), prod.getvalorUnitario());
            produto.setQuantidade(quantidade);
            produto.setValorTotal();
            List<Produto> listaDeProdutos = (List)this.historicoDosClientes.get(cliente);
            if (listaDeProdutos == null) {
                listaDeProdutos = new ArrayList();
                this.historicoDosClientes.put(cliente, listaDeProdutos);
            }

            ((List)listaDeProdutos).add(produto);
            this.historicoDosClientes.put(cliente, listaDeProdutos);
            return this.statusDaCompra = "Compra efetuada com sucesso!";
        } else {
            return this.statusDaCompra = "Quantidade indisponivel no estoque!";
        }
    }
}