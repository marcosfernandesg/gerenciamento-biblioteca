package com.formon.gerenciamentobiblioteca.repository;

import com.formon.gerenciamentobiblioteca.entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivrosRepository extends JpaRepository<Livros, String> {

    List<Livros> findByTituloContainingIgnoreCase(String titulo);
}