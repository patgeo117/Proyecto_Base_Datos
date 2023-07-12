package Queries;

import java.sql.PreparedStatement;

public class Consultas {
    public String C_proyectos = "SELECT * FROM proyectos";
    public String C_comunidades = "SELECT * FROM comunidades";
    public String C_empleados = "SELECT * FROM empleados";
    public String C_administrativos = "SELECT * FROM administrativos";
    public String C_profecionales = "SELECT * FROM profecionales";
    public String C_representante = "SELECT * FROM representante";
    public String C_Drepresentante = "SELECT * FROM dcontacto_representante";
    public String C_objetivos = "SELECT * FROM objetivo";
    public String C_tema = "SELECT * FROM tema";
    public String C_evaluacion = "SELECT * FROM evaluacion";
    public String C_niños = "SELECT * FROM niños";
    public String C_participacion = "SELECT * FROM participacion";

    //Método para obtener la llave foranea de comunidades
    public String proyectoDeComunidades(int getProyectoDeComunidad) {
        String proyectoDeComunidad = "Select p.* FROM proyectos  p\n" +
                "INNER JOIN comunidades c \n" +
                "on p.pro_cod = c.fk_pro_cod\n" +
                "AND c.fk_pro_cod = " + getProyectoDeComunidad;
        return proyectoDeComunidad;
    }
    //  Mostrar el responsable de un determinado proyecto
    public String responsableProyecto0(int getResponsableProyecto) {
        String consultaResponsable = "SELECT e.emp_id, e.emp_nombre, a.adm_area FROM administrativos a \n" +
                "INNER JOIN empleados e on\n" +
                "a.fk_emp_id =  e.emp_id\n" +
                "INNER JOIN proyectos p on\n" +
                "a.fk_pro_cod = p.pro_cod\n" +
                "AND p.pro_cod = " + getResponsableProyecto;
        return consultaResponsable;
    }
    // Listar los proyectos que han sido responsabilidad de un cierto directivo
    public String respoProyectosDirectivos(int getproyectosDeDirectivo){
        String proyectosDeDirectivos = "SELECT p.* FROM proyectos p \n" +
                "INNER JOIN administrativos a on\n" +
                "p.pro_cod = a.fk_pro_cod\n" +
                "and a.fk_pro_cod = " + getproyectosDeDirectivo;
        return proyectosDeDirectivos;
    }
    //  Listar los proyectos que hayan obtenido una evaluación inferior a cierto valor ingresado por el usuario
    public String evaluacionProyecto(int getevaluacion){
        String evaluacion = "SELECT P.* \n" +
                "FROM proyectos P INNER JOIN objetivo O ON ( P.pro_cod = O.fk_pro_cod ) \n" +
                "INNER JOIN evaluacion E ON (E.eva_cod = O.fk_eva_cod and E.eva_porcentaje < " + getevaluacion + ")";
        return evaluacion;
    }

    public String ObjetivoEvaluacionProyecto(int getcodProyecto){
        String objetivoEvaluacion = "SELECT O.* , E.eva_porcentaje \n" +
                "FROM objetivo O INNER JOIN evaluacion E ON (E.eva_cod = O.fk_eva_cod ) \n" +
                "INNER JOIN proyectos P ON ( P.pro_cod = O.fk_pro_cod AND P.pro_cod = " + getcodProyecto + ")";
        return objetivoEvaluacion;
    }

    public String niñoComunidad(int getcodComunidad){
        String niños = "SELECT N.* \n" +
                "FROM niños N INNER JOIN comunidades C \n" +
                "ON (N.fk_com_cod = C.com_cod AND C.com_cod = " + getcodComunidad + ")";
        return niños;
    }

    public String profecionalProyecto(int getcodProyecto){
        String profecional = "SELECT PR.* \n" +
                "FROM profecionales PR INNER JOIN participacion P ON ( PR.prof_id = P.fk_prof_id)  \n" +
                "INNER JOIN proyectos pro ON (pro.pro_cod = P.fk_pro_cod AND pro.pro_cod = " + getcodProyecto + ")";
        return profecional;
    }

    public String profecionalEspecializacion(String getEspecializacion){
        String profecionales = "SELECT PR.* \n" +
                "FROM profecionales PR   \n" +
                "WHERE PR.prof_especializacion = '" + getEspecializacion + "'";
        return profecionales;
    }

    public String ActualizarTablaPro(String descripcion, String alcance, int presupuesto, int codpro){
        String actualizar = "UPDATE proyectos \n"+
                "SET pro_descripcion = '"+descripcion+"', pro_alcance = '"+alcance+"', pro_presupuesto = " + presupuesto + "\n" +
                "WHERE pro_cod = "+ codpro;
        return actualizar;
    }

    public String ActualizarTablaEmp(int salario, int codEmp){
        String actualizar = "UPDATE empleados \n"+
                "SET emp_salario = "+ salario + "\n" +
                "WHERE emp_id = "+ codEmp;
        return actualizar;
    }
    public String rangoFechaProyecto(String fechainicial, String fechafinal){
        String fechaProyecto = "SELECT P.* \n"+
                "FROM proyectos P INNER JOIN objetivo O \n" +
                "ON (P.pro_cod = O.fk_pro_cod AND ( obj_fechainicio BETWEEN '" + fechainicial + "'\n" +
                "AND  '" + fechafinal + "'))";
        return fechaProyecto;
    }
    public String insertenTabla(String nametabla, String[] rowData) {
        StringBuilder consultaInsert = new StringBuilder(); // cadena string mutable
        consultaInsert.append("INSERT INTO ").append(nametabla).append(" VALUES (");

        // recorro los valores de la lista rowdata
        for (int i = 0; i < rowData.length; i++) {
            // agrego los datos a consultinsert dentro de commilas simples VALUES ('','','',...)
            consultaInsert.append("'").append(rowData[i]).append("'");
            // condicional para agregar comas entra cada valor menss el ultimo valor
            if (i < rowData.length - 1) {
                consultaInsert.append(", ");
            }
        }
        consultaInsert.append(")"); // cierra de values
        return consultaInsert.toString();
    }




}
