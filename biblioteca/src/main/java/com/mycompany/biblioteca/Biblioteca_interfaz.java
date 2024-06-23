/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.biblioteca;

/**
 *
 * @author danie
 */
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Biblioteca_interfaz extends JFrame {
    private final Biblioteca biblioteca;
    private JPanel currentPanel;

    public Biblioteca_interfaz() {
        biblioteca = new Biblioteca();
        setTitle("Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        showMainScreen();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem mainMenuItem = new JMenuItem("Inicio");
        mainMenuItem.addActionListener(e -> showMainScreen());
        menu.add(mainMenuItem);

        JMenuItem registerBookMenuItem = new JMenuItem("Registrar Libro");
        registerBookMenuItem.addActionListener(e -> showRegisterBook());
        menu.add(registerBookMenuItem);

        JMenuItem registerUserMenuItem = new JMenuItem("Registrar Usuario");
        registerUserMenuItem.addActionListener(e -> showRegisterUser());
        menu.add(registerUserMenuItem);

        JMenuItem loanBookMenuItem = new JMenuItem("Realizar Préstamo");
        loanBookMenuItem.addActionListener(e -> showLoanBook());
        menu.add(loanBookMenuItem);

        menu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Salir");
        exitMenuItem.addActionListener(e -> onClose());
        menu.add(exitMenuItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void clearPanel() {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = new JPanel();
        currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.Y_AXIS));
        add(currentPanel);
        revalidate();
        repaint();
    }

    private void showMainScreen() {
        clearPanel();
        JLabel label = new JLabel("Bienvenido a la Biblioteca");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(label);

        JButton showBooksButton = new JButton("Mostrar Libros");
        showBooksButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showBooksButton.addActionListener(e -> showBooks());
        currentPanel.add(showBooksButton);

        JButton showLoansButton = new JButton("Mostrar Préstamos");
        showLoansButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showLoansButton.addActionListener(e -> showLoans());
        currentPanel.add(showLoansButton);
    }

    private void showRegisterBook() {
        clearPanel();
        JLabel titleLabel = new JLabel("Registrar Libro");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField tituloField = new JTextField();
        addField("Titulo", tituloField);
        JTextField isbnField = new JTextField();
        addField("ISBN", isbnField);
        JTextField autorField = new JTextField();
        addField("Autor", autorField);
        JTextField categoriaField = new JTextField();
        addField("Categoría", categoriaField);

        JButton registerButton = new JButton("Registrar");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String isbn = isbnField.getText();
            String autorNombre = autorField.getText();
            String categoria = categoriaField.getText();

            if (!titulo.isEmpty() && !isbn.isEmpty() && !autorNombre.isEmpty() && !categoria.isEmpty()) {
                Autor autor = new Autor(autorNombre, "");
                Libro libro = new Libro(titulo, isbn, autor, categoria);
                biblioteca.registrarLibro(libro);
                JOptionPane.showMessageDialog(this, "Libro registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        currentPanel.add(registerButton);
    }

    private void showRegisterUser() {
        clearPanel();
        JLabel titleLabel = new JLabel("Registrar Usuario");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField nombreField = new JTextField();
        addField("Nombre", nombreField);
        JTextField apellidoField = new JTextField();
        addField("Apellido", apellidoField);
        JTextField idUsuarioField = new JTextField();
        addField("ID Usuario", idUsuarioField);

        JButton registerButton = new JButton("Registrar");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String idUsuario = idUsuarioField.getText();

            if (!nombre.isEmpty() && !apellido.isEmpty() && !idUsuario.isEmpty()) {
                Usuario usuario = new Usuario(nombre, apellido, idUsuario);
                biblioteca.registrarUsuario(usuario);
                JOptionPane.showMessageDialog(this, "Usuario registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        currentPanel.add(registerButton);
    }

    private void showLoanBook() {
        clearPanel();
        JLabel titleLabel = new JLabel("Realizar Préstamo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField idUsuarioField = new JTextField();
        addField("ID Usuario", idUsuarioField);
        JTextField isbnLibroField = new JTextField();
        addField("ISBN Libro", isbnLibroField);
        JTextField fechaPrestamoField = new JTextField();
        addField("Fecha de Préstamo", fechaPrestamoField);
        JTextField fechaDevolucionField = new JTextField();
        addField("Fecha de Devolución", fechaDevolucionField);

        JButton loanButton = new JButton("Realizar Préstamo");
        loanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loanButton.addActionListener(e -> {
            String idUsuario = idUsuarioField.getText();
            String isbnLibro = isbnLibroField.getText();
            String fechaPrestamo = fechaPrestamoField.getText();
            String fechaDevolucion = fechaDevolucionField.getText();

            Usuario usuario = biblioteca.getUsuarios().stream()
                    .filter(u -> u.toString().contains(idUsuario))
                    .findFirst()
                    .orElse(null);
            Libro libro = biblioteca.getLibros().stream()
                    .filter(l -> l.toString().contains(isbnLibro))
                    .findFirst()
                    .orElse(null);

            if (usuario != null && libro != null && !fechaPrestamo.isEmpty() && !fechaDevolucion.isEmpty()) {
                Prestamo prestamo = new Prestamo(libro, usuario, LocalDate.parse(fechaPrestamo), LocalDate.parse(fechaDevolucion));
                biblioteca.realizarPrestamo(prestamo);
                JOptionPane.showMessageDialog(this, "Préstamo realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Datos inválidos o incompletos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        currentPanel.add(loanButton);
    }

    private void showBooks() {
        clearPanel();
        JLabel titleLabel = new JLabel("Libros en la Biblioteca");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        for (Libro libro : biblioteca.getLibros()) {
            JLabel bookLabel = new JLabel(libro.toString());
            bookLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            currentPanel.add(bookLabel);
        }
    }

    private void showLoans() {
        clearPanel();
        JLabel titleLabel = new JLabel("Préstamos Realizados");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        for (Prestamo prestamo : biblioteca.getPrestamos()) {
            JLabel loanLabel = new JLabel(prestamo.toString());
            loanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            currentPanel.add(loanLabel);
        }
    }

    private void addField(String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(label);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
        currentPanel.add(textField);
    }

    private void onClose() {
        int confirmed = JOptionPane.showConfirmDialog(this, "¿Quieres salir de la aplicación?", "Salir", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Biblioteca_interfaz app = new Biblioteca_interfaz();
            app.setVisible(true);
        });
    }
}

