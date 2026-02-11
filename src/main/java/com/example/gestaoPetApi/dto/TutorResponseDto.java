package com.example.gestaoPetApi.dto;


import java.io.Serializable;


public record TutorResponseDto(Long id,
                               String nome,
                               String email,
                               String telefone) implements Serializable {
}
