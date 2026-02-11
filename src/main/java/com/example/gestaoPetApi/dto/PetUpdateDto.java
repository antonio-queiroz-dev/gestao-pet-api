package com.example.gestaoPetApi.dto;

import com.example.gestaoPetApi.model.PetEndereco;

public record PetUpdateDto(String nomePet,
                           PetEndereco petEndereco,
                           String idade,
                           String peso,
                           String raca ) {
}