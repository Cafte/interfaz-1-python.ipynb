/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author danie
 */
public class Categoria {
    private final String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Categoria: " + nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
