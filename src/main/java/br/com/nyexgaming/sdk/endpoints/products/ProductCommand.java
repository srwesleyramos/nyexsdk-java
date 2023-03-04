package br.com.nyexgaming.sdk.endpoints.products;

public class ProductCommand {

    public long id_comando;
    public long id_loja;
    public long id_produto;

    public String comando;
    public String args;
    public boolean console;

    public boolean temporario;
    public int dias_duracao;

    public String type;

    public long criado_em;
    public long atualizado_em;
}
