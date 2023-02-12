package br.com.nyexgaming.sdk.endpoints.transactions;

import br.com.nyexgaming.sdk.endpoints.products.Product;

public class Transaction {

    public long id_loja;
    public long id_cupom;
    public long id_transacao;

    public int status;

    public String identificador;
    public String valor;
    public String gateway;

    public long criado_em;
    public long atualizado_em;

    public Product[] produtos;

    public TransactionStatus getStatus() {
        return TransactionStatus.valueOf(this.status);
    }
}
