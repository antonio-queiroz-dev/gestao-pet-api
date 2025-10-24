package com.example.desafioCadastro.service;

import com.example.desafioCadastro.model.Pet;
import com.example.desafioCadastro.repository.PetRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRespository petRespository;

    public PetService(PetRespository petRespository) {
        this.petRespository = petRespository;
    }

    public List<Pet> listarPets() {
        return petRespository.findAll();
    }

    public Pet registrarPet(Pet pet) {
        return petRespository.save(pet);
    }

    public Pet updatePet(Long id, Pet petDetails) {
        Optional<Pet> optionalPet = petRespository.findById(id);

        if (optionalPet.isEmpty()) {
            throw new RuntimeException("Pet com o ID: "+ id + " não encontrado");
        }

        Pet existingPet = optionalPet.get();

        existingPet.setNomePet(petDetails.getNomePet());
        existingPet.setPetEndereco(petDetails.getPetEndereco());
        existingPet.setIdade(petDetails.getIdade());
        existingPet.setPeso(petDetails.getPeso());
        existingPet.setRaca(petDetails.getRaca());

        return petRespository.save(existingPet);
    }
}
