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

public class ClientesPanel extends JPanel {
    private TiendaModel tienda;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField idField;

    public ClientesPanel(TiendaModel tienda) {
        this.tienda = tienda;
        setLayout(new BorderLayout());
        setBackground(new Color(144, 238, 144));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(new Color(144, 238, 144));

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        formPanel.add(apellidoField);

        formPanel.add(new JLabel("ID Cliente:"));
        idField = new JTextField();
        formPanel.add(idField);

        JButton registrarButton = new JButton("Registrar Cliente");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });
        formPanel.add(new JLabel());
        formPanel.add(registrarButton);

        add(formPanel, BorderLayout.NORTH);
    }

    private void registrarCliente() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        int idCliente = Integer.parseInt(idField.getText());

        Cliente cliente = new Cliente(nombre, apellido, idCliente);
        tienda.registrarCliente(cliente);

        JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente");

        nombreField.setText("");
        apellidoField.setText("");
        idField.setText("");
    }
}
