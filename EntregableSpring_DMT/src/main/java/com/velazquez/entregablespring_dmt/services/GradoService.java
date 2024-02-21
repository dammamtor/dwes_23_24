package com.velazquez.entregablespring_dmt.services;

import com.velazquez.entregablespring_dmt.model.Grado;

import java.util.List;


public interface GradoService {
  List<Grado> getAllGrades();

  Grado findGradoById(Long id);

}
