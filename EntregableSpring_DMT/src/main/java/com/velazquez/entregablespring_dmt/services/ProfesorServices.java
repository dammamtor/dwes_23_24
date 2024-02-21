package com.velazquez.entregablespring_dmt.services;



import com.velazquez.entregablespring_dmt.model.Asignatura;
import com.velazquez.entregablespring_dmt.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorServices {
    public Optional<Profesor> findProfesorById(Long id);

    public Profesor actualizarProfesor(Profesor profesor);

    public List<Profesor> getAllProfesores();

    public  Profesor insertarProfesor(Profesor profesor);

    public Profesor getProfesorByName(String nombre);

    List<Asignatura> getAsignaturasByProfesor(Long profesorId);



}
