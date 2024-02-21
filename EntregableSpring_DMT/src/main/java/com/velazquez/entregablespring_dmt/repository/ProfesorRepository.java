package com.velazquez.entregablespring_dmt.repository;


import com.velazquez.entregablespring_dmt.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Profesor findByNombre(String nombre);
}
