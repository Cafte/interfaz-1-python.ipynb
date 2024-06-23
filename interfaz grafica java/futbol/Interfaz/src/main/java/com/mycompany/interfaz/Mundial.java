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

public class Mundial {
    private List<Grupo> grupos;
    private List<Estadio> estadios;
    private List<Partido> partidos;

    public Mundial() {
        this.grupos = new ArrayList<>();
        this.estadios = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void registrarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void registrarEstadio(Estadio estadio) {
        estadios.add(estadio);
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    public void eliminarPartido(Partido partido) {
        partidos.remove(partido);
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public List<Estadio> getEstadios() {
        return estadios;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

}
