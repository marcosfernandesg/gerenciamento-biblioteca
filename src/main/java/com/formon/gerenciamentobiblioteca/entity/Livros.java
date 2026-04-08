package com.formon.gerenciamentobiblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Livros")
public class Livros {
    @Id
    private String isbn;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private Integer estoque;

}
