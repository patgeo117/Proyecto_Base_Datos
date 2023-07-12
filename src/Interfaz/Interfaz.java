package Interfaz;

import Queries.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
    DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<String>();

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
    JTable table = new JTable(); // Tabla
    JTableHeader encabezadoTable = table.getTableHeader(); // para asignarle un nombre a las tablas cabecera del jtable
    DefaultTableModel model = (DefaultTableModel) table.getModel();

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
        Actualizar.setBounds(550, 60, 100, 40);
        Actualizar.setBackground(Color.green);
        Actualizar.setVisible(false);
        Actualizar.addActionListener(this);
        add(Actualizar);

        obtenerConsulta = new JButton("Obtener consulta");
        obtenerConsulta.setBounds(380, 60, 150, 40);
        obtenerConsulta.setBackground(Color.RED);
        obtenerConsulta.addActionListener(this);
        add(obtenerConsulta);

        agregarFila = new JButton("Agragar fila");
        agregarFila.setBounds(60, 490, 110, 40);
        agregarFila.setBackground(Color.RED);
        agregarFila.addActionListener(this);
        add(agregarFila);

        guardarFila = new JButton("Guardar Fila");
        guardarFila.setBounds(180, 490,110,40);
        guardarFila.setBackground(Color.RED);
        guardarFila.addActionListener(this);
        add(guardarFila);

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
        String[] labelComboBox = {"Seleccionar", "Proyectos de la comunidad   (comunidades)", "Representante   (proyectos)",
                "Responsable proyectos   (administrativos)", "Evaluación Proyecto   (evaluación)" ,
                "Objetivos y Evaluación    (proyectos)", "Niños Comunidad   (comunidades)",
                "Profecional Proyecto   (proyectos)", "Profecional Especialización   (profesionales)", "Proyecto Fecha   (proyectos)"};
        consultar = new JComboBox<>(labelComboBox);
        consultar.setEditable(false);
        consultar.setSelectedIndex(0); // seleccionar item de manera predeterminada
        consultar.setBounds(40, 60, 300, 40);
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
        table.setPreferredScrollableViewportSize(new Dimension(600, 300));
        // se añade al panel y además se le agrega el método JScroll para que se visualice de forma correcta
        panel.add(new JScrollPane(table));
    }

    public void setTable() {
        model.setRowCount(0);
        model.setColumnCount(0);
    }

    // Se crea un método que va a recibir una consulta y agrega los datos al modelo de la tabla
    public void agragarDataModel(String sentencia) {
        for (String columna : Metodoconsultas.getColmnas(sentencia)) { // recorro los datos obtenidos en la consulta
            model.addColumn(columna); // agregos los datos al model
        }
        for (Object[] fila : Metodoconsultas.ejecutarConsulta(sentencia)) {
            model.addRow(fila);
        }
    }

    // métodos para consultas sin retorno de datos (solo consultas de insert o update)
    public void ejecutarInsertUpdate(String sentencia){
        Metodoconsultas.ejercutarModifiData(sentencia);
    }

    public void ObtenerSeleccion() {
        String valorPrederminado = (String) consultar.getSelectedItem();
        int item = consultar.getSelectedIndex();

        if (Objects.equals(valorPrederminado, "Seleccionar")){
            consultar.setSelectedIndex(-1); // Deseleccionar el ítem "Ignorar"
        }
            
        if (item == 1) {
            if(Objects.equals(encabezadoTable.getName(), "comunidades")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.proyectoDeComunidades(cod));
            }
        }else if(item == 2) {
            if(Objects.equals(encabezadoTable.getName(), "proyectos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.responsableProyecto0(cod));
            }
        }else if(item == 3){
            if(Objects.equals(encabezadoTable.getName(), "administrativos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.respoProyectosDirectivos(cod));
            }
        } else if (item == 4) {
            if(Objects.equals(encabezadoTable.getName(),"evaluacion")) {
                int eva = Integer.parseInt(JOptionPane.showInputDialog("Digite el porcentaje que desea evaluar (80)"));
                setTable(); // limpio los datos de la tabla
                agragarDataModel(consultas.evaluacionProyecto(eva));
            }

        } else if (item == 5) {
            if(Objects.equals(encabezadoTable.getName(), "proyectos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.ObjetivoEvaluacionProyecto(cod));
            }
        }else if (item == 6) {
            if (Objects.equals(encabezadoTable.getName(), "comunidades")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 0); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.niñoComunidad(cod));
            }
        }else if (item == 7) {
            if (Objects.equals(encabezadoTable.getName(), "proyectos")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                int cod = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.profecionalProyecto(cod));
            }
        }else if (item == 8) {
            if (Objects.equals(encabezadoTable.getName(), "profecionales")) {
                int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
                String especializacion = (String) model.getValueAt(indexRow, 0); // obtengo el valor de la celda deseada
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.profecionalEspecializacion(especializacion));
            }
        }else if (item == 9) {
            if (Objects.equals(encabezadoTable.getName(), "proyectos")) {
                String fechainicio = JOptionPane.showInputDialog("Digite la fecha inicial (2023-06-02)");
                String fechafinal = JOptionPane.showInputDialog("Digite la fecha Final (2023-10-31)");
                setTable(); // limpio los datos de la tabla
                // agrego los datos a la tabla llamando al método que va a realizar la consulta
                agragarDataModel(consultas.rangoFechaProyecto(fechainicio,fechafinal));
            }
        }
    }

    public void ActualizarTablas (){
        if(Objects.equals(encabezadoTable.getName(), "proyectos")) {
            int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
            String descripcion = (String) model.getValueAt(indexRow, 1); // obtengo el valor de la celda deseada
            String alcance = (String) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada
            int presupuesto = Integer.parseInt((String)  model.getValueAt(indexRow, 3)); // obtengo el valor de la celda deseada
            int cod_pro = (int) model.getValueAt(indexRow, 5); // obtengo el valor de la celda deseada

            ejecutarInsertUpdate(consultas.ActualizarTablaPro(descripcion,alcance,presupuesto,cod_pro));
        }
        if(Objects.equals(encabezadoTable.getName(), "empleados")){
            int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada

            int salario = Integer.parseInt((String) model.getValueAt(indexRow, 1)); // obtengo el valor de la celda deseada
            int cod_emp = (int) model.getValueAt(indexRow, 2); // obtengo el valor de la celda deseada

            ejecutarInsertUpdate(consultas.ActualizarTablaEmp(salario,cod_emp));
        }
    }

    public void insertardatosPosgrest() {
        int lastFila = table.getSelectedRow();
        String tableName = encabezadoTable.getName(); // obtengo el nombre de la tabla
        String[] rowData = new String[table.getColumnCount()]; // almaceno lso datos
        // recorro cada celda
        for (int i = 0; i < table.getColumnCount(); i++) {
            // obtengo lso valores
            rowData[i] = String.valueOf(table.getValueAt(lastFila, i));
        }
        ejecutarInsertUpdate(consultas.insertenTabla(tableName, rowData));
        System.out.println(consultas.insertenTabla(tableName, rowData));
    }


    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();

            Actualizar.setVisible(false);
            if (jm == I_proyectos) {
                setTable();
                Actualizar.setVisible(true); // Habilitar vista del Botón
                agragarDataModel(consultas.C_proyectos);
                encabezadoTable.setName("proyectos");
            }
            if (jm == I_comunidades) {
                setTable();
                agragarDataModel(consultas.C_comunidades);
                encabezadoTable.setName("comunidades");
            }
            if (jm == I_Empleados) {
                setTable();
                Actualizar.setVisible(true);
                agragarDataModel(consultas.C_empleados);
                encabezadoTable.setName("empleados");
            }
            if (jm == I_administrativos) {
                setTable();
                agragarDataModel(consultas.C_administrativos);
                encabezadoTable.setName("administrativos");
            }
            if (jm == I_profecionales) {
                setTable();
                agragarDataModel(consultas.C_profecionales);
                encabezadoTable.setName("profecionales");
            }
            if (jm == I_Representate) {
                setTable();
                agragarDataModel(consultas.C_representante);
                encabezadoTable.setName("representante");
            }
            if (jm == I_D_contacto_Representante) {
                setTable();
                agragarDataModel(consultas.C_Drepresentante);
                encabezadoTable.setName("dcontacto_representante");
            }
            if (jm == I_objetivos) {
                setTable();
                agragarDataModel(consultas.C_objetivos);
                encabezadoTable.setName("objetivo");
            }
            if (jm == I_Tema) {
                setTable();
                agragarDataModel(consultas.C_tema);
                encabezadoTable.setName("tema");
            }
            if (jm == I_Evaluacion) {
                setTable();
                agragarDataModel(consultas.C_evaluacion);
                encabezadoTable.setName("evaluacion");
            }
            if (jm == I_niños) {
                setTable();
                agragarDataModel(consultas.C_niños);
                encabezadoTable.setName("niños");
            }
            if (jm == I_participacion) {
                setTable();
                agragarDataModel(consultas.C_participacion);
                encabezadoTable.setName("participacion");
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
