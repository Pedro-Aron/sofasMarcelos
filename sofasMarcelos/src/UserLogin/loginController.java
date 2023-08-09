import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button botao_Cadastro;
    
    @FXML
    private Button botao_Login;

    @FXML
    private PasswordField campo_senha;

    @FXML
    private TextField campo_usuario;


    @FXML
    void cadastrar(ActionEvent event) {
        App.change_scene("tela cadastro");
    }

    @FXML
    void logar(ActionEvent event) {
        // É neste método que setará para a tela do vendedor ou do cliente
        String usuario = campo_usuario.getText();
        String senha = campo_senha.getText();
        // se for vendedor, haverá outra tela com a opção de cadastrar outro vendedor

        String resultadoLogin;
        if ((resultadoLogin = ManejoDB.verificaLogin(usuario, senha)) == null) {
            App.change_scene("tela login error");
            System.out.println("login nao encontrado");
            return; 
        }
        App.change_scene("tela loja interface");
    }
}
