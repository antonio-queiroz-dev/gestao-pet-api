package com.example.desafioCadastro.utils;

import com.example.desafioCadastro.dto.PetCreateDto;
import org.springframework.stereotype.Component;

@Component
public class PetValidator {

    public static final String NAO_INFORMADO = "NAO INFORMADO";

    public void validarPetCreate(PetCreateDto pet) {
        pet.setNomePet(validarNomeCreate(pet.getNomePet()));
        pet.setIdade(validarIdadeCreate(pet.getIdade()));
        pet.setPeso(validarPesoCreate(pet.getPeso()));
        pet.setRaca(validarRacaCreate(pet.getRaca()));
    }

    private String validarNomeCreate(String nome) {
        if (nome == null || nome.isBlank()) {
            return NAO_INFORMADO;
        }
        validarNome(nome);
        return nome;
    }

    private String validarIdadeCreate(String idade) {
        if (idade == null || idade.isBlank()) {
            return NAO_INFORMADO;
        }
        validarIdade(idade);
        return idade;
    }

    private String validarPesoCreate(String peso) {
        if (peso == null || peso.isBlank()) {
            return NAO_INFORMADO;
        }
        validarPeso(peso);
        return peso;
    }

    private String validarRacaCreate(String raca) {

        if (raca == null || raca.isBlank()) {
            return NAO_INFORMADO;
        }
        validarRaca(raca);
        return raca;
    }

    public void validarNome(String nome) {
        String[] partes = nome.trim().split("\\s+");
        if (partes.length < 2) {
            throw new IllegalArgumentException("Precisa ter nome e sobrenome");
        }

        if (!nome.matches("^[A-Za-zÀ-ÿ ]+$")) {
            throw new IllegalArgumentException("Nome não pode conter números ou caracteres especiais");
        }
    }

    public void validarIdade(String idade) {

        if (!idade.matches("^[0-9.,]+$")) {
            throw new IllegalArgumentException("Sómente números são validos");
        }

        double idadeRecebida = Double.parseDouble(idade.replace(",", "."));
        if (idadeRecebida > 20) {
            throw new IllegalArgumentException("Idade maiores que 20 são invalidas");
        }
    }

    public void validarPeso(String peso) {

        if (!peso.matches("[0-9.,]+$")) {
            throw new IllegalArgumentException("Sómente números são validos");
        }

        double pesoRecebido = Double.parseDouble(peso.replace(",", "."));
        if (pesoRecebido < 0.5 || pesoRecebido > 60) {
            throw new IllegalArgumentException("O Peso deve estár no intervalo de 0.5 a 60 kg");
        }
    }

    public void validarRaca(String raca) {

        if (!raca.matches("[A-Za-z]+$")) {
            throw new IllegalArgumentException("Caracteres especiais e números não são permitidos");
        }
    }

}
