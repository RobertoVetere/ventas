package com.holidevs.ventas.modelos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String numeroEmpleado;
    private String nombre;
    private String apellidos;
    private String extension;
    private String email;
    private String titulacionEstudiosMaximos;
    private boolean esSupervisor;
    @ManyToOne
    private Oficina oficina;

    @ManyToOne
    private Empleado supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Empleado> subordinados = new ArrayList<>();

    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }

    public Empleado(String numeroEmpleado, String nombre, String apellidos, String extension, String email, String titulacionEstudiosMaximos, boolean esSupervisor, Oficina oficina) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.extension = extension;
        this.email = email;
        this.titulacionEstudiosMaximos = titulacionEstudiosMaximos;
        this.esSupervisor = esSupervisor;
        this.oficina = oficina;
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

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public List<Empleado> getSubordinados() {
        return subordinados;
    }

    public void agregarSubordinado(Empleado subordinado) {
        subordinados.add(subordinado);
    }


    public boolean isEsSupervisor() {
        return esSupervisor;
    }

    public void setEsSupervisor(boolean esSupervisor) {
        this.esSupervisor = esSupervisor;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", titulacionEstudiosMaximos='" + titulacionEstudiosMaximos + '\'' +
                ", esSupervisor=" + esSupervisor +
                ", oficina=" + oficina +
                ", supervisor=" + supervisor +
                '}';
    }
}