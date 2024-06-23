/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestioncursos;

/**
 *
 * @author danie
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionCursos {
    private JFrame frame;
    private JPanel currentPanel;
    private final ArrayList<Profesor> profesores;
    private final ArrayList<Estudiante> estudiantes;
    private final ArrayList<Curso> cursos;
    private final ArrayList<Evaluacion> evaluaciones;

    public GestionCursos() {
        profesores = new ArrayList<>();
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        evaluaciones = new ArrayList<>();

        frame = new JFrame("Sistema de Gestión de Cursos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem inicioMenuItem = new JMenuItem("Inicio");
        JMenuItem registrarProfesorMenuItem = new JMenuItem("Registrar Profesor");
        JMenuItem registrarEstudianteMenuItem = new JMenuItem("Registrar Estudiante");
        JMenuItem registrarCursoMenuItem = new JMenuItem("Registrar Curso");
        JMenuItem registrarEvaluacionMenuItem = new JMenuItem("Registrar Evaluación");
        JMenuItem salirMenuItem = new JMenuItem("Salir");

        menu.add(inicioMenuItem);
        menu.add(registrarProfesorMenuItem);
        menu.add(registrarEstudianteMenuItem);
        menu.add(registrarCursoMenuItem);
        menu.add(registrarEvaluacionMenuItem);
        menu.addSeparator();
        menu.add(salirMenuItem);

        frame.setJMenuBar(menuBar);

        inicioMenuItem.addActionListener(event -> showMainScreen());
        registrarProfesorMenuItem.addActionListener(event -> showRegisterProfessor());
        registrarEstudianteMenuItem.addActionListener(event -> showRegisterStudent());
        registrarCursoMenuItem.addActionListener(event -> showRegisterCourse());
        registrarEvaluacionMenuItem.addActionListener(event -> showRegisterEvaluation());
        salirMenuItem.addActionListener(event -> frame.dispose());

        showMainScreen();
        frame.setVisible(true);
    }

    private void clearPanel() {
        if (currentPanel != null) {
            frame.remove(currentPanel);
        }
        currentPanel = new JPanel();
        currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.Y_AXIS));
        frame.add(currentPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showMainScreen() {
        clearPanel();
        JLabel label = new JLabel("Bienvenido al Sistema Escolar");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(label);

        JButton showProfessorsButton = new JButton("Mostrar Profesores");
        JButton showStudentsButton = new JButton("Mostrar Estudiantes");
        JButton showCoursesButton = new JButton("Mostrar Cursos");
        JButton showEvaluationsButton = new JButton("Mostrar Evaluaciones");

        showProfessorsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showStudentsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showCoursesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showEvaluationsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        showProfessorsButton.addActionListener(event -> showProfessors());
        showStudentsButton.addActionListener(event -> showStudents());
        showCoursesButton.addActionListener(event -> showCourses());
        showEvaluationsButton.addActionListener(event -> showEvaluations());

        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(showProfessorsButton);
        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(showStudentsButton);
        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(showCoursesButton);
        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(showEvaluationsButton);
    }

    private void showRegisterProfessor() {
        clearPanel();
        JLabel titleLabel = new JLabel("Registrar Profesor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField nombreField = new JTextField(20);
        JTextField apellidoField = new JTextField(20);
        JTextField asignaturaField = new JTextField(20);

        currentPanel.add(new JLabel("Nombre:"));
        currentPanel.add(nombreField);
        currentPanel.add(new JLabel("Apellido:"));
        currentPanel.add(apellidoField);
        currentPanel.add(new JLabel("Asignatura:"));
        currentPanel.add(asignaturaField);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarButton.addActionListener(event -> {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String asignatura = asignaturaField.getText();

            if (!nombre.isEmpty() && !apellido.isEmpty() && !asignatura.isEmpty()) {
                Profesor profesor = new Profesor(nombre, apellido, asignatura);
                profesores.add(profesor);
                JOptionPane.showMessageDialog(frame, "Profesor registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(frame, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(registrarButton);
    }

    private void showRegisterStudent() {
        clearPanel();
        JLabel titleLabel = new JLabel("Registrar Estudiante");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField nombreField = new JTextField(20);
        JTextField apellidoField = new JTextField(20);
        JTextField idEstudianteField = new JTextField(20);
        JTextField cursosField = new JTextField(20);

        currentPanel.add(new JLabel("Nombre:"));
        currentPanel.add(nombreField);
        currentPanel.add(new JLabel("Apellido:"));
        currentPanel.add(apellidoField);
        currentPanel.add(new JLabel("ID Estudiante:"));
        currentPanel.add(idEstudianteField);
        currentPanel.add(new JLabel("Cursos (separados por coma):"));
        currentPanel.add(cursosField);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarButton.addActionListener((ActionEvent event) -> {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String idEstudiante = idEstudianteField.getText();
            String[] cursos1 = cursosField.getText().split(",");
            if (!nombre.isEmpty() && !apellido.isEmpty() && !idEstudiante.isEmpty() && cursos1.length > 0) {
                Estudiante estudiante = new Estudiante(nombre, apellido, idEstudiante, cursos1);
                estudiantes.add(estudiante);
                JOptionPane.showMessageDialog(frame, "Estudiante registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(frame, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(registrarButton);
    }

    private void showRegisterCourse() {
        clearPanel();
        JLabel titleLabel = new JLabel("Registrar Curso");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField nombreField = new JTextField(20);
        JTextField profesorField = new JTextField(20);
        JTextField estudiantesField = new JTextField(20);
        JTextField horarioField = new JTextField(20);

        currentPanel.add(new JLabel("Nombre del Curso:"));
        currentPanel.add(nombreField);
        currentPanel.add(new JLabel("Profesor (Nombre):"));
        currentPanel.add(profesorField);
        currentPanel.add(new JLabel("Estudiantes (IDs separados por coma):"));
        currentPanel.add(estudiantesField);
        currentPanel.add(new JLabel("Horario (dia,horaInicio,horaFin):"));
        currentPanel.add(horarioField);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String nombreCurso = nombreField.getText();
                String profesorNombre = profesorField.getText();
                String[] estudiantesIDs = estudiantesField.getText().split(",");
                String[] horarioInfo = horarioField.getText().split(",");
                
                Profesor profesor = profesores.stream().filter(p -> p.toString().contains(profesorNombre)).findFirst().orElse(null);
                ArrayList<Estudiante> estudiantesCurso = new ArrayList<>();
                for (String id : estudiantesIDs) {
                    Estudiante estudiante = estudiantes.stream().filter(stud -> stud.getIdEstudiante().equals(id)).findFirst().orElse(null);
                    if (estudiante != null) {
                        estudiantesCurso.add(estudiante);
                    }
                }
                
                if (profesor != null && !estudiantesCurso.isEmpty() && horarioInfo.length == 3) {
                    Horario horario = new Horario(horarioInfo[0], horarioInfo[1], horarioInfo[2]);
                    Curso curso = new Curso(nombreCurso, profesor, estudiantesCurso, horario);
                    cursos.add(curso);
                    JOptionPane.showMessageDialog(frame, "Curso registrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(frame, "Todos los campos son requeridos y deben ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(registrarButton);
    }

    private void showRegisterEvaluation() {
        clearPanel();
        JLabel titleLabel = new JLabel("Registrar Evaluación");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        JTextField nombreField = new JTextField(20);
        JTextField cursoField = new JTextField(20);
        JTextField estudianteField = new JTextField(20);
        JTextField notaField = new JTextField(20);

        currentPanel.add(new JLabel("Nombre de la Evaluación:"));
        currentPanel.add(nombreField);
        currentPanel.add(new JLabel("Curso (Nombre):"));
        currentPanel.add(cursoField);
        currentPanel.add(new JLabel("Estudiante (ID):"));
        currentPanel.add(estudianteField);
        currentPanel.add(new JLabel("Nota:"));
        currentPanel.add(notaField);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrarButton.addActionListener((ActionEvent event) -> {
            String nombreEvaluacion = nombreField.getText();
            String nombreCurso = cursoField.getText();
            String idEstudiante = estudianteField.getText();
            String nota = notaField.getText();

            Curso curso = cursos.stream().filter(c -> c.getNombre().equals(nombreCurso)).findFirst().orElse(null);
            Estudiante estudiante = estudiantes.stream().filter(e -> e.getIdEstudiante().equals(idEstudiante)).findFirst().orElse(null);

            if (curso != null && estudiante != null && !nota.isEmpty()) {
                Evaluacion evaluacion = new Evaluacion(nombreEvaluacion, curso, estudiante, Double.parseDouble(nota));
                evaluaciones.add(evaluacion);
                JOptionPane.showMessageDialog(frame, "Evaluación registrada con éxito");
            } else {
                JOptionPane.showMessageDialog(frame, "Todos los campos son requeridos y deben ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        currentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        currentPanel.add(registrarButton);
    }

    private void showProfessors() {
        clearPanel();
        JLabel titleLabel = new JLabel("Profesores Registrados");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        for (Profesor profesor : profesores) {
            JLabel label = new JLabel(profesor.toString());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            currentPanel.add(label);
        }
    }

    private void showStudents() {
        clearPanel();
        JLabel titleLabel = new JLabel("Estudiantes Registrados");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        for (Estudiante estudiante : estudiantes) {
            JLabel label = new JLabel(estudiante.toString());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            currentPanel.add(label);
        }
    }

    private void showCourses() {
        clearPanel();
        JLabel titleLabel = new JLabel("Cursos Registrados");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        for (Curso curso : cursos) {
            JLabel label = new JLabel(curso.toString());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            currentPanel.add(label);
        }
    }

    private void showEvaluations() {
        clearPanel();
        JLabel titleLabel = new JLabel("Evaluaciones Registradas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(titleLabel);

        for (Evaluacion evaluacion : evaluaciones) {
            JLabel label = new JLabel(evaluacion.toString());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            currentPanel.add(label);
        }
    }

    public static void main(String[] args) {
        new GestionCursos();
    }
}
