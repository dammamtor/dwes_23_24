package com.velazquez.entregablespring_dmt.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Alumno {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nif;
    @Column
    private String nombre;
    @Column
    private String apellido1;
    @Column
    private String apellido2;
    @Column
    private String ciudad;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @Column
    private String sexo;
    @Column
    private Date fecha_nacimiento;
    //MANY TO MANY CON MAS DE UNA COLUMNA
    @OneToMany(mappedBy = "alumnos", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AlumnoMatriculacion> alumnoMatriculacions = new HashSet<>();

    public Alumno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id) && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellido1, alumno.apellido1) && Objects.equals(apellido2, alumno.apellido2) && Objects.equals(ciudad, alumno.ciudad) && Objects.equals(direccion, alumno.direccion) && Objects.equals(telefono, alumno.telefono) && Objects.equals(fecha_nacimiento, alumno.fecha_nacimiento) && Objects.equals(alumnoMatriculacions, alumno.alumnoMatriculacions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, alumnoMatriculacions);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }
}
