package com.uce.edu;

import com.uce.edu.repository.modelo.*;
import com.uce.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {
    @Autowired
    private ILibroService iLibroService;

    @Autowired
    private IAutorService iAutorService;


    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        // INSERTAR Libro hecho por varios Autores
//        Libro libro1 = new Libro();
//        libro1.setTitulo("Aprende GIT");
//        libro1.setFechaPublicacion(LocalDateTime.now());
//
//        Autor autor1 = new Autor();
//        autor1.setNombre("Miguel Ángel");
//        autor1.setNacionalidad("Colombiano");
//
//        Autor autor2 = new Autor();
//        autor2.setNombre("Mario Vega");
//        autor2.setNacionalidad("Ecuatoriano");
//
//        Set<Autor> autores = new HashSet<>();
//        autores.add(autor1);
//        autores.add(autor2);
//
//        libro1.setAutores(autores);
//
//        Set<Libro> libros = new HashSet<>();
//        libros.add(libro1);
//
//        autor1.setLibros(libros);
//        autor2.setLibros(libros);
//
//        System.out.println(">>>INSETANDO Libro y sus autores (cascade)");
//        this.iLibroService.guardar(libro1);
//
//       //  INSERTAR Libro con varios Libros
//
//        Autor autorX = new Autor();
//        autorX.setNombre("Carlos Crespo");
//        autorX.setNacionalidad("Ecuatoriano");
//
//        Libro libroA = new Libro();
//        libroA.setTitulo("HTML para principiantes");
//        libroA.setFechaPublicacion(LocalDateTime.now());
//
//        Libro libroB = new Libro();
//        libroB.setTitulo("Manejo del DOM");
//        libroB.setFechaPublicacion(LocalDateTime.now());
//
//        Libro libroC = new Libro();
//        libroC.setTitulo("Javascript Moderno");
//        libroC.setFechaPublicacion(LocalDateTime.now());
//
//        Set<Autor> autoresX = new HashSet<>();
//        autoresX.add(autorX);
//
//        Set<Libro> librosX = new HashSet<>();
//        librosX.add(libroA);
//        librosX.add(libroB);
//        librosX.add(libroC);
//
//        autorX.setLibros(librosX);
//
//        libroA.setAutores(autoresX);
//        libroB.setAutores(autoresX);
//        libroC.setAutores(autoresX);
//
//        System.out.println(">>>INSETANDO/Registrando Autor y sus Libros (cascade)");
//        iAutorService.registrar(autorX);

//        // Actualizar Libro y Autor
//
//        Autor autorActualizado = new Autor();
//        autorActualizado.setNombre("Carlos Santana");
//        autorActualizado.setNacionalidad("Ecuatoriano");
//        autorActualizado.setId(1);
//
//        System.out.println(">>> ACTUALIZANDO Autor");
//        this.iAutorService.actualizar(autorActualizado);

        // BUSCAR Autor
        Autor aut = this.iAutorService.buscar(1);
        System.out.println(aut);

    }
}
