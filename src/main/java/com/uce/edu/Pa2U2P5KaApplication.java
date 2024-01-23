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

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Hibernate: select m1_0.id_mascota,m1_0.color,m1_0.edad,m1_0.nombre,m1_0.peso,m1_0.telefono_placa,m1_0.tipo from mascota m1_0 where m1_0.telefono_placa=?
        System.out.println("\n>> Seleccionar Mascota 'Oreo' por telefonoPlaca");
        Mascota m1 = this.iMascotaService.buscarPorCriteriaTelefonoPlacaORNombre("0992222222", "Oreo");
        System.out.println(m1);

        // Hibernate: select m1_0.id_mascota,m1_0.color,m1_0.edad,m1_0.nombre,m1_0.peso,m1_0.telefono_placa,m1_0.tipo from mascota m1_0 where m1_0.nombre=?
        System.out.println(">> Seleccionar Mascota 'Oreo' por nombre");
        Mascota m2 = this.iMascotaService.buscarPorCriteriaTelefonoPlacaORNombre("", "Oreo");
        System.out.println(m2);

        // Hibernate: select m1_0.id_mascota,m1_0.color,m1_0.edad,m1_0.nombre,m1_0.peso,m1_0.telefono_placa,m1_0.tipo from mascota m1_0 where m1_0.tipo=? and m1_0.color=?
        System.out.println("\n>> Listar Mascotas por tipo y color");
        List<Mascota> l1 = this.iMascotaService.listarPorCriteriaTipoAndColor("Gato", "Naranja");
        l1.forEach(System.out::println);

        // Hibernate: select m1_0.id_mascota,m1_0.color,m1_0.edad,m1_0.nombre,m1_0.peso,m1_0.telefono_placa,m1_0.tipo from mascota m1_0 where m1_0.edad=? or m1_0.peso=?
        System.out.println("\n>> Listar Mascotas por edad o peso");
        List<Mascota> l2 = this.iMascotaService.listarPorCriteriaEdadORPeso(3, 4.0);
        l2.forEach(System.out::println);

        // Hibernate: select m1_0.id_mascota,m1_0.color,m1_0.edad,m1_0.nombre,m1_0.peso,m1_0.telefono_placa,m1_0.tipo from mascota m1_0 where m1_0.edad<=?
        System.out.println("\n>> Listar Mascotas por edad: perro-> lessThanOrEqualTo");
        List<Mascota> l3 = this.iMascotaService.listarPorCriteriaTipoEdad("Perro", 4);
        l3.forEach(System.out::println);

        // Hibernate: select m1_0.id_mascota,m1_0.color,m1_0.edad,m1_0.nombre,m1_0.peso,m1_0.telefono_placa,m1_0.tipo from mascota m1_0 where m1_0.edad>=?
        System.out.println(">> Listar Mascotas por edad: gato-> greaterThanOrEqualTo");
        List<Mascota> l4 = this.iMascotaService.listarPorCriteriaTipoEdad("Gato", 4);
        l4.forEach(System.out::println);

        // Hibernate: select count(m1_0.id_mascota) from mascota m1_0 where m1_0.peso between ? and ?
        System.out.println("\n>> Numero de mascotas con peso en rango");
        Integer numeroMascotasEnRangoDePeso = this.iMascotaService.contarPorCriteriaBetweenPeso(5.0, 8.0);
        System.out.println("Numero de mascotas con peso entre 5L y 8L: " + numeroMascotasEnRangoDePeso);

    }
}
