package br.com.nyexgaming.sdk.models.category;

public class Category {

    private long id_categoria;
    private long id_loja;
    private long id_servidor;

    private String nome;
    private String descricao;
    private String imagem;
    private String slug;
    private int position;

    private long criado_em;
    private long atualizado_em;

    public Category(long id_categoria, long id_loja, long id_servidor, String nome, String descricao, String imagem, String slug, int position, long criado_em, long atualizado_em) {
        this.id_categoria = id_categoria;
        this.id_loja = id_loja;
        this.id_servidor = id_servidor;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.slug = slug;
        this.position = position;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public long id_categoria() {
        return id_categoria;
    }

    public Category setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
        return this;
    }

    public long id_loja() {
        return id_loja;
    }

    public Category setId_loja(long id_loja) {
        this.id_loja = id_loja;
        return this;
    }

    public long id_servidor() {
        return id_servidor;
    }

    public Category setId_servidor(long id_servidor) {
        this.id_servidor = id_servidor;
        return this;
    }

    public String nome() {
        return nome;
    }

    public Category setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String descricao() {
        return descricao;
    }

    public Category setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String imagem() {
        return imagem;
    }

    public Category setImagem(String imagem) {
        this.imagem = imagem;
        return this;
    }

    public String slug() {
        return slug;
    }

    public Category setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public int position() {
        return position;
    }

    public Category setPosition(int position) {
        this.position = position;
        return this;
    }

    public long criado_em() {
        return criado_em;
    }

    public Category setCriado_em(long criado_em) {
        this.criado_em = criado_em;
        return this;
    }

    public long atualizado_em() {
        return atualizado_em;
    }

    public Category setAtualizado_em(long atualizado_em) {
        this.atualizado_em = atualizado_em;
        return this;
    }
}
