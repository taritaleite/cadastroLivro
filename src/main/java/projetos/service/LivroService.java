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

    public List<LivroDTO> findAll() {
        List<Livro> listaLivros = repositorio.findAll();

        return listaLivros.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
