package com.velazquez.entregablespring_dmt.services;


import com.velazquez.entregablespring_dmt.model.Usuarios;

import java.util.List;

public interface UsuarioService {

  public Usuarios insertUsuario(Usuarios usuario);

  public List<Usuarios> getAllUsuarios();

  void deleteUsuario(Long id);
}
