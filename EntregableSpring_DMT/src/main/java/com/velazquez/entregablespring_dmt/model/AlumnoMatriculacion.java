package com.velazquez.entregablespring_dmt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno_se_matricula_asignatura")
@IdClass(AlumnoAsignaturaId.class)
public class AlumnoMatriculacion {
    @Id
    @ManyToOne
    @JoinColumn(name = "idAlumno", insertable = false, updatable = false )
    private Alumno alumnos;
    @Id
    @ManyToOne
    @JoinColumn(name = "idAsignatura", insertable = false, updatable = false )
    private Asignatura asignaturas;

    @Column
    private int nota;

    public AlumnoMatriculacion() {
    }

    public Alumno getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno alumnos) {
        this.alumnos = alumnos;
    }

    public Asignatura getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "AlumnoMatriculacion{" +
                "alumnos=" + alumnos +
                ", asignaturas=" + asignaturas +
                ", nota=" + nota +
                '}';
    }
}
