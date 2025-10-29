package com.example.desafioCadastro.dto;

import com.example.desafioCadastro.model.PetEndereco;

public record PetUpdateDto(String nomePet,
                           PetEndereco petEndereco,
                           String idade,
                           String peso,
                           String raca ) {
}