package com.velazquez.entregablespring_dmt.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

public class ProfesorDTO implements Serializable {
    private String nombre;

    private String nif;

    private String apellido1;

    private String apellido2;

    private String ciudad;

    private String direccion;

    private String telefono;

    @DateTimeFormat(pattern="dd-mm-yyyy")
    private String fecha_nacimiento;

    private String sexo;
    // Nuevo campo para almacenar el ID del departamento seleccionado
    private Long departamentoId;

    public ProfesorDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "ProfesorDTO{" +
                "nombre='" + nombre + '\'' +
                ", nif='" + nif + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
