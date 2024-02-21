package com.velazquez.entregablespring_dmt.services;


import com.velazquez.entregablespring_dmt.model.Asignatura;
import com.velazquez.entregablespring_dmt.model.Profesor;
import com.velazquez.entregablespring_dmt.repository.ProfesorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorServices {
    static final Logger logger = LoggerFactory.getLogger(ProfesorServiceImpl.class);

    @Autowired
    ProfesorRepository profRepo;

    @Override
    public Optional<Profesor> findProfesorById(Long id) {
        return profRepo.findById(id);
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        if (profesor == null || profesor.getId() == null) {
            return null;
        }

        return profRepo.save(profesor);
    }

    @Override
    public List<Profesor> getAllProfesores() {
        return profRepo.findAll();
    }

    @Override
    public Profesor getProfesorByName(String nombre) {
        if (nombre != null) {

            Profesor dpto = profRepo.findByNombre(nombre);

            return dpto;
        }

        return null;
    }

    @Override
    public List<Asignatura> getAsignaturasByProfesor(Long profesorId) {
        logger.info("ID profesor: {}", profesorId);
        Optional<Profesor> profesor = profRepo.findById(profesorId);

        if (profesor.isPresent()) {
            List<Asignatura> asignaturas = new ArrayList<>(profesor.get().getAsignaturas());
            logger.info("Asignaturas obtenidas: {}", asignaturas);
            return asignaturas;
        }

        return Collections.emptyList();
    }

    @Override
    public Profesor insertarProfesor(Profesor profesor) {
        logger.info("ESTAS EN INSERTAR PROFESOR");
        Profesor existingProfesor = getProfesorByName(profesor.getNombre());

        if (existingProfesor != null) {
            logger.info(existingProfesor.toString());
            logger.info("NO ES NULO ");
            return null;  // Deberías devolver null si el profesor ya existe
        }

        // Resto del código para la inserción
        return profRepo.save(profesor);
    }

}
