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

public class Grupo {
    private String nombre;
    private List<Equipo> equipos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public String mostrarInfo() {
        return "Grupo: " + nombre + ", Equipos: " + equipos.size();
    }

    // Getters y setters si es necesario
}


