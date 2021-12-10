package com.example.demo.repository;

import com.example.demo.entities.CourMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourMaterialRepository extends JpaRepository<CourMaterial,Long> {
}
