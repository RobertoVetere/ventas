package com.holidevs.ventas;

import com.holidevs.ventas.modelos.Empleado;
import com.holidevs.ventas.modelos.Oficina;
import com.holidevs.ventas.repositorios.EmpleadoRepository;
import com.holidevs.ventas.repositorios.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class VentasApplication implements CommandLineRunner {
	@Autowired
	EmpleadoRepository empleadoRepository;

	@Autowired
	OficinaRepository oficinaRepository;
	public static void main(String[] args)  {
		SpringApplication.run(VentasApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Oficina oficina = new Oficina("123456789", "Calle Principal 123", "Ciudad", "Provincia", "12345", "Pais");
		Empleado empleado1 = new Empleado("asdfhs54","Juan", "Pérez", "123", "juan@example.com", "Licenciatura en Administración", true, oficina);
		Empleado empleado2 = new Empleado("sgsgasg654","María", "García", "456", "maria@example.com", "Ingeniería Informática", false, oficina);
		Empleado empleado3 = new Empleado("sdhsd6454","javier", "García", "456", "javier@example.com", "Ingeniería Informática", false, oficina);

		empleado2.setSupervisor(empleado1);
		empleado3.setSupervisor(empleado1);
		empleado1.agregarSubordinado(empleado2);
		empleado1.agregarSubordinado(empleado3);

		oficinaRepository.save(oficina);
		empleadoRepository.saveAll(List.of(empleado1,empleado2,empleado3));

		System.out.println("Los subordinados son: " + empleado1.getSubordinados());

	}
}
