/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda;

/**
 *
 * @author danie
 */
import java.util.ArrayList;
import java.util.List;

public class Orden {
    private Cliente cliente;
    private List<ItemOrden> items;
    private double total;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarItem(ItemOrden item) {
        items.add(item);
        calcularTotal();
    }

    public void calcularTotal() {
        total = items.stream().mapToDouble(ItemOrden::calcularSubtotal).sum();
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String mostrarInfo() {
        StringBuilder info = new StringBuilder("Orden para " + cliente.getNombre() + " " + cliente.getApellido() + ":\n");
        for (ItemOrden item : items) {
            info.append(item.mostrarInfo()).append("\n");
        }
        info.append("Total: $").append(String.format("%.2f", total));
        return info.toString();
    }
}
