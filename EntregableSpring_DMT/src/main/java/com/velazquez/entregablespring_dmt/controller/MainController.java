package com.velazquez.entregablespring_dmt.controller;

import com.velazquez.entregablespring_dmt.dto.UsuarioDTO;
import com.velazquez.entregablespring_dmt.model.Usuarios;
import com.velazquez.entregablespring_dmt.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    UsuarioServiceImpl usuariosServices;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("contenido", "INICIO");
        return "index";
    }

    @GetMapping("/register")
    public String registerGet(Model model) {

        UsuarioDTO userDTO = new UsuarioDTO();
        model.addAttribute("usuario", userDTO);
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute UsuarioDTO usuario) {

        Usuarios userBD = new Usuarios();
        userBD.setActivo(true);
        userBD.setNombre(usuario.getNombre());
        userBD.setApellidos(usuario.getApellidos());
        userBD.setUserName(usuario.getUsuario());
        userBD.setRole("ROLE_USER");
        userBD.setEmail(usuario.getEmail());
        userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));

        userBD = usuariosServices.insertUsuario(userBD);

        if (userBD == null) {
            return "redirect:/register";
        }

        return "redirect:/";
    }
}
