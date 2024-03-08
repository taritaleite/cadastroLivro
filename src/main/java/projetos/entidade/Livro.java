package projetos.entidade;

import jakarta.persistence.*;
import projetos.dto.LivroDTO;

@Entity
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String edicao;

    private String isbn;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Long id, String titulo, String edicao, String isbn, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.edicao = edicao;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    public Livro(LivroDTO livroDTO) {
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
