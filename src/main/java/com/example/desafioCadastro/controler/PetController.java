package com.example.desafioCadastro.controler;

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
    public ResponseEntity<List<Pet>> listarPets() {
        List<Pet> pets = petService.listarPets();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet) {
        Pet novoPet = petService.registrarPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody PetUpdateDto petDetails) {
        Pet updatePet = petService.updatePet(id, petDetails);
        return ResponseEntity.ok(updatePet);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Pet>> buscarPet(@RequestParam String termo) {
        List<Pet> petList = petService.buscar(termo);
        return ResponseEntity.ok(petList);
    }
}
