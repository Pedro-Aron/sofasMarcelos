import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejoDB {
    private static Connection conexao;

    public static boolean conectar() {
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sofasmarcelos?" + "user=root&password=Aerodoido365");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + e.getErrorCode());
            return false;
        }
    }

    public static String verificaLogin(String login, String senha) {
        try {
            String tentativaVendedor = "SELECT login, senha from vendedor where login = '" +login+ "' and senha = '" +senha+ "'";
            PreparedStatement comandoVendedor = conexao.prepareStatement(tentativaVendedor);
            ResultSet retornoVendedor = ((java.sql.Statement) comandoVendedor).executeQuery(tentativaVendedor);

            if (retornoVendedor.next()) 
                return retornoVendedor.getString(1) + " vendedor";

            String tentativaCliente = "SELECT login, senha from cliente where login = '" +login+ "' and senha = '" +senha+ "'";
            PreparedStatement comandoCliente = conexao.prepareStatement(tentativaCliente);
            ResultSet retornoCliente = ((java.sql.Statement) comandoCliente).executeQuery(tentativaCliente);

            if (retornoCliente.next()) 
                return retornoCliente.getString(1) + " cliente";

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + e.getErrorCode());
            return null;
        }
    }
}