/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda;

/**
 *
 * @author danie
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrdenesPanel extends JPanel {
    private TiendaModel tienda;
    private JTextField idClienteField;
    private JTextField productoField;
    private JTextField cantidadField;
    private JTextArea ordenesArea;
    private JLabel totalLabel;
    private JList<String> ordenesList;

    public OrdenesPanel(TiendaModel tienda) {
        this.tienda = tienda;
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 224));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(new Color(255, 255, 224));

        formPanel.add(new JLabel("ID Cliente:"));
        idClienteField = new JTextField();
        formPanel.add(idClienteField);

        JButton crearOrdenButton = new JButton("Crear Orden");
        crearOrdenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearOrden();
            }
        });
        formPanel.add(new JLabel());
        formPanel.add(crearOrdenButton);

        formPanel.add(new JLabel("Nombre del Producto:"));
        productoField = new JTextField();
        formPanel.add(productoField);

        formPanel.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        formPanel.add(cantidadField);

        JButton agregarItemButton = new JButton("Agregar Item");
        agregarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemAOrden();
            }
        });
        formPanel.add(new JLabel());
        formPanel.add(agregarItemButton);

        add(formPanel, BorderLayout.NORTH);

        ordenesArea = new JTextArea();
        ordenesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ordenesArea);
        add(scrollPane, BorderLayout.CENTER);

        totalLabel = new JLabel("Total de la Orden: $0.00");
        add(totalLabel, BorderLayout.SOUTH);

        ordenesList = new JList<>();
        ordenesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ordenesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarDetallesOrden();
            }
        });
        add(new JScrollPane(ordenesList), BorderLayout.EAST);
    }

    private void crearOrden() {
        int idCliente = Integer.parseInt(idClienteField.getText());
        Cliente cliente = tienda.getClientes().stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado");
            return;
        }

        Orden orden = tienda.crearOrden(cliente);
        JOptionPane.showMessageDialog(this, "Orden creada exitosamente");

        idClienteField.setText("");
        actualizarListaOrdenes(idCliente);
    }

    private void agregarItemAOrden() {
        int idCliente = Integer.parseInt(idClienteField.getText());
        Cliente cliente = tienda.getClientes().stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado");
            return;
        }

        String productoNombre = productoField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());

        Producto producto = tienda.getProductos().stream()
                .filter(p -> p.getNombre().equals(productoNombre))
                .findFirst()
                .orElse(null);

        if (producto == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado");
            return;
        }

        Orden orden = tienda.getOrdenes().stream()
                .filter(o -> o.getCliente().getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);

        if (orden == null) {
            JOptionPane.showMessageDialog(this, "Orden no encontrada");
            return;
        }

        ItemOrden itemOrden = new ItemOrden(producto, cantidad);
        orden.agregarItem(itemOrden);

        JOptionPane.showMessageDialog(this, "Item agregado a la orden");

        productoField.setText("");
        cantidadField.setText("");

        actualizarListaOrdenes(idCliente);
    }

    private void actualizarListaOrdenes(int idCliente) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Orden orden : tienda.obtenerOrdenesCliente(idCliente)) {
            model.addElement("Orden para " + orden.getCliente().getNombre() + " " + orden.getCliente().getApellido() + " - Total: $" + String.format("%.2f", orden.getTotal()));
        }
        ordenesList.setModel(model);
    }

    private void mostrarDetallesOrden() {
        int selectedIndex = ordenesList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedOrden = ordenesList.getModel().getElementAt(selectedIndex);
            for (Orden orden : tienda.getOrdenes()) {
                if (selectedOrden.contains(orden.getCliente().getNombre()) && selectedOrden.contains(orden.getCliente().getApellido())) {
                    ordenesArea.setText(orden.mostrarInfo());
                    totalLabel.setText("Total de la Orden: $" + String.format("%.2f", orden.getTotal()));
                    break;
                }
            }
        }
    }
}

