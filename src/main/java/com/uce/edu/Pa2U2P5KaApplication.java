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


    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // INSERTAR Libro2 hecho por varios Autor2es
        Libro2 libro1 = new Libro2();
        libro1.setTitulo("JAVA2");
        libro1.setFechaPublicacion(LocalDateTime.now());

        Autor2 autor1 = new Autor2();
        autor1.setNombre("Pepito Perez 2");
        autor1.setNacionalidad("Ecuatoriano2");

        Autor2 autor2 = new Autor2();
        autor2.setNombre("Daniel Teran 2");
        autor2.setNacionalidad("Ecuatoriano2");

        // TABLA DE ROMPIMIENTO------
        // Primer registro
        AutorLibro autorLibro1 = new AutorLibro();
        autorLibro1.setLibro2(libro1);
        autorLibro1.setAutor2(autor1);
        autorLibro1.setFecha(LocalDateTime.now());

        // Segundo registro
        AutorLibro autorLibro2 = new AutorLibro();
        autorLibro2.setLibro2(libro1);
        autorLibro2.setAutor2(autor2);
        autorLibro2.setFecha(LocalDateTime.now());

        // ---------------------------

        List<AutorLibro> lista = new ArrayList<>();
        lista.add(autorLibro1);
        lista.add(autorLibro2);

        libro1.setAutoresLibros(lista);

        // INSERTAR Libro2
        // this.iLibroService.guardar(libro1);

//        this.iLibroService.guardar(new Libro());

//        Libro libroBuscado = this.iLibroService.buscarPorNombre("");
//        System.out.println(libroBuscado);



    }
}
