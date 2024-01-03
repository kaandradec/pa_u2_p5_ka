package com.uce.edu;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {
    @Autowired
    private IHotelService iHotelService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // insertar hotel con 2 habitaciones
        Hotel hotel = new Hotel();
        hotel.setDireccion("Colon");
        hotel.setNombre("Marriot");

        Habitacion habitacion = new Habitacion();
        habitacion.setNumero("A1");
        habitacion.setClase("economica");
        habitacion.setHotel(hotel);

        Habitacion habitacion2 = new Habitacion();
        habitacion.setNumero("A2");
        habitacion.setClase("presidencial");
        habitacion.setHotel(hotel);

        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(habitacion);
        habitaciones.add(habitacion2);
        hotel.setHabitaciones(habitaciones);

        this.iHotelService.guardar(hotel);
//        hotel.setHabitaciones(List.of(habitacion, habitacion2));





    }
}
