package com.uce.edu;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {
    // 1. Query (JPQL) - Usar cuando no sabemos con que tipo de datos trabajamos
    //  1.1 TypedQuery - Recomentado usar
    //  1.2 NamedQuery - Cuando requerimos usar el mismo query desde distintos sitios

    // 2. Native Query
    // 3. Criteria API Query

    @Autowired
    private ILibroService iLibroService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> QUERY");
        List<Libro> lista = this.iLibroService.buscarPorFecha(LocalDateTime.of(2023,1,1,7,15));
        System.out.println(">>Lista Query");
        lista.forEach(System.out::println);

        System.out.println("\nTypedQuery");
        Libro li1 = this.iLibroService.buscarPorTitulo("Programacion web");
        System.out.println(li1);

        List<Libro> lista2 = this.iLibroService.buscarPorFechaPubli(LocalDateTime.of(2023,1,1,7,15));

        System.out.println(">>Lista TypedQuery");
        lista2.forEach(System.out::println);

        System.out.println("\n>>> NamedQuery");
        Libro li2 = this.iLibroService.buscarPorTituloNamed("Postgres");
        System.out.println(li2);

        List<Libro> lista3 = this.iLibroService.buscarPorFechaPubliNamed(LocalDateTime.of(2023,1,1,7,15));

        System.out.println(">>Lista QueryNamed");
        lista3.forEach(System.out::println);

    }
}
