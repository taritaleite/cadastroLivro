package projetos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import projetos.dto.LivroDTO;
import projetos.entidade.Categoria;
import projetos.service.LivroService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LivroController.class)
class LivroControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivroService livroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void listarLivros_DeveRetornarLivros() throws Exception {

        List<LivroDTO> livros = new ArrayList<>();

        livros.add(new LivroDTO(1L, "Manual de Direito Civil - Vol. Único", "14ª", "6559649873", Categoria.DIREITO));

        when(livroService.listarTodos()).thenReturn(livros);

        mockMvc.perform(get("/livros")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(livros.size())))
                .andExpect(jsonPath("$[0].titulo").value(livros.get(0).getTitulo()))
                .andExpect(jsonPath("$[0].edicao").value(livros.get(0).getEdicao()))
                .andExpect(jsonPath("$[0].isbn").value(livros.get(0).getIsbn()))
                .andExpect(jsonPath("$[0].categoria", is(Categoria.DIREITO.toString())));
        ;

    }

    @Test
    public void adicionarNovoLivro_DeveRetornarLivroCriado() throws Exception {

        //Simulação incluindo o Id
        LivroDTO novoLivroDTO = new LivroDTO(null, "Manual de Direito Civil", "1ª Edição", "1234567890123", Categoria.DIREITO);
        LivroDTO livroSalvoDTO = new LivroDTO(1L, "Manual de Direito Civil", "1ª Edição", "1234567890123", Categoria.DIREITO);

        when(livroService.salvarNovoLivro(novoLivroDTO)).thenReturn(livroSalvoDTO);

        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novoLivroDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.titulo", is(livroSalvoDTO.getTitulo())))
                .andExpect(jsonPath("$.edicao", is(livroSalvoDTO.getEdicao())))
                .andExpect(jsonPath("$.isbn", is(livroSalvoDTO.getIsbn())))
                .andExpect(jsonPath("$.categoria", is(livroSalvoDTO.getCategoria().toString())));

    }

    @Test
    public void atualizarUmLivro_DeveRetornarLivroAtualizado() throws Exception {
        Long livroId = 1L;
        LivroDTO livroDTO = new LivroDTO(livroId, "Manual de Direito Civil - Volume Único", "1ª Edição", "1234567890123", Categoria.DIREITO);
        LivroDTO livroAtualizadoDTO = new LivroDTO(livroId, "Manual de Direito Civil", "1ª Edição", "1234567890123", Categoria.DIREITO);


        when(livroService.atualizarUmLivro(ArgumentMatchers.eq(livroId), ArgumentMatchers.any(LivroDTO.class))).thenReturn(livroAtualizadoDTO);

        mockMvc.perform(put("/livros/{id}", livroId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livroDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(livroAtualizadoDTO.getId().intValue())))
                .andExpect(jsonPath("$.titulo", is(livroAtualizadoDTO.getTitulo())))
                .andExpect(jsonPath("$.edicao", is(livroAtualizadoDTO.getEdicao())))
                .andExpect(jsonPath("$.isbn", is(livroAtualizadoDTO.getIsbn())))
                .andExpect(jsonPath("$.categoria", is(livroAtualizadoDTO.getCategoria().toString())));
    }

}