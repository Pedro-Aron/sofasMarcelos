import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginErrorController {

    @FXML
    private Button botao_Cadastro;

    @FXML
    private Button botao_voltar;

    @FXML
    private PasswordField campo_senha;

    @FXML
    private TextField campo_usuario;

    @FXML
    private Hyperlink link_esqueceu_senha;

    @FXML
    void cadastrar(ActionEvent event) {
        App.change_scene("tela cadastro");
    }

    @FXML
    void esqueceu_senha(ActionEvent event) {
        App.change_scene("tela esqueceu senha");
    }

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela login");
    }

}
