import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroNovoController {

    @FXML
    private Button botao_confirmar;

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
    void confirmar_cadastro(ActionEvent event) throws SQLException {
        ManejoDB.cadastrar_cliente(campo_usuario.getText(), campo_cpf.getText(), campo_rg.getText(), campo_senha.getText(), campo_telefone.getText(), campo_login.getText(), campo_email.getText());
    }

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela login");
    }

} 



