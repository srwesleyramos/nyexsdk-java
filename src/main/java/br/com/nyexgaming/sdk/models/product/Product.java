package br.com.nyexgaming.sdk.models.product;

public class Product {

    private long id_produto;
    private long id_categoria;
    private long id_loja;

    private String nome;
    private String detalhes;
    private String imagem;

    private double preco;

    private int estoque;
    private int quantidade;

    private boolean usar_estoque;
    private boolean deletar_sem_estoque;

    private ProductCommand[] comandos;

    private long criado_em;
    private long atualizado_em;

    public Product(long id_produto, long id_categoria, long id_loja, String nome, String detalhes, String imagem, double preco, int estoque, int quantidade, boolean usar_estoque, boolean deletar_sem_estoque, ProductCommand[] comandos, long criado_em, long atualizado_em) {
        this.id_produto = id_produto;
        this.id_categoria = id_categoria;
        this.id_loja = id_loja;
        this.nome = nome;
        this.detalhes = detalhes;
        this.imagem = imagem;
        this.preco = preco;
        this.estoque = estoque;
        this.quantidade = quantidade;
        this.usar_estoque = usar_estoque;
        this.deletar_sem_estoque = deletar_sem_estoque;
        this.comandos = comandos;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public long id_produto() {
        return id_produto;
    }

    public Product setId_produto(long id_produto) {
        this.id_produto = id_produto;
        return this;
    }

    public long id_categoria() {
        return id_categoria;
    }

    public Product setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
        return this;
    }

    public long id_loja() {
        return id_loja;
    }

    public Product setId_loja(long id_loja) {
        this.id_loja = id_loja;
        return this;
    }

    public String nome() {
        return nome;
    }

    public Product setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String detalhes() {
        return detalhes;
    }

    public Product setDetalhes(String detalhes) {
        this.detalhes = detalhes;
        return this;
    }

    public String imagem() {
        return imagem;
    }

    public Product setImagem(String imagem) {
        this.imagem = imagem;
        return this;
    }

    public double preco() {
        return preco;
    }

    public Product setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public int estoque() {
        return estoque;
    }

    public Product setEstoque(int estoque) {
        this.estoque = estoque;
        return this;
    }

    public int quantidade() {
        return quantidade;
    }

    public Product setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public boolean usar_estoque() {
        return usar_estoque;
    }

    public Product setUsar_estoque(boolean usar_estoque) {
        this.usar_estoque = usar_estoque;
        return this;
    }

    public boolean deletar_sem_estoque() {
        return deletar_sem_estoque;
    }

    public Product setDeletar_sem_estoque(boolean deletar_sem_estoque) {
        this.deletar_sem_estoque = deletar_sem_estoque;
        return this;
    }

    public ProductCommand[] comandos() {
        return comandos;
    }

    public Product setComandos(ProductCommand[] comandos) {
        this.comandos = comandos;
        return this;
    }

    public long criado_em() {
        return criado_em;
    }

    public Product setCriado_em(long criado_em) {
        this.criado_em = criado_em;
        return this;
    }

    public long atualizado_em() {
        return atualizado_em;
    }

    public Product setAtualizado_em(long atualizado_em) {
        this.atualizado_em = atualizado_em;
        return this;
    }
}
