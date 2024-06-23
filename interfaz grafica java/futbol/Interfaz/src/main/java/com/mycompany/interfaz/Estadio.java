/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz;

/**
 *
 * @author danie
 */
public class Estadio {
    private String nombre;
    private String ciudad;
    private int capacidad;

    public Estadio(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String mostrarInfo() {
        return "Estadio: " + nombre + ", Ciudad: " + ciudad + ", Capacidad: " + capacidad;
    }

    // Getters y setters si es necesario
}
