/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz;

/**
 *
 * @author danie
 */
// Jugador.java
public class Jugador {
    private String nombre;
    private int edad;
    private String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

    public String mostrarInfo() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Posición: " + posicion;
    }

    // Getters y setters si es necesario
}
