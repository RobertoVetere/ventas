package com.holidevs.ventas.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long numeroEmpleado;

    public Long getNumeroEmpleado() {
        return numeroEmpleado;
    }
    private String nombre;
    private String apellidos;
    private String extension;
    private String email;
    private String titulacionEstudiosMaximos;

    public Empleado(String nombre, String apellidos, String extension, String email, String titulacionEstudiosMaximos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.extension = extension;
        this.email = email;
        this.titulacionEstudiosMaximos = titulacionEstudiosMaximos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitulacionEstudiosMaximos(String titulacionEstudiosMaximos) {
        this.titulacionEstudiosMaximos = titulacionEstudiosMaximos;
    }
}
