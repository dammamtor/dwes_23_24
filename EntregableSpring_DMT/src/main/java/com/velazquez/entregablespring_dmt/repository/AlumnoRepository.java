package com.velazquez.entregablespring_dmt.repository;

import com.velazquez.entregablespring_dmt.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
