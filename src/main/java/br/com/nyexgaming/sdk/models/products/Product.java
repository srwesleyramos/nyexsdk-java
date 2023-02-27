package br.com.nyexgaming.sdk.models.products;

public class Product {

    public long id_produto;

    public String nome;
    public String detalhes;
    public String imagem;

    public double preco;

    public int estoque;
    public int quantidade;

    public boolean usar_estoque;
    public boolean deletar_sem_estoque;

    public ProductCommand[] comandos;

    public long criado_em;
    public long atualizado_em;
}
