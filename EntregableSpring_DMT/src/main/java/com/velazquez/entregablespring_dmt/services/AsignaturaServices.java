package com.velazquez.entregablespring_dmt.services;



import com.velazquez.entregablespring_dmt.model.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaServices {
    public List<Asignatura> getAllAsignaturas();

    public Optional<Asignatura> findAsignaturaById(Long id);

    public List<Asignatura> getAsignaturasByProfesorId(Long profesorId);
}