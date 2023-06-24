import java.sql.DriverManager;
public class Principal extends Credenciales {
    public static void main(String[] args) {
        Interfaz1 interfaz1 = new Interfaz1();


        // se establece la conexion con la base de datos con el driver JDBC
        try {
            DriverManager.getConnection(url, user, password);
            System.out.println("Base de datos Conectada...");
        } catch (Exception e) {
            e.printStackTrace(); // Sí hay alguna excepcion se muesta en consola
        }
    }
}
