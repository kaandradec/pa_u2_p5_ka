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
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre("Marco");
        ciudadano.setApellido("Sanchez");

        Empleado empleado = new Empleado();
        empleado.setFechaIngreso(LocalDateTime.now());
        empleado.setSalario(new BigDecimal("2200"));
        empleado.setCiudadano(this.iCiudadanoService.buscar(1));





        // this.iCiudadanoService.registrar(ciudadano);
        // Buscar ciudadano
        Ciudadano ciudadanoBuscado = this.iCiudadanoService.buscar(1);
        System.out.println("Ciudadano buscado: " + ciudadanoBuscado);
        // Insertar Empleado
        iEmpleadoService.registrar(empleado);

        // buscar Empleado
//        Empleado empBuscado = this.iEmpleadoService.buscar(1);
//        System.out.println(empBuscado);

    }
}
