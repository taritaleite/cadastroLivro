package projetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetos.dto.LivroDTO;
import projetos.entidade.Livro;
import projetos.service.LivroService;

import java.util.List;
@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros() {

        List<LivroDTO> livros = livroService.findAll();

        return ResponseEntity.ok(livros);
    }
}
