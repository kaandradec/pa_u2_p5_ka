package com.uce.edu;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {
    @Autowired
    private IEmpleadoService iEmpleadoService;
    @Autowired
    private ICiudadanoService iCiudadanoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n>>>OPERACIONES CRUD Ciudadano, Empleado - Relación OnetoOne");
        // TODO: NOTA: Para que funcione el codigo completo y evitar errores por duplicidad de claves primarias, etc.
        // Se debe asegurar que las secuancias seq_cuidadano seq_empleado deber ser reiniciadas desde la base de datos
        // además no debe haber filas con el id: 1.
        // Caso contrario se debe realizar las operaciones una a una, cambiando la id segun corresponda.


        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre("Marco");
        ciudadano.setApellido("Sanchez");

        // INSERTAR Ciudadano
        this.iCiudadanoService.registrar(ciudadano); //ciud_id:1

        Empleado empleado = new Empleado();
        empleado.setFechaIngreso(LocalDateTime.now());
        empleado.setSalario(new BigDecimal("2200"));
        empleado.setCiudadano(this.iCiudadanoService.buscar(1));

        // INSERTAR Empleado
        this.iEmpleadoService.registrar(empleado); // empl_id:1

        // BUSCAR Ciudadano y Empleado
        System.out.println("\n\nBUSCAR Ciudadano y Empleado");
        System.out.println("\nBuscando ciudadano con id:1 ->" + this.iCiudadanoService.buscar(1));
        System.out.println("Buscando empleado con id:1 ->" + this.iEmpleadoService.buscar(1));

        // ACTUALIZAR Ciudadano y Empleado
        System.out.println("\n\nACTUALIZAR Ciudadano y Empleado");
        Ciudadano ciudadanoActualizado = new Ciudadano();
        ciudadanoActualizado.setNombre("RICARDO");
        ciudadanoActualizado.setApellido("Sanchez");
        ciudadanoActualizado.setId(1);

        this.iCiudadanoService.actualizar(ciudadanoActualizado);

        Empleado empleadoActualizado = new Empleado();
        empleadoActualizado.setFechaIngreso(LocalDateTime.now());
        empleadoActualizado.setSalario(new BigDecimal("3000"));
        empleadoActualizado.setCiudadano(this.iCiudadanoService.buscar(1));
        empleadoActualizado.setId(1);

        this.iEmpleadoService.actualizar(empleadoActualizado);

        System.out.println("\nBuscando ciudadano ACTUALIZADO con id:1 ->" + this.iCiudadanoService.buscar(1));
        System.out.println("Buscando ciudadano ACTUALIZADO con id:1 ->" + this.iEmpleadoService.buscar(1));

        // BORRAR Ciudadano y Empleado
        System.out.println("\n\nBORRAR Ciudadano y Empleado");

        Integer ciudId = 1, emplId = 1;
        try {
            this.iEmpleadoService.eliminar(emplId);
        } catch (Exception e) {
            System.out.printf("%nNo se encontro empleado con id: %d ", emplId);
        }
        try {
            this.iCiudadanoService.eliminar(ciudId);
        } catch (Exception e) {
            System.out.printf("%nNo se encontro ciudadano con id: %d ", ciudId);
        }

        System.out.println("Hola");

    }
}
