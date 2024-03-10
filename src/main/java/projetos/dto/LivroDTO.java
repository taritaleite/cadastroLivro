package projetos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import projetos.entidade.Categoria;
import projetos.entidade.Livro;

public class LivroDTO {

    private Long id;


    @NotBlank(message = "O título não pode estar vazio.")
    @Size(max = 100, message = "O título não pode ter mais de 100 caracteres.")
    private String titulo;

    @NotBlank(message = "A edição não pode estar vazia.")
    private String edicao;

    @NotBlank(message = "O ISBN não pode estar vazio.")
    @Size(min = 10, max = 13, message = "O ISBN deve ter entre 10 e 13 caracteres.")
    private String isbn;

    @NotNull(message = "A categoria não pode ser nula.")
    private Categoria categoria;

    public LivroDTO() {
    }

    public LivroDTO(Long id, String titulo, String edicao, String isbn, Categoria categoria) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
