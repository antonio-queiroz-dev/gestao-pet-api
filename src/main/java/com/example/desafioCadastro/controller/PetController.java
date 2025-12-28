package com.example.desafioCadastro.controller;

import com.example.desafioCadastro.dto.PetCreateDto;
import com.example.desafioCadastro.dto.PetResponseDto;
import com.example.desafioCadastro.dto.PetUpdateDto;
import com.example.desafioCadastro.model.Pet;
import com.example.desafioCadastro.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> listarPets() {
        List<PetResponseDto> pets = petService.listarPets();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity<PetResponseDto> cadastrarPet(@RequestBody PetCreateDto petdto) {
        Pet novoPet = petService.registrarPet(petdto);

        PetResponseDto response = new PetResponseDto(
                novoPet.getId(),
                novoPet.getNomePet(),
                novoPet.getPetTipo(),
                novoPet.getPetSexo(),
                novoPet.getPetEndereco(),
                novoPet.getIdade(),
                novoPet.getPeso(),
                novoPet.getRaca(),
                novoPet.getTutor().getId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody PetUpdateDto petDetails) {
        Pet updatePet = petService.updatePet(id, petDetails);
        return ResponseEntity.ok(updatePet);
    }

    @GetMapping("/buscar/nome")
    public ResponseEntity<List<PetResponseDto>> buscarPetPorNome(@RequestParam String nome) {
        List<PetResponseDto> petList = petService.buscarPorNome(nome);
        return ResponseEntity.ok(petList);
    }

    @GetMapping("/buscar/sexo")
    public ResponseEntity<List<PetResponseDto>> buscarPorSexo(@RequestParam String sexo) {
        List<PetResponseDto> petList = petService.buscarPorSexo(sexo);
        return ResponseEntity.ok(petList);
    }

    @GetMapping("/buscar/idade")
    public ResponseEntity<List<PetResponseDto>> buscarPorIdade(@RequestParam String idade) {
        List<PetResponseDto> petList = petService.buscarPorIdade(idade);
        return ResponseEntity.ok(petList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPet(@PathVariable Long id) {
        petService.deletarPet(id);
        return ResponseEntity.noContent().build();
    }
}
