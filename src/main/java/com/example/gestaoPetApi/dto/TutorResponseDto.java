package com.example.gestaoPetApi.dto;


import com.example.gestaoPetApi.model.EnderecoTutor;

import java.io.Serializable;


public record TutorResponseDto(Long id,
                               String nome,
                               String email,
                               String telefone,
                               EnderecoTutor enderecoTutor) implements Serializable {
}
