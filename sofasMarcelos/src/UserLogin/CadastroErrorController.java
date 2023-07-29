import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroErrorController {

    @FXML
    private Button botao_voltar;

    @FXML
    private TextField campo_cpf;

    @FXML
    private TextField campo_email;

    @FXML
    private TextField campo_login;

    @FXML
    private TextField campo_rg;

    @FXML
    private PasswordField campo_senha;

    @FXML
    private TextField campo_telefone;

    @FXML
    private TextField campo_usuario;

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela cadastro");
    }

}
