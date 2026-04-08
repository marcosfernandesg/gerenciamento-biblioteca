package com.formon.gerenciamentobiblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(

        @NotBlank(message = "Título obrigatório")
        String titulo,

        @NotBlank(message = "Autor obrigatório")
        String autor,

        @NotBlank(message = "ISBN obrigatório")
        String isbn,

        @NotNull(message = "Ano obrigatório")
        Integer anoPublicacao,

        @NotNull(message = "Estoque obrigatório")
        Integer estoque

) {}