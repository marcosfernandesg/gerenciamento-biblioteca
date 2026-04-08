package com.formon.gerenciamentobiblioteca.dto;

import jakarta.validation.constraints.NotNull;

public record EntregarLivroDTO(

        @NotNull(message = "Quantidade obrigatória")
        Integer quantidade

) {}