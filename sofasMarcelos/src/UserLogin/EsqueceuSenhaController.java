import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EsqueceuSenhaController {

    @FXML
    private Button botao_enviar;

    @FXML
    private Button botao_voltar;

    @FXML
    private TextField campo_email_recuperar;

    @FXML
    void enviar(ActionEvent event) throws SQLException {
        boolean flag = ManejoDB.confere_email(campo_email_recuperar.getText());

        if(!flag){
            App.change_scene("tela esqueceu senha error");
            return; 
        }
            // mudar para a tela que diz que enviou 
            // e enviar o código para este email 
    }

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela login");
    }

}