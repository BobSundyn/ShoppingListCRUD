package br.com.bobsundyn.model;

public class Produto {

    public String nome;
    public String imagem;
    public Double preco;
    public String link;

    public Produto(String nome, String imagem, double preco, String link) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.link = link;
    }

    public Produto(String nome, String imagem, String link, double preco) {
    }
}
