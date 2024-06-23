package com.mycompany.biblioteca;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
public class Libro {
    private final String titulo;
    private final String isbn;
    private final Autor autor;
    private final String categoria;

    public Libro(String titulo, String isbn, Autor autor, String categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
    }

    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo + ", ISBN: " + isbn + ", Autor: " + autor + ", Categoria: " + categoria);
    }

    @Override
    public String toString() {
        return titulo + " (ISBN: " + isbn + ")";
    }
}


