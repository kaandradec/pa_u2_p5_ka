package com.uce.edu;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHabitacionService;
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
    @Autowired
    private IHabitacionService iHabitacionService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n>>>OPERACIONES CRUD Hotel, Habitacion - Relación OneToMany");
        // TODO: NOTA: Para que funcione el codigo completo y evitar errores por duplicidad de claves primarias, etc.
        // Se debe asegurar que las secuancias seq_hotel seq_habitacion deber ser reiniciadas desde la base de datos
        // además no debe haber filas con el id: 1.
        // Caso contrario se debe realizar las operaciones una a una, cambiando la id segun corresponda.

        // insertar hotel con 2 habitaciones
        Hotel hotel = new Hotel();
        hotel.setDireccion("Colon");
        hotel.setNombre("Marriot");

        Habitacion habitacion = new Habitacion();
        habitacion.setNumero("A1");
        habitacion.setClase("economica");
        habitacion.setHotel(hotel);

        Habitacion habitacion2 = new Habitacion();
        habitacion2.setNumero("A2");
        habitacion2.setClase("presidencial");
        habitacion2.setHotel(hotel);

        hotel.setHabitaciones(List.of(habitacion, habitacion2));

        // GUARDAR hotel con 2 habitaciones - CASCADA
        this.iHotelService.guardar(hotel);

        // BUSCAR hotel y habitaciones
        System.out.println("\nBUSCAR hotel -> " + this.iHotelService.buscar(1));
        System.out.println("\nBUSCAR habitacion 1-> " + this.iHabitacionService.buscar(1));
        System.out.println("\nBUSCAR habitacion 2 -> " + this.iHabitacionService.buscar(2));

        // ACTUALIZAR habitacion 2
        Habitacion habitacionActualizada = new Habitacion();
        habitacionActualizada.setNumero("A5");
        habitacionActualizada.setClase("economica");
        habitacionActualizada.setHotel(this.iHotelService.buscar(1));
        habitacionActualizada.setId(2);

        this.iHabitacionService.actualizar(habitacionActualizada);
        System.out.println("\nBUSCAR habitacion 2 ACTUALIZADA -> " + this.iHabitacionService.buscar(2));

        // BORRAR hotel y habitaciones CASCADA
        Integer hotelId = 1;
        try {
            this.iHotelService.eliminar(hotelId);
            System.out.printf("%nSe ELIMINO hotel id: %d ", hotelId);
        } catch (Exception e) {
            System.out.printf("%nNo se encontro hotel %d ", hotelId);
        }
    }
}
