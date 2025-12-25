package com.example.desafioCadastro.repository;

import com.example.desafioCadastro.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findByNomeContainingIgnoreCase(String nome);
    List<Tutor> findByEmailContainingIgnoreCase(String email);

}
