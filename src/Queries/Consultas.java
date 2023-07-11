package Queries;

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
}
