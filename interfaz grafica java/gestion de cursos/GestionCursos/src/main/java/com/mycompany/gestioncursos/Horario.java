/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncursos;

/**
 *
 * @author danie
 */
public class Horario {
    private String dia;
    private String horaInicio;
    private String horaFin;

    public Horario(String dia, String horaInicio, String horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "dia='" + dia + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                '}';
    }
}
