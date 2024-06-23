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

public class ProductosPanel extends JPanel {
    private TiendaModel tienda;
    private JTextField nombreField;
    private JTextField precioField;
    private JTextField categoriaField;
    private JTextArea productosArea;

    public ProductosPanel(TiendaModel tienda) {
        this.tienda = tienda;
        setLayout(new BorderLayout());
        setBackground(new Color(173, 216, 230));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(new Color(173, 216, 230));

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Precio:"));
        precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Categoría:"));
        categoriaField = new JTextField();
        formPanel.add(categoriaField);

        JButton registrarButton = new JButton("Registrar Producto");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });
        formPanel.add(new JLabel());
        formPanel.add(registrarButton);

        add(formPanel, BorderLayout.NORTH);

        productosArea = new JTextArea();
        productosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productosArea);
        add(scrollPane, BorderLayout.CENTER);

        mostrarProductos();
    }

    private void registrarProducto() {
        String nombre = nombreField.getText();
        double precio = Double.parseDouble(precioField.getText());
        String categoriaNombre = categoriaField.getText();

        Categoria categoria = tienda.getCategorias().stream()
                .filter(c -> c.getNombre().equals(categoriaNombre))
                .findFirst()
                .orElse(new Categoria(categoriaNombre));

        if (!tienda.getCategorias().contains(categoria)) {
            tienda.getCategorias().add(categoria);
        }

        Producto producto = new Producto(nombre, precio, categoria);
        tienda.registrarProducto(producto);

        JOptionPane.showMessageDialog(this, "Producto registrado exitosamente");

        nombreField.setText("");
        precioField.setText("");
        categoriaField.setText("");

        mostrarProductos();
    }

    private void mostrarProductos() {
        productosArea.setText("");
        for (String producto : tienda.mostrarProductos()) {
            productosArea.append(producto + "\n");
        }
    }
}
