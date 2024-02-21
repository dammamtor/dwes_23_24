package com.velazquez.entregablespring_dmt.services;


import com.velazquez.entregablespring_dmt.model.Asignatura;
import com.velazquez.entregablespring_dmt.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaServices {

  @Autowired
  AsignaturaRepository asignaturaRepo;

  @Override
  public List<Asignatura> getAllAsignaturas() {

    // Obtengo el resultado a través del repositorio
    List<Asignatura> asignBD = asignaturaRepo.findAll();

    // Verificando que he obtenido algo
    if (asignBD != null && asignBD.size() > 0) {

      return asignBD;
    }

    // No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
    return new ArrayList<Asignatura>();
  }

  @Override
  public Optional<Asignatura> findAsignaturaById(Long id) {

    Optional<Asignatura> asignatura = null;

    if (id != null) {
      asignatura = asignaturaRepo.findById(id);
    }

    return asignatura;
  }
  @Override
  public List<Asignatura> getAsignaturasByProfesorId(Long profesorId) {
    return asignaturaRepo.findByProfesorId(profesorId);
  }
}
