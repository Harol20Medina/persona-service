package com.msvc.persona.Service;

import com.msvc.persona.entities.Persona;

import java.util.List;

public interface PersonaService {

    Persona savePersona(Persona persona);

    List<Persona> getAllPersona();

    Persona getPersona(String personaId);


    Persona updatePersona(String personaId, Persona updatedPersona);
    void eliminarPersona(String personaId);
}
