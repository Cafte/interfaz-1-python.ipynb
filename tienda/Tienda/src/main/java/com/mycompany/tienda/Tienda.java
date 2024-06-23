/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tienda;

/**
 *
 * @author danie
 */
import javax.swing.*;
import java.awt.*;

public class Tienda {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Gestión de Tienda");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            TiendaModel tienda = new TiendaModel();
            JTabbedPane tabbedPane = new JTabbedPane();

            ProductosPanel productosPanel = new ProductosPanel(tienda);
            ClientesPanel clientesPanel = new ClientesPanel(tienda);
            OrdenesPanel ordenesPanel = new OrdenesPanel(tienda);

            tabbedPane.addTab("Productos", productosPanel);
            tabbedPane.addTab("Clientes", clientesPanel);
            tabbedPane.addTab("Órdenes", ordenesPanel);

            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
