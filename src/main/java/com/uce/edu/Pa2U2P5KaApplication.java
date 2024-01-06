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


    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Libro libro1 = new Libro();
        libro1.setTitulo("JAVA");
        libro1.setFechaPublicacion(LocalDateTime.now());

        Autor autor1 = new Autor();
        autor1.setNombre("Pepito Perez");
        autor1.setNacionalidad("Ecuatoriano");
        // TODO Set

        Autor autor2 = new Autor();
        autor2.setNombre("Daniel Teran");
        autor2.setNacionalidad("Ecuatoriano");
        // TODO Set

        Set<Autor> autores = new HashSet<>();
        autores.add(autor1);
        autores.add(autor2);

        libro1.setAutores(autores);

        Set<Libro> libros = new HashSet<>();
        libros.add(libro1);

        autor1.setLibros(libros);
        autor2.setLibros(libros);

        // INSERTAR LIBRO con sus autores (CASCADE)
        System.out.println("INSETANDO LIBRO y autores (por atributo cascade)");
        this.iLibroService.guardar(libro1);
    }
}
