/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncursos;

import com.mycompany.gestioncursos.Curso;
import com.mycompany.gestioncursos.Estudiante;

/**
 *
 * @author danie
 */

public class Evaluacion {
    private String nombre;
    private Curso curso;
    private Estudiante estudiante;
    private double nota;

    public Evaluacion(String nombre, Curso curso, Estudiante estudiante, double nota) {
        this.nombre = nombre;
        this.curso = curso;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", estudiante=" + estudiante +
                ", nota=" + nota +
                '}';
    }
}