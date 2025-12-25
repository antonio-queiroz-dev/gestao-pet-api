package com.example.desafioCadastro.dto;


import com.example.desafioCadastro.model.Pet;

import java.io.Serializable;


public record TutorResponseDto(Long id,
                               String nome,
                               String email,
                               String telefone) implements Serializable {
}
