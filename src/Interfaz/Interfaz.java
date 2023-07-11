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
    JButton Actualizar;
    JButton agregarFila;
    JButton guardarFila;
    // ComboBox
    JComboBox<String> consultar;

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
        Actualizar = new JButton("Actualizar");
        Actualizar.setBounds(410, 60, 100, 40);
        Actualizar.setBackground(Color.green);
        Actualizar.setVisible(false);
        Actualizar.addActionListener(this);
        add(Actualizar);

        obtenerConsulta = new JButton("Obtener consulta");
        obtenerConsulta.setBounds(245, 60, 150, 40);
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
        String[] labelComboBox = {"Seleccionar", "Proyectos de la comunidad", "Representante", "Responsable proyectos", "Evaluación Proyecto," ,
                "Objetivos y Evaluación", "Niños Comunidad", "Profecional Proyecto", "Profecional Especialización", "Proyecto Fecha"};
        consultar = new JComboBox<>(labelComboBox);
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

        if (Objects.equals(valorPrederminado, "Seleccionar")){
            consultar.setSelectedIndex(-1); // Deseleccionar el ítem "Ignorar"
        }
            
        if (item == 1) {
            if(Objects.equals(table.getName(), "comunidades")) {
                System.out.println(table.getName());
                consultar.setSelectedIndex(1);
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.proyectoDeComunidades(cod));
            }
        }else if(item == 2) {
            if(Objects.equals(table.getName(), "proyectos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.responsableProyecto0(cod));
            }
        }else if(item == 3){
            if(Objects.equals(table.getName(), "administrativos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.respoProyectosDirectivos(cod));
            }
        } else if (item == 4) {
            if(Objects.equals(table.getName(),"evaluacion")) {
                int eva = Integer.parseInt(JOptionPane.showInputDialog("Digite el porcentaje que desea evaluar (80)"));
                setTable(); // limpio los datos de la tabla
                agragarDataModel(consultas.evaluacionProyecto(eva));
            }

        } else if (item == 5) {
            if(Objects.equals(table.getName(), "proyectos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.ObjetivoEvaluacionProyecto(cod));
            }
        }else if (item == 6) {
            if (Objects.equals(table.getName(), "comunidades")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 0); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.niñoComunidad(cod));
            }
        }else if (item == 7) {
            if (Objects.equals(table.getName(), "proyectos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.profecionalProyecto(cod));
            }
        }else if (item == 8) {
            if (Objects.equals(table.getName(), "profecionales")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                String especializacion = (String) model.getValueAt(indexRow, 0); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.profecionalEspecializacion(especializacion));
            }
        }else if (item == 9) {
            if (Objects.equals(table.getName(), "proyectos")) {
                String fechainicio = JOptionPane.showInputDialog("Digite la fecha inicial (2023-06-02)");
                String fechafinal = JOptionPane.showInputDialog("Digite la fecha Final (2023-10-31)");
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.rangoFechaProyecto(fechainicio,fechafinal));
            }
        }
    }

    public void ActualizarTablas (){
        if(Objects.equals(table.getName(), "proyectos")) {
            int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
            String descripcion = (String) model.getValueAt(indexRow, 1); // obtengo el valor de la celda deseada
            String alcance = (String) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada
            int presupuesto = (int) model.getValueAt(indexRow, 3); // obtengo el valor de la celda deseada
            int cod_pro = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada

            agragarDataModel(consultas.ActualizarTablaPro(descripcion,alcance,presupuesto,cod_pro));

        }
        if(Objects.equals(table.getName(), "empleados")){
            int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada

            int salario = Integer.parseInt((String) model.getValueAt(indexRow, 1)); // obtengo el valor de la celda deseada
            int cod_emp = (int) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada

            agragarDataModel(consultas.ActualizarTablaEmp(salario,cod_emp));
        }
    }

    public void insertardatosPosgrest(){
        int lastFila = table.getSelectedRow(); // obtengo la última fila de la tabla
        String tableName = encabezadoTable.getName();

        StringBuilder rowData = new StringBuilder(); // guardar los dataos
        for (int i = 0; i < table.getColumnCount(); i++) {
            rowData.append((String) table.getValueAt(lastFila, i));
        }
        System.out.println(rowData);

        consultas.insertenTabla(tableName, rowData);
    }

    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();

            Actualizar.setVisible(false);
            if (jm == I_proyectos) {
                setTable();
                Actualizar.setVisible(true);
                agragarDataModel(consultas.C_proyectos);
                table.setName("proyectos");
            }
            if (jm == I_comunidades) {
                setTable();
                agragarDataModel(consultas.C_comunidades);
                table.setName("comunidades");
            }
            if (jm == I_Empleados) {
                setTable();
                Actualizar.setVisible(true);
                agragarDataModel(consultas.C_empleados);
            }
            if (jm == I_administrativos) {
                setTable();
                agragarDataModel(consultas.C_administrativos);
                table.setName("administrativos");
            }
            if (jm == I_profecionales) {
                setTable();
                agragarDataModel(consultas.C_profecionales);
                table.setName("profecionales");
            }
            if (jm == I_Representate) {
                setTable();
                agragarDataModel(consultas.C_representante);
                table.setName("representante");
            }
            if (jm == I_D_contacto_Representante) {
                setTable();
                agragarDataModel(consultas.C_Drepresentante);
                table.setName("dcontacto_representante");
            }
            if (jm == I_objetivos) {
                setTable();
                agragarDataModel(consultas.C_objetivos);

            }
            if (jm == I_Tema) {
                setTable();
                agragarDataModel(consultas.C_tema);
                table.setName("tema");
            }
            if (jm == I_Evaluacion) {
                setTable();
                agragarDataModel(consultas.C_evaluacion);
                table.setName("evaluacion");
            }
            if (jm == I_niños) {
                setTable();
                agragarDataModel(consultas.C_niños);
                table.setName("niños");
            }
            if (jm == I_participacion) {
                setTable();
                agragarDataModel(consultas.C_participacion);
                table.setName("participacion");
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if (jb == obtenerConsulta) {
            ObtenerSeleccion();
        }
        if(jb == Actualizar){
            ActualizarTablas();
        }
        if(jb == agregarFila){
            model.addRow(new Object[]{""});
        }
        if (jb == guardarFila) {
            insertardatosPosgrest();
        }
    }
}
