package projetos.dto;

import projetos.entidade.Livro;

public class LivroDTO {

    private Long id;

    private String titulo;

    private String edicao;

    private String isbn;

    private String categoria;

    public LivroDTO() {
    }

    public LivroDTO(Long id, String titulo, String edicao, String isbn, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    public LivroDTO(Livro entidade) {
        this.id = entidade.getId();
        this.titulo = entidade.getTitulo();
        this.edicao = entidade.getEdicao();
        this.isbn = entidade.getIsbn();
        this.categoria = entidade.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
