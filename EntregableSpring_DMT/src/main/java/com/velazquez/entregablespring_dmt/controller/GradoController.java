package com.velazquez.entregablespring_dmt.controller;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.velazquez.entregablespring_dmt.dto.GradoDTO;
import com.velazquez.entregablespring_dmt.model.AlumnoMatriculacion;
import com.velazquez.entregablespring_dmt.model.Grado;
import com.velazquez.entregablespring_dmt.services.GradoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradoController {
    static final Logger logger = LoggerFactory.getLogger(GradoController.class);

    @Autowired
    GradoServiceImpl gradoService;


    @RequestMapping("/grados/")
    public String grados(Model model) {
        List<Grado> grados = gradoService.getAllGrades();

        logger.info("Grados: {}" + grados);

        model.addAttribute("grados", grados);

        return "grados";
    }

//    @GetMapping("/grados/estudiantes")
//    public String estudiantesPorGrado(
//            @RequestParam(required = false, name = "codigo") String codigo, Model model) {
//        if (codigo == null) {
//            return "redirect:/grados";
//        }
//
//        Long gradoId = Long.parseLong(codigo);
//        Grado gradoEntity = gradoService.findGradoById(gradoId);
//
//        List<AlumnoMatriculacion> matriculaciones = alumnoMatriculacionService.getMatriculacionesByGrado(gradoEntity);
//        logger.info("Matricula: {}", matriculaciones);
//
////        GradoDTO gradoDTO = new GradoDTO();
////        gradoDTO.setAsignaturasGrado(new HashSet<>(matriculaciones.stream()
////                .map(AlumnoMatriculacion::getAsignaturas)
////                .collect(Collectors.toSet())));
////        gradoDTO.setNombre(gradoEntity.getNombre());
////        model.addAttribute("grado", gradoDTO);
////
////        return "asignaturasGrado";
//        return "redirect:/grados";
//    }

}

