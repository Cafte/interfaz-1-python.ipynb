/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncursos;

/**
 *
 * @author danie
 */

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private Profesor profesor;
    private ArrayList<Estudiante> estudiantes;
    private final Horario horario;

    public Curso(String nombre, Profesor profesor, ArrayList<Estudiante> estudiantes, Horario horario) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                ", estudiantes=" + estudiantes +
                ", horario=" + horario +
                '}';
    }
}
