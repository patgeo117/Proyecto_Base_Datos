package Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Credentials.Credenciales.*;

public class MetodosConsultas {

    // Esctrura para la tabla
    public Object[][] ejecutarConsulta(String consulta) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Object[][] resultado = null;

        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(url, user, password);

            // Crear una sentencia para ejecutar la consulta
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Ejecutar la consulta y obtener el conjunto de resultados
            resultSet = statement.executeQuery(consulta);

            // Obtener el número de columnas en los resultados
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Almacenar los resultados en una lista de listas
            List<List<Object>> filas = new ArrayList<>();
            while (resultSet.next()) {
                List<Object> fila = new ArrayList<>();
                for (int j = 0; j < columnCount; j++) {
                    fila.add(resultSet.getObject(j + 1));
                }
                filas.add(fila);
            }

            // Crear una matriz bidimensional para almacenar los resultados
            int rowCount = filas.size();
            resultado = new Object[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++) {
                List<Object> fila = filas.get(i);
                for (int j = 0; j < columnCount; j++) {
                    resultado[i][j] = fila.get(j);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos abiertos
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultado;
    }

    // Columnas
    public String[] getColumnasProyecto() {
        return new String[]{"Título", "Descripción", "Alcance","Presupuesto","Codigo del tema", "Codigo Profecional"};
    }

    public String[] getColumnasRepresentante() {
        return new String[]{"Nombre", "Fecha Nacimiento", "Edad","ID"};
    }

    public String[] getColumnasEvaluacion() {
        return new String[]{"Porcentaje", "Fecha Evaluación", "Codigo"};
    }
}
