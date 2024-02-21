package com.velazquez.entregablespring_dmt.controller;

import com.velazquez.entregablespring_dmt.model.Asignatura;
import com.velazquez.entregablespring_dmt.model.Profesor;
import com.velazquez.entregablespring_dmt.services.AsignaturaServiceImpl;
import com.velazquez.entregablespring_dmt.services.ProfesorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {
    static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);

    @Autowired
    ProfesorServiceImpl profesorService;

    @Autowired
    AsignaturaServiceImpl asignaturaService;

    @GetMapping("/")
    public String profesores(Model model) {
        List<Profesor> profesores = profesorService.getAllProfesores();
        logger.info("Lista de profesores: {}", profesores);
        model.addAttribute("profesores", profesores);
        return "profesores";
    }

    @GetMapping("/asignaturas")
    public String obtenerAsignaturasPorProfesor(@RequestParam Long id, Model model) {
        List<Asignatura> asignaturas = asignaturaService.getAsignaturasByProfesorId(id);
        logger.info("Asignaturas: {}", asignaturas);

        if (!asignaturas.isEmpty()) {
            logger.info("Asignaturas del profesor {}: {}", id, asignaturas);
            Optional<Profesor> profesor = profesorService.findProfesorById(id);

            if (profesor.isPresent()) {
                model.addAttribute("asignaturas", asignaturas);
                model.addAttribute("profesor", profesor.get());
                return "asignaturasPorProfesor";
            } else {
                return "redirect:/profesores/";
            }
        } else {

            return "redirect:/profesores/"; // Redirigir a la lista de profesores u otra página según sea necesario
        }
    }


}
