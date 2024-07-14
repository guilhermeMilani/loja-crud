package org.example.modelo;

import java.util.ArrayList;
import java.util.List;


public class Estoque {
    private List<Produto> produtos = new ArrayList();

    public Estoque() {
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void adicionarProdutoAoEstoque(Fornecedor forn, int idProd, int quantidade) {
        Produto prodEncontrado = forn.getProdutos().stream().filter(produto -> produto.getId() == idProd).findFirst().orElse(null);

        if (prodEncontrado != null) {
            if (prodEncontrado.getQuantidade() >= quantidade) {
                forn.removerQuantidade(prodEncontrado, quantidade);
                prodEncontrado.setQuantidade(quantidade);
                prodEncontrado.setValorTotal();
                this.produtos.add(prodEncontrado);
            } else {
                System.out.println("Quantidade acima do que o fornecedor possui!");
            }
        } else {
            System.out.println("Produto não encontrado");
        }

    }
}