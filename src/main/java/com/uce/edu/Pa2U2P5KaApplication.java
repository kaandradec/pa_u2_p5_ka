package com.uce.edu;

import com.uce.edu.repository.IAutorLibroRepository;
import com.uce.edu.repository.modelo.*;
import com.uce.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {
    @Autowired
    private IHotelService iHotelService;
    @Autowired
    private IHabitacionService iHabitacionService;

    @Autowired
    private ILibroService iLibroService;

    @Autowired
    private  IAutorService iAutorService;

    @Autowired
    private IAutorLibroService iAutorLibroService;
    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("\n>>>OPERACIONES CRUD Hotel, Habitacion - Relación OneToMany");
        // Insertar en cascada desde libro
//        Hotel hotel = new Hotel();
//        hotel.setDireccion("Colon");
//        hotel.setNombre("Marriot");
//
//        Habitacion habitacion = new Habitacion();
//        habitacion.setNumero("A1");
//        habitacion.setClase("economica");
//        habitacion.setHotel(hotel);
//
//        Habitacion habitacion2 = new Habitacion();
//        habitacion2.setNumero("A2");
//        habitacion2.setClase("presidencial");
//        habitacion2.setHotel(hotel);
//
//        hotel.setHabitaciones(List.of(habitacion, habitacion2));
//
//        // GUARDAR hotel con 2 habitaciones - CASCADA
//        this.iHotelService.guardar(hotel);

//        // Insertar en cascada desde Autor
//
//        Libro2 libro = new Libro2();
//        libro.setTitulo("Arquitectura de Software");
//        libro.setFechaPublicacion(LocalDateTime.now());
//
//        Autor2 autor = new Autor2();
//        autor.setNombre("Miguel Angel");
//        autor.setNacionalidad("España");
//
//        AutorLibro autorLibro = new AutorLibro();
//        autorLibro.setFecha(LocalDateTime.now());
//        autorLibro.setAutor2(autor);
//        autorLibro.setLibro2(libro);
//
//        List<AutorLibro> lista = new ArrayList<>();
//        lista.add(autorLibro);
//
//        autor.setAutoresLibros(lista);
//
//        this.iAutorService.registrar(autor);

        // Insertar en cascada desde AutorLibro
        Autor2 autorA = new Autor2();
        autorA.setNombre("Mateo Castro");
        autorA.setNacionalidad("Cubano");

        Libro2 libroA = new Libro2();
        libroA.setTitulo("CSS");
        libroA.setFechaPublicacion(LocalDateTime.now());

        AutorLibro autorLibroA = new AutorLibro();
        autorLibroA.setCodigo("AL123");
        autorLibroA.setFecha(LocalDateTime.of(LocalDate.of(1900, 02, 12), LocalTime.now()));
        autorLibroA.setAutor2(autorA);
        autorLibroA.setLibro2(libroA);

//        this.iAutorLibroService.guardar(autorLibroA);

//        this.iAutorLibroService.actualizarRegistro("AL123", LocalDateTime.now() );


    }
}
