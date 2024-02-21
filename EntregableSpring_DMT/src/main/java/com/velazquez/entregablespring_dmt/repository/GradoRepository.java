package com.velazquez.entregablespring_dmt.repository;

import com.velazquez.entregablespring_dmt.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {
    Grado findByNombre(String nombre);
}
