package com.example.demo.repository;

import com.example.demo.entities.Cour;
import com.example.demo.entities.CourMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourMaterialRepositoryTest {

    @Autowired
    private CourMaterialRepository courMaterialRepository;


    @Test
    public void saveCourMaterial(){
        Cour cour = Cour.builder()
                .title("JAVA")
                .credit(7)
                .build();

        CourMaterial courMaterial = CourMaterial.builder()
                .url("www.google.com")
                .cour(cour)
                .build();


        courMaterialRepository.save(courMaterial);
    }
}