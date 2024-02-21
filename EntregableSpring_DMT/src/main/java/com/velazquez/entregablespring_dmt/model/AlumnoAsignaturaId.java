package com.velazquez.entregablespring_dmt.model;

import java.io.Serializable;
import java.util.Objects;

public class AlumnoAsignaturaId implements Serializable {
    private Long alumnos;
    private Long asignaturas;

    public AlumnoAsignaturaId() {
    }

    public Long getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Long alumnos) {
        this.alumnos = alumnos;
    }

    public Long getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Long asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoAsignaturaId that = (AlumnoAsignaturaId) o;
        return Objects.equals(alumnos, that.alumnos) && Objects.equals(asignaturas, that.asignaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumnos, asignaturas);
    }
}
