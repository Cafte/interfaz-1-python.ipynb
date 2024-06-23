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

public class TiendaModel {
    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Orden> ordenes;
    private List<Categoria> categorias;

    public TiendaModel() {
        productos = new ArrayList<>();
        clientes = new ArrayList<>();
        ordenes = new ArrayList<>();
        categorias = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Orden crearOrden(Cliente cliente) {
        Orden orden = new Orden(cliente);
        ordenes.add(orden);
        return orden;
    }

    public List<String> mostrarProductos() {
        List<String> infoProductos = new ArrayList<>();
        for (Producto producto : productos) {
            infoProductos.add(producto.mostrarInfo());
        }
        return infoProductos;
    }

    public List<Orden> obtenerOrdenesCliente(int idCliente) {
        List<Orden> ordenesCliente = new ArrayList<>();
        for (Orden orden : ordenes) {
            if (orden.getCliente().getIdCliente() == idCliente) {
                ordenesCliente.add(orden);
            }
        }
        return ordenesCliente;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }
}

