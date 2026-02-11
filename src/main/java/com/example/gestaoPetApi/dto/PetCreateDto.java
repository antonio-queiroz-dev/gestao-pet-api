package com.example.gestaoPetApi.dto;

import com.example.gestaoPetApi.model.PetEndereco;
import com.example.gestaoPetApi.model.PetSexo;
import com.example.gestaoPetApi.model.PetTipo;

public class PetCreateDto {
    String nomePet;
    PetTipo petTipo;
    PetSexo petSexo;
    PetEndereco petEndereco;
    String idade;
    String peso;
    String raca;

    Long tutorId;

    public PetCreateDto(String nomePet, PetTipo petTipo, PetSexo petSexo, PetEndereco petEndereco, String idade, String peso, String raca, Long tutorId) {
        this.nomePet = nomePet;
        this.petTipo = petTipo;
        this.petSexo = petSexo;
        this.petEndereco = petEndereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
        this.tutorId = tutorId;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public PetTipo getPetTipo() {
        return petTipo;
    }

    public void setPetTipo(PetTipo petTipo) {
        this.petTipo = petTipo;
    }

    public PetSexo getPetSexo() {
        return petSexo;
    }

    public void setPetSexo(PetSexo petSexo) {
        this.petSexo = petSexo;
    }

    public PetEndereco getPetEndereco() {
        return petEndereco;
    }

    public void setPetEndereco(PetEndereco petEndereco) {
        this.petEndereco = petEndereco;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }
}
