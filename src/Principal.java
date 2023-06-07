import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
// Se importan las clases para trabajar con archivos, base de datos y consultas SQL
public class Principal extends Credenciales {
    public static void main(String[] args) {
        new Interfaz1();

        try (Connection conexion = DriverManager.getConnection(url, user, password); // se establece la conexion con la base de datos con el driver JDBC
             Statement declaracion = conexion.createStatement()) { // Se crea un objeto Statement para ejecutar consultas SQL

            String contenidoSQL = new String(Files.readAllBytes(Paths.get(archivoSQL))); // se lee el contenido del archivo SQL y se almacena utilizando File y Paths
            String[] consultas = contenidoSQL.split(";"); // se dividen las consultas utilizando como separador ";"

            for (String consulta : consultas) { // se recorre cada consulta
                declaracion.addBatch(consulta); // se agrega a la lista que estan por consultarse
            }
            declaracion.executeBatch(); // se ejecutan todas las consultas

            System.out.println("Consultas ejecutadas correctamente.");
            System.out.println("Base de datos Conectada...");
        } catch (Exception e) {
            e.printStackTrace(); // Sí hay alguna excepcion se muesta en consola
        }
    }
}
