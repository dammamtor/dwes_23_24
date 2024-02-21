package com.velazquez.entregablespring_dmt.controller;

import com.velazquez.entregablespring_dmt.model.Grado;
import com.velazquez.entregablespring_dmt.model.Usuarios;
import com.velazquez.entregablespring_dmt.services.UsuarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioServiceImpl usuarioService;

    @RequestMapping("/")
    public String grados(Model model) {
        List<Usuarios> usuarios = usuarioService.getAllUsuarios();

        logger.info("Usuarios: {}" + usuarios);

        model.addAttribute("usuarios", usuarios);

        return "usuarios";
    }

    @GetMapping("/delete")
    public String eliminarUsuario(@RequestParam("id") Long id) {
        logger.info("ID del usuario a eliminar: ", id);
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/";
    }

}
