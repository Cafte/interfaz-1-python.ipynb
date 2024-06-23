/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz;

/**
 *
 * @author danie
 */
// Partido.java
public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Estadio estadio;

    public Partido(Equipo local, Equipo visitante, Estadio estadio) {
        this.local = local;
        this.visitante = visitante;
        this.estadio = estadio;
    }

    public String jugar() {
        // Lógica simple para simular un partido
        int golesLocal = (int) (Math.random() * 5);
        int golesVisitante = (int) (Math.random() * 5);
        return "Resultado: " + local.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + visitante.getNombre();
    }

    public String mostrarInfo() {
        return "Partido: " + local.getNombre() + " vs " + visitante.getNombre() + " en " + estadio.getNombre();
    }

}

