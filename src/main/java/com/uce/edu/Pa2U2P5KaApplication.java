package com.uce.edu;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {
    @Autowired
    private IEstudianteService iEstudianteService;
    @Autowired
    private IAlumnoService iAlumnoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		// Seleccionar
//		Estudiante estudiante1 = new Estudiante();
//		estudiante1.setNombre("Kevin");
//		estudiante1.setApellido("Andrade");
//		estudiante1.setCedula("0402068555");
//		estudiante1.setFechaNacimiento(LocalDateTime.of(2002,06,03,07,50));
//
//		this.iEstudianteService.registrar(estudiante1);
//		// Buscar
//		Estudiante estudianteObtenido = this.iEstudianteService.buscar(752);
//		System.out.println("\n>>Estudiante Actualizado");
//		System.out.println(estudianteObtenido.toString());
//
//		// Actualizar
//		Estudiante estudianteActu = new Estudiante();
//		estudianteActu.setNombre("Kevin");
//		estudianteActu.setApellido("Andrade");
//		estudianteActu.setCedula("011111111");
//		estudianteActu.setFechaNacimiento(LocalDateTime.of(2002,06,03,07,50));
//		System.out.println(" \n>>Imprimir Estudiante Actualizado");
//		this.iEstudianteService.actualizar(estudianteActu);
//		System.out.println(this.iEstudianteService.buscar(402));
//
//		// Eliminar
//		this.iEstudianteService.eliminar(2);
//		System.out.println(this.iEstudianteService.buscar(2));

		// Insertar Alumno
		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Felipe");
		this.iAlumnoService.registrar(alumno2);

        // Buscar Alumno
        Alumno alumnoBuscado = this.iAlumnoService.buscar(2);
        System.out.println("\n>>Estudiante Actualizado");
		System.out.println(alumnoBuscado.toString());

        // Actualizar Alumno
		Alumno alumnoActualizado = new Alumno();
		alumnoActualizado.setNombre("Jonh");
		this.iAlumnoService.actualizar(alumnoActualizado);

        // Eliminar Usuario
         this.iAlumnoService.eliminar(2);


    }
}
