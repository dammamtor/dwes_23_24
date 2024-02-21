package com.velazquez.entregablespring_dmt.repository;

import com.velazquez.entregablespring_dmt.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByProfesorId(Long profesorId);

}
