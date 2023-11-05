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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    private String usuarioId;

    @Column(name = "nombres", length = 20)
    private String nombres;

    @Column(name = "apellidos", length = 20)
    private String apellidos;

    @Column(name = "correo")
    private  String correo;

    @Column(name = "sexo")
    private  String sexo;




}
