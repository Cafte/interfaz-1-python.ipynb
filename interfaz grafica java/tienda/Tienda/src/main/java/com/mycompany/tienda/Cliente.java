/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda;

/**
 *
 * @author danie
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private int idCliente;

    public Cliente(String nombre, String apellido, int idCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCliente = idCliente;
    }

    public String mostrarInfo() {
        return "Cliente: " + nombre + " " + apellido + ", ID: " + idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdCliente() {
        return idCliente;
    }
}

