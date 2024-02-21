package com.velazquez.entregablespring_dmt.services;

import java.util.ArrayList;
import java.util.List;

import com.velazquez.entregablespring_dmt.model.Alumno;
import com.velazquez.entregablespring_dmt.model.Grado;
import com.velazquez.entregablespring_dmt.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GradoServiceImpl implements GradoService {

  @Autowired
  GradoRepository gradoRepo;

  @Autowired
  AlumnoService alumnoService;

  @Override
  public List<Grado> getAllGrades() {
    List<Grado> gradosBD = gradoRepo.findAll();

    if (!gradosBD.isEmpty()) {
      return gradosBD;
    }

    return new ArrayList<Grado>();
  }


  @Override
  public Grado findGradoById(Long id) {
    return gradoRepo.findById(id).orElse(null);
  }
}
