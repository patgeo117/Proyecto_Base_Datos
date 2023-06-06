
import java.sql.DriverManager;

public class Principal {
    public static void consultas(){

    }
    public static void main(String[] args) {
        new Interfaz1();
        String user = "George117";
        String password = "Pinina117";
        try{
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/FundacionProNiñez", user, password);
            System.out.println("conectado con exito");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        consultas();

    }
}
