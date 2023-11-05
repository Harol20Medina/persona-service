package com.msvc.persona.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "id")
    private String personaId;

    @Column(name = "n_persona")
    private String n_persona;

    @Column(name = "a_materno")
    private String a_materno;

    @Column(name = "a_paterno")
    private String a_paterno;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "dni")
    private String dni;
}
