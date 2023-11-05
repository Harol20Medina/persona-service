package com.msvc.persona.controller;


import com.msvc.persona.Service.PersonaService;
import com.msvc.persona.entities.Persona;
import com.msvc.persona.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;
//crear persona
    @PostMapping
    public ResponseEntity<Persona> guardarPersona (@RequestBody Persona personaRequest){
        Persona persona = personaService.savePersona(personaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(persona);
    }
    @GetMapping("/{personaId}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable String personaId) {
        Persona persona = personaService.getPersona(personaId);

        if (persona != null) {
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listarPersona(){
        List<Persona> personas = personaService.getAllPersona();
        return ResponseEntity.ok(personas);
    }

    @PutMapping("/{personaId}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable String personaId, @RequestBody Persona updatedPersona) {
        try {
            Persona persona = personaService.updatePersona(personaId, updatedPersona);
            return ResponseEntity.ok(persona);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{personaId}")
    public ResponseEntity<?> eliminarPersona(@PathVariable String personaId) {
        try {
            personaService.eliminarPersona(personaId);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
