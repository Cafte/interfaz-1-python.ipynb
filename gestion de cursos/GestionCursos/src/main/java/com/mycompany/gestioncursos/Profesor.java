/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncursos;

/**
 *
 * @author danie
 */

public class Profesor {
    private String nombre;
    private String apellido;
    private String asignatura;

    public Profesor(String nombre, String apellido, String asignatura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", asignatura='" + asignatura + '\'' +
                '}';
    }
}