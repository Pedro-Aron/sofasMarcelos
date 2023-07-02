import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

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
        
    }

    @FXML
    void logar(ActionEvent event) {
        String usuario = campo_usuario.getText();
        String senha = campo_senha.getText();

        System.out.println(usuario);
        System.out.println(senha);
    }

}
