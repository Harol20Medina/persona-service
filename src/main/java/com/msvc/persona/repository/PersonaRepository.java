package com.msvc.persona.repository;


import com.msvc.persona.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
}
