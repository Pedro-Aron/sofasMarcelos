import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejoDB {
    private static Connection conexao;
    static final String url = "jdbc:mysql://localhost:3306/cadastro"; 
    static final String user = "root"; 
    static final String password = "1234"; 

    public static boolean conectar() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("CONECTOU");
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

    public static void cadastrar_vendedor(String nome, String cpf, String rg, String senha, String telefone, String login, String email) throws SQLException{
        String sql = "INSERT INTO vendedor values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement comandoVendedor = conexao.prepareStatement(sql);
        comandoVendedor.setString(1, nome);
        comandoVendedor.setString(2, cpf);
        comandoVendedor.setString(3, rg);
        comandoVendedor.setString(4, email);
        comandoVendedor.setString(5, telefone);
        comandoVendedor.setString(6, login);
        comandoVendedor.setString(7, senha);
        comandoVendedor.execute();
        System.out.println("Chegou aqui");
        comandoVendedor.close();
    }
}