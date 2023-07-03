import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.Statement;

public class ConexaoDB {
    public static void conectar() {
        try {
            DriverManager.getConnection("jdbc:mysql://localhost/sofasmarcelos?" + "user=root&password=Aerodoido365");
            System.out.println("conectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + e.getErrorCode());
        }
    }
}