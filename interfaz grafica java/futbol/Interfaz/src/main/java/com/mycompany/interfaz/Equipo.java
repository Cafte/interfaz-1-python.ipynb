/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz;

/**
 *
 * @author danie
 */
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String entrenador;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public String mostrarInfo() {
        return "Equipo: " + nombre + ", Entrenador: " + entrenador;
    }

  
}
