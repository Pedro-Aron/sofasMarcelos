import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class cadastroController {

    @FXML
    private Button botao_cancelar;

    @FXML
    private Button botao_confirmar;

    @FXML
    private TextField campo_cpf;

    @FXML
    private TextField campo_email;

    @FXML
    private TextField campo_login;

    @FXML
    private TextField campo_nome;

    @FXML
    private TextField campo_rg;

    @FXML
    private TextField campo_senha;

    @FXML
    private TextField campo_telefone;

    @FXML
    private AnchorPane confirmar;

    @FXML
    void cancelar(ActionEvent event) {
        System.out.println("chegou aqui"); 
        App.change_scene(2);
    }

    @FXML
    void confirmar(ActionEvent event) throws SQLException {
        System.out.println("chegou aqui");
        ManejoDB.cadastrar_vendedor(campo_nome.getText(), campo_cpf.getText(), campo_rg.getText(), campo_senha.getText(), campo_telefone.getText(), campo_login.getText(), campo_email.getText());
    }

}
