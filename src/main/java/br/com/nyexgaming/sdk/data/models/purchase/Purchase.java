package br.com.nyexgaming.sdk.data.models.purchase;

import br.com.nyexgaming.sdk.data.models.product.Product;

public class Purchase {

    private long id_transacao;
    private long id_cupom;
    private long id_loja;
    private long id_servidor;

    private PurchaseStatus status;
    private PurchaseDelivery entregue;

    private String identificador;
    private String email;

    private String gateway;
    private double valor;
    private String hex_transacao;
    private String external_reference;

    private Product[] produtos;

    private long criado_em;
    private long atualizado_em;

    public Purchase(long id_transacao, long id_cupom, long id_loja, long id_servidor, PurchaseStatus status, PurchaseDelivery entregue, String identificador, String email, String gateway, double valor, String hex_transacao, String external_reference, Product[] produtos, long criado_em, long atualizado_em) {
        this.id_transacao = id_transacao;
        this.id_cupom = id_cupom;
        this.id_loja = id_loja;
        this.id_servidor = id_servidor;
        this.status = status;
        this.entregue = entregue;
        this.identificador = identificador;
        this.email = email;
        this.gateway = gateway;
        this.valor = valor;
        this.hex_transacao = hex_transacao;
        this.external_reference = external_reference;
        this.produtos = produtos;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public long id_transacao() {
        return id_transacao;
    }

    public Purchase setId_transacao(long id_transacao) {
        this.id_transacao = id_transacao;
        return this;
    }

    public long id_cupom() {
        return id_cupom;
    }

    public Purchase setId_cupom(long id_cupom) {
        this.id_cupom = id_cupom;
        return this;
    }

    public long id_loja() {
        return id_loja;
    }

    public Purchase setId_loja(long id_loja) {
        this.id_loja = id_loja;
        return this;
    }

    public long id_servidor() {
        return id_servidor;
    }

    public Purchase setId_servidor(long id_servidor) {
        this.id_servidor = id_servidor;
        return this;
    }

    public PurchaseStatus status() {
        return status;
    }

    public Purchase setStatus(PurchaseStatus status) {
        this.status = status;
        return this;
    }

    public PurchaseDelivery entregue() {
        return entregue;
    }

    public Purchase setEntregue(PurchaseDelivery entregue) {
        this.entregue = entregue;
        return this;
    }

    public String identificador() {
        return identificador;
    }

    public Purchase setIdentificador(String identificador) {
        this.identificador = identificador;
        return this;
    }

    public String email() {
        return email;
    }

    public Purchase setEmail(String email) {
        this.email = email;
        return this;
    }

    public String gateway() {
        return gateway;
    }

    public Purchase setGateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    public double valor() {
        return valor;
    }

    public Purchase setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public String hex_transacao() {
        return hex_transacao;
    }

    public Purchase setHex_transacao(String hex_transacao) {
        this.hex_transacao = hex_transacao;
        return this;
    }

    public String external_reference() {
        return external_reference;
    }

    public Purchase setExternal_reference(String external_reference) {
        this.external_reference = external_reference;
        return this;
    }

    public Product[] produtos() {
        return produtos;
    }

    public Purchase setProdutos(Product[] produtos) {
        this.produtos = produtos;
        return this;
    }

    public long criado_em() {
        return criado_em;
    }

    public Purchase setCriado_em(long criado_em) {
        this.criado_em = criado_em;
        return this;
    }

    public long atualizado_em() {
        return atualizado_em;
    }

    public Purchase setAtualizado_em(long atualizado_em) {
        this.atualizado_em = atualizado_em;
        return this;
    }
}
