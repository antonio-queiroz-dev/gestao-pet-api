package com.example.gestaoPetApi.dto;

import com.example.gestaoPetApi.model.PetEndereco;
import com.example.gestaoPetApi.model.PetSexo;
import com.example.gestaoPetApi.model.PetTipo;

import java.io.Serializable;

public record PetResponseDto(Long id,
                             String nomePet,
                             PetTipo petTipo,
                             PetSexo petSexo,
                             PetEndereco petEndereco,
                             String idade,
                             String peso,
                             String raca,
                             Long tutorId) implements Serializable { }
