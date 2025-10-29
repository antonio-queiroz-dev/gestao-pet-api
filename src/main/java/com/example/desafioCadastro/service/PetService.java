package com.example.desafioCadastro.service;

import com.example.desafioCadastro.dto.PetUpdateDto;
import com.example.desafioCadastro.model.Pet;
import com.example.desafioCadastro.model.PetSexo;
import com.example.desafioCadastro.repository.PetRepository;
import com.example.desafioCadastro.utils.PetValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final PetValidator petValidator;

    public PetService(PetRepository petRepository, PetValidator petValidator) {
        this.petRepository = petRepository;
        this.petValidator = petValidator;
    }

    public List<Pet> listarPets() {
        return petRepository.findAll();
    }

    public Pet registrarPet(Pet pet) {
        petValidator.validar(pet);

        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, PetUpdateDto petDetails) {
        Optional<Pet> optionalPet = petRepository.findById(id);

        if (optionalPet.isEmpty()) {
            throw new RuntimeException("Pet com o ID: " + id + " não encontrado");
        }

        Pet existingPet = optionalPet.get();

        if (petDetails.nomePet() != null) {
            existingPet.setNomePet(petDetails.nomePet());
        }
        if (petDetails.petEndereco() != null) {
            existingPet.setPetEndereco(petDetails.petEndereco());
        }
        if (petDetails.idade() != null) {
            existingPet.setIdade(petDetails.idade());
        }
        if (petDetails.peso() != null) {
            existingPet.setPeso(petDetails.peso());
        }
        if (petDetails.raca() != null) {
            existingPet.setRaca(petDetails.raca());
        }

        return petRepository.save(existingPet);
    }

    public List<Pet> buscar(String termo) {

        if (termo.equalsIgnoreCase("macho") || termo.equalsIgnoreCase("femea")) {
            return petRepository.findByPetSexo(PetSexo.valueOf(termo.toUpperCase()));
        }

        if (termo.matches("\\d+")) {
            return petRepository.findByIdadeContainingIgnoreCase(termo);
        }

        return petRepository.findByNomePetContainingIgnoreCase(termo);
    }
}
