package com.msvc.persona.Service.impl;


import com.msvc.persona.Service.PersonaService;
import com.msvc.persona.entities.Persona;
import com.msvc.persona.exceptions.ResourceNotFoundException;
import com.msvc.persona.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class PersonaServiceImpl implements PersonaService {

    private Logger logger = LoggerFactory.getLogger(PersonaService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Persona savePersona(Persona persona) {
        String randomPersonaID = UUID.randomUUID().toString();
        persona.setPersonaId(randomPersonaID);
        return personaRepository.save(persona);
    }


    @Override
    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @Override
    public Persona getPersona(String personaId) {
        Persona persona = personaRepository.findById(personaId).orElseThrow( () -> new ResourceNotFoundException("Persona no encontrado con el Id : " + personaId));
        return personaRepository.save(persona);
    }

    @Override
    public Persona updatePersona(String personaId, Persona updatedPersona) {
        Persona persona = personaRepository.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con el Id: " + personaId));

        persona.setN_persona(updatedPersona.getN_persona());
        persona.setA_materno(updatedPersona.getA_materno());
        persona.setEmail(updatedPersona.getEmail());
        persona.setTelefono(updatedPersona.getTelefono());

        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(String personaId) {
        Persona persona = personaRepository.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con el Id: " + personaId));
        personaRepository.delete(persona);
    }


}



