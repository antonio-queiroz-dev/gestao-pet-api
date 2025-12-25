package com.example.desafioCadastro.utils;

import com.example.desafioCadastro.dto.PetCreateDto;
import com.example.desafioCadastro.model.PetEndereco;
import com.example.desafioCadastro.model.PetSexo;
import com.example.desafioCadastro.model.PetTipo;
import com.example.desafioCadastro.model.Tutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PetValidatorTest {

    private final PetValidator validator = new PetValidator();

    @Test
    @DisplayName("Deve preencher campos em branco com 'NAO INFORMADO'")
    void devePreencherCamposEmBranco() {
        Tutor tutor = new Tutor();
        tutor.setNome("João");

        PetEndereco endereco = new PetEndereco();
        endereco.setRua("Rua das Acácias");
        endereco.setCidade("Belo Horizonte");
        endereco.setNumeroCasa("55");
        PetCreateDto pet = new PetCreateDto(null, PetTipo.GATO, PetSexo.MACHO, endereco,    "", "", "",tutor.getId());

        validator.validarPetCreate(pet);

        Assertions.assertEquals(PetValidator.NAO_INFORMADO, pet.getNomePet());
        Assertions.assertEquals(PetValidator.NAO_INFORMADO, pet.getIdade());
        Assertions.assertEquals(PetValidator.NAO_INFORMADO, pet.getPeso());
        Assertions.assertEquals(PetValidator.NAO_INFORMADO, pet.getRaca());

    }

    @Test
    @DisplayName("Deve lançar exceção se o nome não tiver um sobrenome")
    void deveLancarExecaoNomeSobrenome() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {validator.validarNome("João");});
    }

    @Test
    @DisplayName("Deve lançar exceção se o nome tiver caracteres especiais")
    void deveLancarExecaoCaracteresEspeciais() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarNome("Jo@o"));
    }

    @Test
    @DisplayName("Deve lançar exceção se a idade conter caracteres especias")
    void deveLancarExecaoIdadeCaracteresEspeciais() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarIdade("1!"));
    }

    @Test
    @DisplayName("Deve lançar exceção se a idade for maior que 20")
    void deveLancarExecaoIdadeMaior() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarIdade("21"));
    }

    @Test
    @DisplayName("Deve lançar exceção se o peso conter caracteres especias")
    void deveLancarExecaoPesoCaracteresEspeciais() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarPeso("5.!"));
    }

    @Test
    @DisplayName("Deve lançar exceção se o peso for menor que 0.5")
    void deveLancarExecaoPesoMenor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarPeso("0.3"));
    }

    @Test
    @DisplayName("Deve lançar exceção se o peso for maior que 60")
    void deveLancarExecaoPesoMaior() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarPeso("61"));
    }

    @Test
    @DisplayName("Deve lançar exceção se o nome da raça conter caracteres especiais")
    void deveLancarExcecaoNomeCaracteresEspeciais() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validarRaca("Vir@lat@"));
    }
}