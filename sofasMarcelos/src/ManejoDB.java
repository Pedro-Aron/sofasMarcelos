import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejoDB {
    private static Connection conexao;
    static final String url = "jdbc:mysql://localhost:3306/sofasmarcelos"; 
    static final String user = "root"; 
    static final String password = "Aerodoido365"; 

    public static boolean conectar( ) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("CONECTOU");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + e.getErrorCode());
            return false;
        }
    }

    public static boolean verificaLogin(String login, String senha) {
        try {
            String tentativaVendedor = "SELECT * from vendedor where login = '" +login+ "' and senha = '" +senha+ "'";
            PreparedStatement comandoVendedor = conexao.prepareStatement(tentativaVendedor);
            ResultSet retornoVendedor = ((java.sql.Statement) comandoVendedor).executeQuery(tentativaVendedor);

            if (retornoVendedor.next()) {
                UsuarioSessao.nome = retornoVendedor.getString(1);
                UsuarioSessao.cpf = retornoVendedor.getString(2);
                UsuarioSessao.rg = retornoVendedor.getString(3);
                UsuarioSessao.senha = retornoVendedor.getString(4);
                UsuarioSessao.numero = retornoVendedor.getString(5);
                UsuarioSessao.usuario = retornoVendedor.getString(6);
                UsuarioSessao.email = retornoVendedor.getString(7);
                UsuarioSessao.comissoes = retornoVendedor.getFloat(8);
                return true;
            }
                

            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + e.getErrorCode());
            return false;
        }
    }

    public static void cadastrar_vendedor(String nome, String cpf, String rg, String senha, String telefone, String login, String email) throws SQLException{

        // Confere se há algum campo vazio 
        if ( nome.equals("") || cpf.equals("")|| rg.equals("")|| senha.equals("") || telefone.equals("")|| login.equals("") || email.equals("")){
            App.change_scene("tela cadastro error");
            return; 
        }   

        // Conferir se todos os dados enviados estão no padrão correto.

        // Confere se este cliente já não está cadastrado. 
        String sql = "SELECT nome FROM Vendedor WHERE nome = '"+nome+"'";
        PreparedStatement comando = conexao.prepareStatement(sql); 
        ResultSet retorno = ((java.sql.Statement) comando).executeQuery(sql);

        while(retorno.next()){
            if(retorno.getString("nome").equals(nome) || retorno.getString("cpf").equals(cpf)){
                App.change_scene("tela cadastro error");
                return; 
            }
        }

        // Cadastra o cliente no banco
        sql = "INSERT INTO vendedor (nome, cpf, rg, email, telefone, login, senha) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement comandoVendedor = conexao.prepareStatement(sql);
        comandoVendedor.setString(1, nome);
        comandoVendedor.setString(2, cpf);
        comandoVendedor.setString(3, rg);
        comandoVendedor.setString(4, email);
        comandoVendedor.setString(5, telefone);
        comandoVendedor.setString(6, login);
        comandoVendedor.setString(7, senha);
        comandoVendedor.execute();
        comandoVendedor.close();

        App.change_scene("tela cadastro correto");
    }

    public static boolean reestoque (String id, int quantidade) {
        try {
            String sql = "SELECT * from Produto WHERE id = '"+id+"'";
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet retorno = ((java.sql.Statement) comando).executeQuery(sql);

            if (retorno.next()) {
                System.out.println("ci2: "+retorno.getString(2));
                System.out.println(UsuarioSessao.cpf);
                if (!retorno.getString(2).equals(UsuarioSessao.cpf))
                    return false;

                System.out.println("ci2: "+retorno.getString("quantidade"));
                int va = Integer.parseInt(retorno.getString("quantidade"));
                va += quantidade;

                sql = "UPDATE Produto SET quantidade = "+va+" WHERE id = '"+id+"'";
                comando = conexao.prepareStatement(sql);
                ((java.sql.Statement) comando).executeUpdate(sql);

                return true;
            }

            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    // public static boolean cadastroProduto (String nome, String descricao) {

    // }
}