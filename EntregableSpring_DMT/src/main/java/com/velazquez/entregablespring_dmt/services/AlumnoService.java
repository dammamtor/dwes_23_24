package com.velazquez.entregablespring_dmt.services;


import com.velazquez.entregablespring_dmt.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

  public List<Alumno> getAllAlumnos();

  public Optional<Alumno> findAlumnoById(Long id);

}
