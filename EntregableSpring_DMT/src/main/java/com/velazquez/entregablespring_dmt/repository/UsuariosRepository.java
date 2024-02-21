package com.velazquez.entregablespring_dmt.repository;

import com.velazquez.entregablespring_dmt.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByUserName(String userName);
}

