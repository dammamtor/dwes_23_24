package com.velazquez.entregablespring_dmt.services;


import com.velazquez.entregablespring_dmt.model.Usuarios;
import com.velazquez.entregablespring_dmt.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  UsuariosRepository userRepo;

  @Override
  public Usuarios insertUsuario(Usuarios usuario) {

    if (usuario != null) {
      return userRepo.save(usuario);
    }

    return null;
  }

  @Override
  public List<Usuarios> getAllUsuarios() {
    return userRepo.findAll();
  }

  @Override
  public void deleteUsuario(Long id) {
    Optional<Usuarios> userOptional = userRepo.findById(id);
    if (userOptional.isPresent()) {
      userRepo.delete(userOptional.get());
    }
  }
}
