package Interfaz;

import Queries.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Interfaz extends JFrame implements ActionListener {

    // Botones
    JButton obtenerConsulta;
    JButton evaluacion;

    // ComboBox
    JComboBox consultar;

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

    // Crear un modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    JTable table; // Tabla

    // Llamo a la clase que tiene los metodos
    MetodosConsultas Metodoconsultas = new MetodosConsultas();
    Consultas consultas = new Consultas();

    public Interfaz() {
        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(30, 125, 620, 350);
        panel.setBackground(Color.cyan);
        add(panel);

        // Botones
      /*  evaluacion = new JButton("Evaluación");
        evaluacion.setBounds(380, 60, 100, 40);
        evaluacion.setBackground(Color.RED);
        evaluacion.addActionListener(this);
        add(evaluacion);*/

        obtenerConsulta = new JButton("Obtener consulta");
        obtenerConsulta.setBounds(245, 60, 100, 40);
        obtenerConsulta.setBackground(Color.RED);
        obtenerConsulta.addActionListener(this);
        add(obtenerConsulta);

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
        String[] labelComboBox = {"Seleccionar", "Proyectos de la comunidad", "Representante", "Responsable proyectos"};
        consultar = new JComboBox(labelComboBox);
        consultar.setEditable(false);
        consultar.setSelectedIndex(0); // seleccionar item de manera predeterminada
        consultar.setBounds(40, 60, 200, 40);
        add(consultar);

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

    public void setTable() {
        model.setRowCount(0);
        model.setColumnCount(0);
    }

    // Se crea un método que va a recibir una consulta y agrega los datos al modelo de la tabla
    public void agragarDataModel(String data) {
        for (String columna : Metodoconsultas.getColmnas(data)) { // recorro los datos obtenidos en la consulta
            model.addColumn(columna); // agregos los datos al model
        }
        for (Object[] fila : Metodoconsultas.ejecutarConsulta(data)) {
            model.addRow(fila);
        }
    }

    public void ObtenerSeleccion() {
        String valorPrederminado = (String) consultar.getSelectedItem();
        int item = consultar.getSelectedIndex();
        String columname = table.getColumnName(0);

        if (Objects.equals(valorPrederminado, "Seleccionar")) {
            consultar.setSelectedIndex(-1); // Deseleccionar el ítem "Ignorar"
        }
        if (item == 1) {
            if(Objects.equals(columname, "com_cod")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.proyectoDeComunidades(cod));
            }
        }else if(item == 2) {
            if(Objects.equals(columname, "pro_titulo")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.responsableProyecto0(cod));
            }
        }else if(item == 3){
            if(Objects.equals(columname, "adm_id")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.respoProyectosDirectivos(cod));
            }
        }
    }

    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();
            if (jm == I_proyectos) {
                setTable();
                agragarDataModel(consultas.C_proyectos);
            }
            if (jm == I_comunidades) {
                setTable();
                agragarDataModel(consultas.C_comunidades);
            }
            if (jm == I_Empleados) {
                setTable();
                agragarDataModel(consultas.C_empleados);
            }
            if (jm == I_administrativos) {
                setTable();
                agragarDataModel(consultas.C_administrativos);
            }
            if (jm == I_profecionales) {
                setTable();
                agragarDataModel(consultas.C_profecionales);
            }
            if (jm == I_Representate) {
                setTable();
                agragarDataModel(consultas.C_representante);
            }
            if (jm == I_D_contacto_Representante) {
                setTable();
                agragarDataModel(consultas.C_Drepresentante);
            }
            if (jm == I_objetivos) {
                setTable();
                agragarDataModel(consultas.C_objetivos);

            }
            if (jm == I_Tema) {
                setTable();
                agragarDataModel(consultas.C_tema);
            }
            if (jm == I_Evaluacion) {
                setTable();
                agragarDataModel(consultas.C_evaluacion);
            }
            if (jm == I_niños) {
                setTable();
                agragarDataModel(consultas.C_niños);
            }
            if (jm == I_participacion) {
                setTable();
                agragarDataModel(consultas.C_participacion);
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if (jb == obtenerConsulta) {
            ObtenerSeleccion();
        }
    }
}
