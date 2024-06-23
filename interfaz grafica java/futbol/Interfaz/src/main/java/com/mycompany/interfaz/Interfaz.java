/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interfaz;

/**
 *
 * @author danie
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Interfaz {
    private final Mundial mundial = new Mundial();
    private JFrame frame;

    private JTextField equipoNombreField;
    private JTextField equipoEntrenadorField;
    private JTextField jugadorNombreField;
    private JTextField jugadorEdadField;
    private JTextField jugadorPosicionField;
    private JTextField jugadorEquipoField;
    private JTextField estadioNombreField;
    private JTextField estadioCiudadField;
    private JTextField estadioCapacidadField;
    private JTextField grupoNombreField;
    private JTextField localEquipoField;
    private JTextField visitanteEquipoField;
    private JTextField estadioPartidoField;

    private JList<String> listaEquipos;
    private DefaultListModel<String> modeloEquipos;
    private JList<String> listaJugadores;
    private DefaultListModel<String> modeloJugadores;
    private JList<String> listaEstadios;
    private DefaultListModel<String> modeloEstadios;
    private JList<String> listaGrupos;
    private DefaultListModel<String> modeloGrupos;
    private JList<String> listaPartidos;
    private DefaultListModel<String> modeloPartidos;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Sistema de Gestión de Mundial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add("Equipos", crearPanelEquipos());
        tabbedPane.add("Jugadores", crearPanelJugadores());
        tabbedPane.add("Estadios", crearPanelEstadios());
        tabbedPane.add("Grupos", crearPanelGrupos());
        tabbedPane.add("Partidos", crearPanelPartidos());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel crearPanelEquipos() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#FFCCCB"));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.setBackground(Color.decode("#FFCCCB"));

        formulario.add(new JLabel("Nombre del Equipo:"));
        equipoNombreField = new JTextField();
        formulario.add(equipoNombreField);

        formulario.add(new JLabel("Nombre del Entrenador:"));
        equipoEntrenadorField = new JTextField();
        formulario.add(equipoEntrenadorField);

        JButton btnRegistrarEquipo = new JButton("Registrar Equipo");
        btnRegistrarEquipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEquipo();
            }
        });
        formulario.add(btnRegistrarEquipo);

        panel.add(formulario, BorderLayout.NORTH);

        modeloEquipos = new DefaultListModel<>();
        listaEquipos = new JList<>(modeloEquipos);
        panel.add(new JScrollPane(listaEquipos), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelJugadores() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#FFCCCB"));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.setBackground(Color.decode("#FFCCCB"));

        formulario.add(new JLabel("Nombre del Jugador:"));
        jugadorNombreField = new JTextField();
        formulario.add(jugadorNombreField);

        formulario.add(new JLabel("Edad:"));
        jugadorEdadField = new JTextField();
        formulario.add(jugadorEdadField);

        formulario.add(new JLabel("Posición:"));
        jugadorPosicionField = new JTextField();
        formulario.add(jugadorPosicionField);

        formulario.add(new JLabel("Nombre del Equipo:"));
        jugadorEquipoField = new JTextField();
        formulario.add(jugadorEquipoField);

        JButton btnRegistrarJugador = new JButton("Registrar Jugador");
        btnRegistrarJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarJugador();
            }
        });
        formulario.add(btnRegistrarJugador);

        panel.add(formulario, BorderLayout.NORTH);

        modeloJugadores = new DefaultListModel<>();
        listaJugadores = new JList<>(modeloJugadores);
        panel.add(new JScrollPane(listaJugadores), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelEstadios() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#FFCCCB"));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.setBackground(Color.decode("#FFCCCB"));

        formulario.add(new JLabel("Nombre del Estadio:"));
        estadioNombreField = new JTextField();
        formulario.add(estadioNombreField);

        formulario.add(new JLabel("Ciudad:"));
        estadioCiudadField = new JTextField();
        formulario.add(estadioCiudadField);

        formulario.add(new JLabel("Capacidad:"));
        estadioCapacidadField = new JTextField();
        formulario.add(estadioCapacidadField);

        JButton btnRegistrarEstadio = new JButton("Registrar Estadio");
        btnRegistrarEstadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEstadio();
            }
        });
        formulario.add(btnRegistrarEstadio);

        panel.add(formulario, BorderLayout.NORTH);

        modeloEstadios = new DefaultListModel<>();
        listaEstadios = new JList<>(modeloEstadios);
        panel.add(new JScrollPane(listaEstadios), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelGrupos() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#FFCCCB"));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.setBackground(Color.decode("#FFCCCB"));

        formulario.add(new JLabel("Nombre del Grupo:"));
        grupoNombreField = new JTextField();
        formulario.add(grupoNombreField);

        JButton btnRegistrarGrupo = new JButton("Registrar Grupo");
        btnRegistrarGrupo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarGrupo();
            }
        });
        formulario.add(btnRegistrarGrupo);

        panel.add(formulario, BorderLayout.NORTH);

        modeloGrupos = new DefaultListModel<>();
        listaGrupos = new JList<>(modeloGrupos);
        panel.add(new JScrollPane(listaGrupos), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelPartidos() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#FFCCCB"));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.setBackground(Color.decode("#FFCCCB"));

        formulario.add(new JLabel("Equipo Local:"));
        localEquipoField = new JTextField();
        formulario.add(localEquipoField);

        formulario.add(new JLabel("Equipo Visitante:"));
        visitanteEquipoField = new JTextField();
        formulario.add(visitanteEquipoField);

        formulario.add(new JLabel("Estadio:"));
        estadioPartidoField = new JTextField();
        formulario.add(estadioPartidoField);

        JButton btnRegistrarPartido = new JButton("Registrar Partido");
        btnRegistrarPartido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarPartido();
            }
        });
        formulario.add(btnRegistrarPartido);

        JButton btnJugarPartido = new JButton("Jugar Partido");
        btnJugarPartido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugarPartido();
            }
        });
        formulario.add(btnJugarPartido);

        panel.add(formulario, BorderLayout.NORTH);

        modeloPartidos = new DefaultListModel<>();
        listaPartidos = new JList<>(modeloPartidos);
        panel.add(new JScrollPane(listaPartidos), BorderLayout.CENTER);

        return panel;
    }

    private void agregarEquipo() {
        String nombre = equipoNombreField.getText();
        String entrenador = equipoEntrenadorField.getText();
        Equipo equipo = new Equipo(nombre, entrenador);
        Grupo grupo = new Grupo(nombre); // Crear un grupo con el mismo nombre del equipo
        grupo.agregarEquipo(equipo);
        mundial.registrarGrupo(grupo);
        JOptionPane.showMessageDialog(frame, "Equipo registrado exitosamente", "Registro de Equipo", JOptionPane.INFORMATION_MESSAGE);
        equipoNombreField.setText("");
        equipoEntrenadorField.setText("");
        actualizarListaEquipos();
    }

    private void agregarJugador() {
        String nombre = jugadorNombreField.getText();
        int edad = Integer.parseInt(jugadorEdadField.getText());
        String posicion = jugadorPosicionField.getText();
        String nombreEquipo = jugadorEquipoField.getText();
        
        for (Grupo grupo : mundial.getGrupos()) {
            for (Equipo equipo : grupo.getEquipos()) {
                if (equipo.getNombre().equals(nombreEquipo)) {
                    Jugador jugador = new Jugador(nombre, edad, posicion);
                    equipo.agregarJugador(jugador);
                    JOptionPane.showMessageDialog(frame, "Jugador registrado exitosamente", "Registro de Jugador", JOptionPane.INFORMATION_MESSAGE);
                    jugadorNombreField.setText("");
                    jugadorEdadField.setText("");
                    jugadorPosicionField.setText("");
                    jugadorEquipoField.setText("");
                    actualizarListaJugadores();
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, "Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void agregarEstadio() {
        String nombre = estadioNombreField.getText();
        String ciudad = estadioCiudadField.getText();
        int capacidad = Integer.parseInt(estadioCapacidadField.getText());
        Estadio estadio = new Estadio(nombre, ciudad, capacidad);
        mundial.registrarEstadio(estadio);
        JOptionPane.showMessageDialog(frame, "Estadio registrado exitosamente", "Registro de Estadio", JOptionPane.INFORMATION_MESSAGE);
        estadioNombreField.setText("");
        estadioCiudadField.setText("");
        estadioCapacidadField.setText("");
        actualizarListaEstadios();
    }

    private void agregarGrupo() {
        String nombre = grupoNombreField.getText();
        Grupo grupo = new Grupo(nombre);
        mundial.registrarGrupo(grupo);
        JOptionPane.showMessageDialog(frame, "Grupo registrado exitosamente", "Registro de Grupo", JOptionPane.INFORMATION_MESSAGE);
        grupoNombreField.setText("");
        actualizarListaGrupos();
    }

    private void registrarPartido() {
        String local = localEquipoField.getText();
        String visitante = visitanteEquipoField.getText();
        String estadio = estadioPartidoField.getText();

        Equipo equipoLocal = buscarEquipo(local);
        Equipo equipoVisitante = buscarEquipo(visitante);
        Estadio estadioPartido = buscarEstadio(estadio);

        if (equipoLocal != null && equipoVisitante != null && estadioPartido != null) {
            Partido partido = new Partido(equipoLocal, equipoVisitante, estadioPartido);
            mundial.registrarPartido(partido);
            JOptionPane.showMessageDialog(frame, "Partido registrado exitosamente", "Registro de Partido", JOptionPane.INFORMATION_MESSAGE);
            localEquipoField.setText("");
            visitanteEquipoField.setText("");
            estadioPartidoField.setText("");
            actualizarListaPartidos();
        } else {
            JOptionPane.showMessageDialog(frame, "Datos del partido incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jugarPartido() {
        if (!modeloPartidos.isEmpty()) {
            Partido partido = mundial.getPartidos().get(0);
            String resultado = partido.jugar();
            JOptionPane.showMessageDialog(frame, resultado, "Resultado del Partido", JOptionPane.INFORMATION_MESSAGE);
            mundial.eliminarPartido(partido);
            actualizarListaPartidos();
        } else {
            JOptionPane.showMessageDialog(frame, "No hay partidos para jugar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Equipo buscarEquipo(String nombre) {
        for (Grupo grupo : mundial.getGrupos()) {
            for (Equipo equipo : grupo.getEquipos()) {
                if (equipo.getNombre().equals(nombre)) {
                    return equipo;
                }
            }
        }
        return null;
    }

    private Estadio buscarEstadio(String nombre) {
        for (Estadio estadio : mundial.getEstadios()) {
            if (estadio.getNombre().equals(nombre)) {
                return estadio;
            }
        }
        return null;
    }

    private void actualizarListaEquipos() {
        modeloEquipos.clear();
        for (Grupo grupo : mundial.getGrupos()) {
            for (Equipo equipo : grupo.getEquipos()) {
                modeloEquipos.addElement(equipo.mostrarInfo());
            }
        }
    }

    private void actualizarListaJugadores() {
        modeloJugadores.clear();
        for (Grupo grupo : mundial.getGrupos()) {
            for (Equipo equipo : grupo.getEquipos()) {
                for (Jugador jugador : equipo.getJugadores()) {
                    modeloJugadores.addElement(jugador.mostrarInfo());
                }
            }
        }
    }

    private void actualizarListaEstadios() {
        modeloEstadios.clear();
        for (Estadio estadio : mundial.getEstadios()) {
            modeloEstadios.addElement(estadio.mostrarInfo());
        }
    }

    private void actualizarListaGrupos() {
        modeloGrupos.clear();
        for (Grupo grupo : mundial.getGrupos()) {
            modeloGrupos.addElement(grupo.mostrarInfo());
        }
    }

    private void actualizarListaPartidos() {
        modeloPartidos.clear();
        for (Partido partido : mundial.getPartidos()) {
            modeloPartidos.addElement(partido.mostrarInfo());
        }
    }
}
