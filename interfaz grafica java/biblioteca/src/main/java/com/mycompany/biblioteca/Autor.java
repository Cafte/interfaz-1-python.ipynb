package com.mycompany.biblioteca;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
public class Autor {
private final String nombre;
    private final String apellido;

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mostrarInfo() {
        System.out.println("Autor: " + nombre + " " + apellido);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    }

