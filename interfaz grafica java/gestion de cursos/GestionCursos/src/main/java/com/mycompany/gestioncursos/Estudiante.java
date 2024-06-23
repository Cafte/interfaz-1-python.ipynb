/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncursos;

/**
 *
 * @author danie
 */


import java.util.Arrays;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String idEstudiante;
    private String[] cursos;

    public Estudiante(String nombre, String apellido, String idEstudiante, String[] cursos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstudiante = idEstudiante;
        this.cursos = cursos;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", idEstudiante='" + idEstudiante + '\'' +
                ", cursos=" + Arrays.toString(cursos) +
                '}';
    }
}
