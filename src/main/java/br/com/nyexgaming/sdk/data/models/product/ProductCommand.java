package br.com.nyexgaming.sdk.data.models.product;

public class ProductCommand {

    private long id_comando;
    private long id_loja;
    private long id_produto;

    private String comando;
    private String args;
    private boolean console;

    private boolean temporario;
    private int dias_duracao;

    private ProductCommandType type;

    private long criado_em;
    private long atualizado_em;

    public ProductCommand(long id_comando, long id_loja, long id_produto, String comando, String args, boolean console, boolean temporario, int dias_duracao, ProductCommandType type, long criado_em, long atualizado_em) {
        this.id_comando = id_comando;
        this.id_loja = id_loja;
        this.id_produto = id_produto;
        this.comando = comando;
        this.args = args;
        this.console = console;
        this.temporario = temporario;
        this.dias_duracao = dias_duracao;
        this.type = type;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public long id_comando() {
        return id_comando;
    }

    public ProductCommand setId_comando(long id_comando) {
        this.id_comando = id_comando;
        return this;
    }

    public long id_loja() {
        return id_loja;
    }

    public ProductCommand setId_loja(long id_loja) {
        this.id_loja = id_loja;
        return this;
    }

    public long id_produto() {
        return id_produto;
    }

    public ProductCommand setId_produto(long id_produto) {
        this.id_produto = id_produto;
        return this;
    }

    public String comando() {
        return comando;
    }

    public ProductCommand setComando(String comando) {
        this.comando = comando;
        return this;
    }

    public String args() {
        return args;
    }

    public ProductCommand setArgs(String args) {
        this.args = args;
        return this;
    }

    public boolean console() {
        return console;
    }

    public ProductCommand setConsole(boolean console) {
        this.console = console;
        return this;
    }

    public boolean temporario() {
        return temporario;
    }

    public ProductCommand setTemporario(boolean temporario) {
        this.temporario = temporario;
        return this;
    }

    public int dias_duracao() {
        return dias_duracao;
    }

    public ProductCommand setDias_duracao(int dias_duracao) {
        this.dias_duracao = dias_duracao;
        return this;
    }

    public ProductCommandType type() {
        return type;
    }

    public ProductCommand setType(ProductCommandType type) {
        this.type = type;
        return this;
    }

    public long criado_em() {
        return criado_em;
    }

    public ProductCommand setCriado_em(long criado_em) {
        this.criado_em = criado_em;
        return this;
    }

    public long atualizado_em() {
        return atualizado_em;
    }

    public ProductCommand setAtualizado_em(long atualizado_em) {
        this.atualizado_em = atualizado_em;
        return this;
    }
}
