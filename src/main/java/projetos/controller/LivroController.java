package projetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projetos.dto.LivroDTO;
import projetos.service.LivroService;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros() {

        List<LivroDTO> livros = livroService.listarTodos();

        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> adicionarNovoLivro(@RequestBody LivroDTO livroDTO) {

        LivroDTO novoLivro = livroService.salvarNovoLivro(livroDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizarUmLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {

        LivroDTO livroAtualizado = livroService.atualizarUmLivro(id, livroDTO);

        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.excluirLivro(id);
        return ResponseEntity.noContent().build();
    }

}
