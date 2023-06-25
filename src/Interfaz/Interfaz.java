package Interfaz;

import Queries.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame implements ActionListener {

    // Botones
    JButton proyectos;
    JButton responsable;
    JButton evaluacion;

    // ComboBox
    JComboBox responDirectivos;
    // Panel
    JPanel panel;

    // JMenuBar
    JMenuBar menuBar;
    JMenu M_Tablas;
    JMenu M_Consultas;
    JMenuItem I_administrativos;
    JMenuItem I_comunidades;
    JMenuItem I_D_contacto_Representante;
    JMenuItem I_Empleados;
    JMenuItem I_Evaluacion;
    JMenuItem I_niños;
    JMenuItem I_objetivos;
    JMenuItem I_participacion;
    JMenuItem I_profecionales;
    JMenuItem I_proyectos;
    JMenuItem I_Representate;
    JMenuItem I_Tema;

    // TextField

    // Crear un modelo de la tabla
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    // Tabla
    JTable table;

    // Llamo a la clase que tiene los metodos
    MetodosConsultas Metodoconsultas = new MetodosConsultas();
    Consultas consultas = new Consultas();

    public Interfaz(){
        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(40, 120, 620, 350);
        panel.setBackground(Color.cyan);
        add(panel);
        
        // Botones
        responsable = new JButton("Responsable");
        responsable.setBounds(100, 60, 100, 40);
        responsable.setBackground(Color.RED);
        responsable.addActionListener(this);
        add(responsable);

        evaluacion = new JButton("Evaluación");
        evaluacion.setBounds(240, 60, 100, 40);
        evaluacion.setBackground(Color.RED);
        evaluacion.addActionListener(this);
        add(evaluacion);

        proyectos = new JButton("Proyectos");
        proyectos.setBounds(380, 60, 100, 40);
        proyectos.setBackground(Color.RED);
        proyectos.addActionListener(this);
        add(proyectos);

        // Configuración Jmenubar
        menuBar = new JMenuBar();
        M_Tablas = new JMenu("Tablas");
        M_Consultas = new JMenu("Consultas");

        I_proyectos = new JMenuItem("Proyectos");
        I_proyectos.addActionListener(Action2);

        I_comunidades = new JMenuItem("Comunidades");
        I_comunidades.addActionListener(Action2);

        I_Empleados = new JMenuItem("Empleados");
        I_Empleados.addActionListener(Action2);

        I_administrativos = new JMenuItem("Administrativos");
        I_administrativos.addActionListener(Action2);

        I_profecionales = new JMenuItem("Profecionales");
        I_profecionales.addActionListener(Action2);

        I_Representate = new JMenuItem("Representante");
        I_Representate.addActionListener(Action2);

        I_D_contacto_Representante = new JMenuItem("Datos Representante");
        I_D_contacto_Representante.addActionListener(Action2);

        I_objetivos = new JMenuItem("Objetivos");
        I_objetivos.addActionListener(Action2);

        I_Tema = new JMenuItem("Tema");
        I_Tema.addActionListener(Action2);

        I_Evaluacion = new JMenuItem("Evaluación");
        I_Evaluacion.addActionListener(Action2);

        I_niños = new JMenuItem("Niños");
        I_niños.addActionListener(Action2);

        I_participacion = new JMenuItem("Participantes");
        I_participacion.addActionListener(Action2);

        M_Tablas.add(I_proyectos);
        M_Tablas.add(I_comunidades);
        M_Tablas.add(I_Empleados);
        M_Tablas.add(I_administrativos);
        M_Tablas.add(I_profecionales);
        M_Tablas.add(I_Representate);
        M_Tablas.add(I_D_contacto_Representante);
        M_Tablas.add(I_objetivos);
        M_Tablas.add(I_Tema);
        M_Tablas.add(I_Evaluacion);
        M_Tablas.add(I_niños);
        M_Tablas.add(I_participacion);

        menuBar.add(M_Tablas);
        menuBar.add(M_Consultas);

        this.setJMenuBar(menuBar);


        // Jcombox
        responDirectivos = new JComboBox();
        //responDirectivos.setBounds(,60,);

        // Configuración Ventana
        setLayout(null);
        setSize(700, 600);
        setTitle("Biblioteca");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Se le dan las dimensiones
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(600, 300));
        // se añade al panel y además se le agrega el método JScroll para que se visualice de forma correcta
        panel.add(new JScrollPane(table));

    }
    public void setTable(){
        model.setRowCount(0);
        model.setColumnCount(0);
    }
    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();
            if(jm == I_proyectos){
                setTable();

                for (String columna : Metodoconsultas.getColumnasProyecto()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_proyectos)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_comunidades){
                setTable();

                for (String columna : Metodoconsultas.getColumnasComunidades()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_comunidades)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_Empleados){
                setTable();

                for (String columna : Metodoconsultas.getColumnasEmpleados()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_empleados)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_administrativos){
                setTable();

                for (String columna : Metodoconsultas.getColumnasAdministrativo()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_administrativos)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_profecionales){
                setTable();

                for (String columna : Metodoconsultas.getColumnasProfecionales()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_profecionales)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_Representate){
                setTable();

                for (String columna : Metodoconsultas.getColumnasRepresentante()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_respresentante)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_D_contacto_Representante){
                setTable();

                for (String columna : Metodoconsultas.getColumnasDRepresentante()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_Drepresentante)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_objetivos){
                setTable();

                for (String columna : Metodoconsultas.getColumnasObjetivo()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_objetivos)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_Tema){
                setTable();

                for (String columna : Metodoconsultas.getColumnasTema()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_tema)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_Evaluacion){
                setTable();

                for (String columna : Metodoconsultas.getColumnasEvaluacion()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_evaluacion)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_niños){
                setTable();

                for (String columna : Metodoconsultas.getColumnasNiños()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_niños)) {
                    model.addRow(fila);
                }

            }
            if(jm == I_participacion){
                setTable();

                for (String columna : Metodoconsultas.getColumnasParticipacion()){
                    model.addColumn(columna);
                }

                for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.C_participantes)) {
                    model.addRow(fila);
                }
            }
        }
    };


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb == proyectos){

        }

        if(jb == responsable){

        }
        if(jb == evaluacion){

        }
    }
}
