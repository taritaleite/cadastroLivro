package projetos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetos.entidade.Livro;

import java.util.List;

@Repository
public interface LivroRepositorio extends JpaRepository <Livro, Long> {

    List<Livro> findAll();
}
