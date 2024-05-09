package com.holidevs.ventas.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Empleado supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Empleado> subordinados = new ArrayList<>();

    @ManyToOne
    private Oficina oficina;

    public Empleado(String nombre, String apellidos, String extension, String email, String titulacionEstudiosMaximos, Oficina oficina) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.extension = extension;
        this.email = email;
        this.titulacionEstudiosMaximos = titulacionEstudiosMaximos;
        this.oficina = oficina;
    }

    public Empleado(String nombre, String apellidos, String extension, String email, String titulacionEstudiosMaximos, Empleado supervisor, List<Empleado> subordinados, Oficina oficina) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.extension = extension;
        this.email = email;
        this.titulacionEstudiosMaximos = titulacionEstudiosMaximos;
        this.supervisor = supervisor;
        this.subordinados = subordinados;
        this.oficina = oficina;
    }

    public Empleado(String nombre, String apellidos, String extension, String email, String titulacionEstudiosMaximos, List<Empleado> subordinados, Oficina oficina) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.extension = extension;
        this.email = email;
        this.titulacionEstudiosMaximos = titulacionEstudiosMaximos;
        this.subordinados = subordinados;
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

    public void asignarSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
        if (supervisor != null && !supervisor.getSubordinados().contains(this)) {
            supervisor.agregarSubordinado(this);
        }
    }

    public void agregarSubordinado(Empleado subordinado) {
        subordinados.add(subordinado);
        subordinado.setSupervisor(this);
    }

    public void removerSubordinado(Empleado subordinado) {
        subordinados.remove(subordinado);
        subordinado.setSupervisor(null);
    }

    public Empleado getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }
}
