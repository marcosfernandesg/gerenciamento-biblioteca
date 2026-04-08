package com.formon.gerenciamentobiblioteca.controller;

import com.formon.gerenciamentobiblioteca.dto.EntregarLivroDTO;
import com.formon.gerenciamentobiblioteca.dto.LivroRequestDTO;
import com.formon.gerenciamentobiblioteca.entity.Livros;
import com.formon.gerenciamentobiblioteca.service.LivrosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private final LivrosService livrosService;

    public LivrosController(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @PostMapping
    public ResponseEntity<Livros> cadastrar(@RequestBody @Valid LivroRequestDTO dto) {
        Livros livros = livrosService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livros);
    }

    @GetMapping
    public ResponseEntity<List<Livros>> listarTodos() {
        return ResponseEntity.ok(livrosService.listarTodos());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livros> buscarPorIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(livrosService.buscarPorIsbn(isbn));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Livros>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(livrosService.buscarPorTitulo(titulo));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> remover(@PathVariable String isbn) {
        livrosService.remover(isbn);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{isbn}/entregar")
    public ResponseEntity<Livros> entregarLivro(
            @PathVariable String isbn,
            @RequestBody @Valid EntregarLivroDTO dto
    ) {
        Livros livros = livrosService.entregarLivro(isbn, dto.quantidade());
        return ResponseEntity.ok(livros);
    }
}