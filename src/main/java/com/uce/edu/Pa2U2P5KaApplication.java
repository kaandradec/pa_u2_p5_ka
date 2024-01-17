package com.uce.edu;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ICiudadanoService;
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

    // 2. Native Query (SQL puro) - Se usa cuando las consultas son muy complejas, se ahorra en recursos
    // al transformar de JPQL a SQL.
    //  2.1
    // 3. Criteria API Query

    @Autowired
    private ICiudadanoService iCiudadanoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Empleado empleado = this.iCiudadanoService.buscarPorCedula("181818");
        System.out.println("\n>>>JPQL: " + empleado);

        Ciudadano ciudadano = this.iCiudadanoService.buscarPorCedulaCiu("191919");
        System.out.println("\n>>>Native Query: " + ciudadano);


    }
}
