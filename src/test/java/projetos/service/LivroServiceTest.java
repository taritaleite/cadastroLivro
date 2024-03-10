package projetos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import projetos.dto.LivroDTO;
import projetos.entidade.Categoria;
import projetos.entidade.Livro;
import projetos.repositorio.LivroRepositorio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivroServiceTest {

    @Mock
    private LivroRepositorio livroRepositorio;

    @InjectMocks
    private LivroService livroService;

    @Captor
    private ArgumentCaptor<Livro> livroCaptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void listarTodos_DeveRetornarListaDeLivros() {
        Livro livro1 = new Livro(1L, "Livro 1", "1ª Edição", "1234567890123", Categoria.TECNOLOGIA);
        Livro livro2 = new Livro(2L, "Livro 2", "2ª Edição", "9876543210987", Categoria.MEDICINA);

        when(livroRepositorio.findAll()).thenReturn(Arrays.asList(livro1, livro2));

        List<LivroDTO> livros = livroService.listarTodos();

        assertEquals(2, livros.size());
        verify(livroRepositorio, times(1)).findAll();
    }

    @Test
    public void salvarNovoLivro_DeveRetornarLivroSalvo() {
        LivroDTO novoLivroDTO = new LivroDTO(null, "Novo Livro", "1ª Edição", "1231231231231", Categoria.DIREITO);
        Livro livroSalvo = new Livro(1L, "Novo Livro", "1ª Edição", "1231231231231", Categoria.DIREITO);

        when(livroRepositorio.save(any(Livro.class))).thenReturn(livroSalvo);

        LivroDTO livroDTO = livroService.salvarNovoLivro(novoLivroDTO);

        assertNotNull(livroDTO.getId());
        assertEquals(novoLivroDTO.getTitulo(), livroDTO.getTitulo());
        verify(livroRepositorio, times(1)).save(any(Livro.class));
    }


    @Test
    public void atualizarUmLivro_DeveRetornarLivroAtualizado() {
        Long id = 1L;
        LivroDTO livroDTOAtualizado = new LivroDTO(id, "Livro Atualizado", "2ª Edição", "1234567890", Categoria.TECNOLOGIA);
        Livro livroExistente = new Livro(id, "Livro Original", "1ª Edição", "1234567890", Categoria.TECNOLOGIA);

        when(livroRepositorio.findById(id)).thenReturn(Optional.of(livroExistente));
        when(livroRepositorio.save(any(Livro.class))).thenReturn(new Livro(livroDTOAtualizado));

        LivroDTO resultado = livroService.atualizarUmLivro(id, livroDTOAtualizado);

        verify(livroRepositorio).save(livroCaptor.capture());
        Livro livroSalvo = livroCaptor.getValue();

        assertEquals("Livro Atualizado", livroSalvo.getTitulo());
        assertEquals("2ª Edição", livroSalvo.getEdicao());
        assertEquals("1234567890", livroSalvo.getIsbn());
        assertEquals(Categoria.TECNOLOGIA, livroSalvo.getCategoria());
    }


}