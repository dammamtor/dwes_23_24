package com.velazquez.entregablespring_dmt.services;

import java.util.List;
import java.util.Optional;

import com.velazquez.entregablespring_dmt.model.Alumno;
import com.velazquez.entregablespring_dmt.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlumnoServiceImpl implements AlumnoService {

  @Autowired
  AlumnoRepository alumnoRepo;

  @Override
  public Optional<Alumno> findAlumnoById(Long id) {

    return alumnoRepo.findById(id);
  }

  @Override
  public List<Alumno> getAllAlumnos() {

    return alumnoRepo.findAll();
  }

}
