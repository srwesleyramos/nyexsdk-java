package br.com.nyexgaming.sdk.endpoints.products;

public class Product {

    public long id_produto;
    public String nome;
    public String detalhes;
    public String preco;
    public int estoque;
    public int quantidade;
    public boolean usar_estoque;
    public boolean deletar_sem_estoque;
    public String imagem;
    public ProductCommand[] comandos;
    public String criado_em;
    public String atualizado_em;
}
