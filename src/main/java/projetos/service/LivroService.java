package projetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetos.dto.LivroDTO;
import projetos.entidade.Livro;
import projetos.repositorio.LivroRepositorio;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepositorio repositorio;

    public List<LivroDTO> listarTodos() {

        List<Livro> listaLivros = repositorio.findAll();

        return listaLivros.stream().map(LivroDTO::new).collect(Collectors.toList());
    }

    public LivroDTO salvarNovoLivro(LivroDTO livroDTO) {

        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setEdicao(livroDTO.getEdicao());
        livro.setIsbn(livroDTO.getIsbn());
        livro.setCategoria(livroDTO.getCategoria());

        livro = repositorio.save(livro);

        return new LivroDTO(livro);
    }

    public LivroDTO atualizarUmLivro(Long id, LivroDTO livroDTO) {
        Livro livro = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(livroDTO.getTitulo());
        livro.setEdicao(livroDTO.getEdicao());
        livro.setIsbn(livroDTO.getIsbn());
        livro.setCategoria(livroDTO.getCategoria());

        livro = repositorio.save(livro);
        return new LivroDTO(livro);
    }


    public void excluirLivro(Long id) {
        repositorio.deleteById(id);
    }
}
