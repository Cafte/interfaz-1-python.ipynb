/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author danie
 */
import java.time.LocalDate;
public class Prestamo {

    private final Libro libro;
    private final Usuario usuario;
    private final LocalDate fechaPrestamo;
    private final LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void mostrarInfo() {
        System.out.println("Prestamo - Libro: " + libro + ", Usuario: " + usuario + ", Fecha de Prestamo: " + fechaPrestamo + ", Fecha de Devolucion: " + fechaDevolucion);
    }

    @Override
    public String toString() {
        return "Prestamo de '" + libro + "' a " + usuario + " desde " + fechaPrestamo + " hasta " + fechaDevolucion;
    }
}


