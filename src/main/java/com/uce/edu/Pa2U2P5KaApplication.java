package com.uce.edu;

import com.uce.edu.repository.IMascotaRepository;
import com.uce.edu.repository.modelo.*;
import com.uce.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {

    @Autowired
    private ICiudadanoService iCiudadanoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 3. CRITERIA API QUERY
        Ciudadano ciu = this.iCiudadanoService.buscarPorApellido("Castro");
        System.out.println(ciu);

        // >>> Citeria API Q Dinámico
        System.out.println("\n>>>Criteria Dinámico");

        // Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=?
        Ciudadano ciu1 = this.iCiudadanoService.buscarPorCriteria("Jorge", "Castro", "171717");
        System.out.println(ciu1);

        // Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_apellido=?
        Ciudadano ciu2 = this.iCiudadanoService.buscarPorCriteria("Carla", "Bolañoz", "0523456781");
        System.out.println(ciu2);
        // Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_cedula=?
        Ciudadano ciu3 = this.iCiudadanoService.buscarPorCriteria("Marco", "Parra", "212121");
        System.out.println(ciu3);

        // >>> Criteria AND OR
        System.out.println("\n>>>Criteria AND OR");
        // OR
        // Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=? or c1_0.ciud_apellido=?
        Ciudadano ciu4 = this.iCiudadanoService.buscarPorCriteriaAndOr("Jorge", "Castro11111", "171717");
        System.out.println(ciu4);
        // AND
        // Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=? and c1_0.ciud_apellido=?
        Ciudadano ciu5 = this.iCiudadanoService.buscarPorCriteriaAndOr("Carla", "Bolañoz", "0523456781");
        System.out.println(ciu5);


    }
}
