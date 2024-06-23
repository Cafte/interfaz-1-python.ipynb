/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author danie
 */
public class Usuario {
    private final String nombre;
    private final String apellido;
    private final String idUsuario;

    public Usuario(String nombre, String apellido, String idUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
    }

    public void mostrarInfo() {
        System.out.println("Usuario: " + nombre + " " + apellido + ", ID: " + idUsuario);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (ID: " + idUsuario + ")";
    }
}
