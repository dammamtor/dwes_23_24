package com.velazquez.entregablespring_dmt.services;

import com.velazquez.entregablespring_dmt.model.JPAUserDetails;
import com.velazquez.entregablespring_dmt.model.Usuarios;
import com.velazquez.entregablespring_dmt.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JPAUserDetailsService implements UserDetailsService {

  @Autowired
  UsuariosRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    // Obtengo el usuario
    Usuarios user = usuarioRepository.findByUserName(username);

    // Si el usuario no existe debo devolver una excepción
    if (user == null) {
      throw new UsernameNotFoundException("Not found:" + username);
    }

    // Adapto la información del usuario al UserDetails que es lo que debe devolver el método
    JPAUserDetails userDetails = new JPAUserDetails(user);
    return userDetails;
  }
}
