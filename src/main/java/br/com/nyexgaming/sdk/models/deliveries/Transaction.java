package br.com.nyexgaming.sdk.models.deliveries;

import br.com.nyexgaming.sdk.models.products.Product;

public class Transaction {

    public long id_transacao;
    public long id_cupom;
    public long id_loja;

    public TransactionStatus status;
    public TransactionDelivery entregue;

    public String identificador;
    public String email;

    public String gateway;
    public double valor;
    public String hex_transacao;
    public String external_reference;

    public Product[] produtos;

    public long criado_em;
    public long atualizado_em;
}
