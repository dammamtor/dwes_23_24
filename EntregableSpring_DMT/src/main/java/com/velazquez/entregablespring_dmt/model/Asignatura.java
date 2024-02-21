package com.velazquez.entregablespring_dmt.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="asignatura")
public class Asignatura {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private Double creditos;
    @Column
    private String tipo;
    @Column
    private Integer curso;
    @Column
    private Integer cuatrimestre;

    @ManyToOne
    @JoinColumn(name = "idGrado")
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "idProfesor")  // Ajusta esto según el nombre real de la columna en la tabla Asignatura
    private Profesor profesor;


    //MANY TO MANY CON MAS DE UNA ASIGNATURA
    @OneToMany(mappedBy = "asignaturas", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AlumnoMatriculacion> alumnoMatriculacions = new HashSet<>();

    public enum EnumTipo {
        BASICA, OPTATIVA, OBLIGATORIA
    }

    public Asignatura() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCreditos() {
        return creditos;
    }

    public void setCreditos(Double creditos) {
        this.creditos = creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Integer cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Grado getGrados() {
        return grado;
    }

    public void setGrados(Grado grados) {
        this.grado = grados;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<AlumnoMatriculacion> getAlumnoMatriculacions() {
        return alumnoMatriculacions;
    }

    public void setAlumnoMatriculacions(Set<AlumnoMatriculacion> alumnoMatriculacions) {
        this.alumnoMatriculacions = alumnoMatriculacions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(creditos, that.creditos) && Objects.equals(tipo, that.tipo) && Objects.equals(curso, that.curso) && Objects.equals(cuatrimestre, that.cuatrimestre) && Objects.equals(grado, that.grado) && Objects.equals(profesor, that.profesor) && Objects.equals(alumnoMatriculacions, that.alumnoMatriculacions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, creditos, tipo, curso, cuatrimestre, grado, profesor, alumnoMatriculacions);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                ", tipo=" + tipo +
                ", curso=" + curso +
                ", cuatrimestre=" + cuatrimestre +
                '}';
    }
}

