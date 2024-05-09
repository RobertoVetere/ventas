package com.holidevs.ventas.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Oficina", nullable = false)
    private Long idOficina;

    private String telefono;
    private String direccion;
    private String poblacion;
    private String provincia;
    private String codigo_postal;
    private String pais;

    @OneToMany(mappedBy = "oficina")
    private List<Empleado> empleados = new ArrayList<>();

    public Oficina(String telefono, String direccion, String poblacion, String provincia, String codigo_postal, String pais) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
    }

    public Oficina(String telefono, String direccion, String poblacion, String provincia, String codigo_postal, String pais, List<Empleado> empleados) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
        this.empleados = empleados;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setOficina(this);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.setOficina(null);
    }

}
