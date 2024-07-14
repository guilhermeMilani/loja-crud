package org.example;

import org.example.modelo.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Jailson", "091.192.121-07");
        Cliente cliente2 = new Cliente("Maycon", "089.122.221-09");
        Produto prod1 = new Produto("TV", 2000.0);
        Produto prod2 = new Produto("Celular", 3000.0);
        Produto prod3 = new Produto("Relogio", 500.0);
        Fornecedor forn1 = new Fornecedor("Roberto", "091.198.329-08");
        Estoque estoque = new Estoque();
        Loja loja1 = new Loja("Magazine Luiza", estoque);
        forn1.adicionarProdutos(prod1, 10);
        forn1.adicionarProdutos(prod2, 10);
        forn1.adicionarProdutos(prod3, 10);
        System.out.println("Produtos do fornecedor: " + forn1.getProdutos());
        estoque.adicionarProdutoAoEstoque(forn1, 1, 5);
        estoque.adicionarProdutoAoEstoque(forn1, 2, 7);
        System.out.println("Produtos do fornecedor: " + forn1.getProdutos());
        System.out.println("Produtos do estoque: " + loja1.getEstoque().getProdutos());
        System.out.println(loja1.fecharCompraDoCliente(cliente, 1, 1));
        System.out.println(loja1.fecharCompraDoCliente(cliente, 1, 2));
        System.out.println("Produtos do estoque: " + loja1.getEstoque().getProdutos());
        System.out.println(loja1.fecharCompraDoCliente(cliente2, 2, 2));
        System.out.println("Produtos do estoque: " + loja1.getEstoque().getProdutos());
        System.out.println("--------------- Historico Clientes --------------------");
        System.out.println(loja1.getHistoricoDosClientes());
    }
}