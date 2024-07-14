package org.example.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fornecedor extends Pessoa {
    private List<Produto> produtos = new ArrayList();

    public Fornecedor(String nome, String cpf) {
        super(nome, cpf);
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void adicionarProdutos(Produto prod, int quantidade) {
        prod.setQuantidade(quantidade);
        prod.setValorTotal();
        this.produtos.add(prod);
    }

    public void removerQuantidade(Produto prod, int quantidade) {
        Iterator var3 = this.produtos.iterator();

        while(var3.hasNext()) {
            Produto produto = (Produto)var3.next();
            if (produto.getId() == prod.getId()) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
            }
        }

    }
}
