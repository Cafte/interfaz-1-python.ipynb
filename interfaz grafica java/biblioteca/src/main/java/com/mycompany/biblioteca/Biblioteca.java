/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author danie
 */
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Libro> libros;
    private final List<Usuario> usuarios;
    private final List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
