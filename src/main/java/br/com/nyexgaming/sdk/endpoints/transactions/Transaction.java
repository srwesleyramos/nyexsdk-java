package br.com.nyexgaming.sdk.endpoints.transactions;

import br.com.nyexgaming.sdk.endpoints.products.Product;

public class Transaction {

    public long id_transacao;
    public String identificador;
    public String email;
    public String gateway;
    public String valor;
    public int status;
    public int entregue;
    public String hex_transacao;
    public String external_reference;
    public Product[] produtos;
    public String criado_em;
    public String atualizado_em;
    public long id_cupom;
    public long id_loja;
}
