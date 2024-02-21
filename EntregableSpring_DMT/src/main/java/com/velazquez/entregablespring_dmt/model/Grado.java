package com.velazquez.entregablespring_dmt.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Grado {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    //ONE TO MANY
    @OneToMany (mappedBy = "grado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Asignatura> asignaturas = new HashSet<>();

    public Grado() {
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

    public Set<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grado grado = (Grado) o;
        return Objects.equals(id, grado.id) && Objects.equals(nombre, grado.nombre) && Objects.equals(asignaturas, grado.asignaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, asignaturas);
    }

    @Override
    public String toString() {
        return "Grado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
