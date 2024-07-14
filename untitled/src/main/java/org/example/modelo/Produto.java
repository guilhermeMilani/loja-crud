package org.example.modelo;

public class Produto {
    private static int sequencia = 1;
    private int id;
    private String nome;
    private double valorUnitario;
    private double valorTotal;
    private int quantidade;

    public Produto(String nome, double valorUnitario) {
        this.id = sequencia++;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidade = 0;
        this.valorTotal = 0.0;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal() {
        this.valorTotal = this.valorUnitario * (double)this.quantidade;
    }

    public double getvalorUnitario() {
        return this.valorUnitario;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return "Produto{id=" + this.id + ", nome='" + this.nome + "', valorUnitario=" + this.valorUnitario + ", valorTotal=" + this.valorTotal + ", quantidade=" + this.quantidade + "}";
    }
}