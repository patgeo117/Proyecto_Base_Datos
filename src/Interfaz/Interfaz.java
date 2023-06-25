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

    // Labels

    // TextField

    // Crear un modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();

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


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb == proyectos){
            setTable();

            for (String columna : Metodoconsultas.getColumnasProyecto()){
                model.addColumn(columna);
            }

            for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.proyec)) {
                model.addRow(fila);
            }
        }

        if(jb == responsable){
            setTable();

            for (String columna : Metodoconsultas.getColumnasRepresentante()){
                model.addColumn(columna);
            }

            for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.respon)) {
                model.addRow(fila);
            }
        }
        if(jb == evaluacion){
            setTable();

            for (String columna : Metodoconsultas.getColumnasEvaluacion()){
                model.addColumn(columna);
            }

            for (Object[] fila : Metodoconsultas.ejecutarConsulta(consultas.evalua)) {
                model.addRow(fila);
            }
        }
    }
}
