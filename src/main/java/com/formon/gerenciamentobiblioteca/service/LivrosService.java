package com.formon.gerenciamentobiblioteca.service;

import com.formon.gerenciamentobiblioteca.dto.LivroRequestDTO;
import com.formon.gerenciamentobiblioteca.entity.Livros;
import com.formon.gerenciamentobiblioteca.repository.LivrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {

    private final LivrosRepository livrosRepository;

    public LivrosService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public Livros cadastrar(LivroRequestDTO dto) {
        if (livrosRepository.existsById(dto.isbn())) {
            throw new RuntimeException("Já existe um livro com esse ISBN.");
        }

        Livros livro = new Livros();
        livro.setIsbn(dto.isbn());
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setAnoPublicacao(dto.anoPublicacao());
        livro.setEstoque(dto.estoque());

        return livrosRepository.save(livro);
    }

    public List<Livros> listarTodos() {
        return livrosRepository.findAll();
    }

    public Livros buscarPorIsbn(String isbn) {
        return livrosRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado."));
    }

    public List<Livros> buscarPorTitulo(String titulo) {
        return livrosRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public void remover(String isbn) {
        if (!livrosRepository.existsById(isbn)) {
            throw new RuntimeException("Livro não encontrado.");
        }

        livrosRepository.deleteById(isbn);
    }

    public Livros entregarLivro(String isbn, Integer quantidade) {
        Livros livro = buscarPorIsbn(isbn);

        if (quantidade == null || quantidade <= 0) {
            throw new RuntimeException("A quantidade deve ser maior que zero.");
        }

        if (livro.getEstoque() < quantidade) {
            throw new RuntimeException("Estoque insuficiente.");
        }

        livro.setEstoque(livro.getEstoque() - quantidade);

        return livrosRepository.save(livro);
    }
}