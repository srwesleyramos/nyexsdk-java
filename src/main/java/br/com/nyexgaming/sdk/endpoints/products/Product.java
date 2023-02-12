package br.com.nyexgaming.sdk.endpoints.products;

import java.util.List;

public class Product {

    public long id_produto;
    private long id_loja;
    private long id_categoria;
    public String nome;
    public String detalhes;
    public String preco;
    private int estoque;
    public boolean usar_estoque;
    public boolean deletar_sem_estoque;
    private String imagem;
    public int quantidade;
    public List<String> comandos;
    private String criado_em;
    private String atualizado_em;
}
