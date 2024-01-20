package com.uce.edu;

import com.uce.edu.repository.IMascotaRepository;
import com.uce.edu.repository.modelo.*;
import com.uce.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {

    @Autowired
    private IMascotaService iMascotaService;

    @Autowired
    private IHotelService iHotelService;

    @Autowired
    private IHabitacionService iHabitacionService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TYPED QUERYs

        // 1. Listar todos los hoteles
        System.out.println("Listar todos los hoteles:");
        List<Hotel> hoteles = iHotelService.listar();
        hoteles.forEach(System.out::println);

        // 2. Buscar hotel por nombre
        System.out.println("\nBuscar hotel por nombre: ");
        Hotel hotelPorNombre = iHotelService.buscarPorNombre("Moncayo");
        System.out.println(hotelPorNombre);

        // 3. Buscar habitaciones por nombre de hotel
        System.out.println("\nBuscar habitaciones por nombre de hotel: ");
        List<Habitacion> habitacionesPorHotel = iHotelService.buscarHabitacionesPorNombreHotel("Nueva Luna");
        habitacionesPorHotel.forEach(System.out::println);

        // 4. Buscar hoteles con numero de habitaciones mayor a n
        System.out.println("\nBuscar hoteles por número de habitaciones: ");
        List<Hotel> hotelesPorNumeroHabitaciones = iHotelService.buscarPorNumeroHabitaciones(3);
        hotelesPorNumeroHabitaciones.forEach(System.out::println);

        // Habitacion
        // 5. Seleccionar habitaciones por clase
        System.out.println("\nSeleccionar habitaciones por clase:");
        List<Habitacion> habitacionesPorClase = iHabitacionService.buscarPorClase("vip");
        habitacionesPorClase.forEach(System.out::println);


        // NATIVE QUERYS

        // 1. Listar todas las mascotas
        System.out.println("Listar todas las mascotas:");
        List<Mascota> mascotas = iMascotaService.listarMascotas();
        mascotas.forEach(System.out::println);

        // 2. Listar mascotas por tipo
        System.out.println("\nListar mascotas por tipo: ");
        List<Mascota> gatos = iMascotaService.listarMascotasPorTipo("Gato");
        gatos.forEach(System.out::println);

        // 3. Actualizar el color de una mascota
        System.out.println("\nActualizar el color de una mascota:");
        iMascotaService.actualizarColorMascota("Luna", "Naranja");

        // 4. Contar la cantidad de mascotas
        System.out.println("\nContar la cantidad de mascotas:");
        Long cantidadMascotas = iMascotaService.contarMascotas();
        System.out.println("Cantidad de mascotas: " + cantidadMascotas);

        // 5. Eliminar una mascota por ID
        System.out.println("\nEliminar una mascota por ID:");
        iMascotaService.quitarMascotaPorId(3L);

    }
}
