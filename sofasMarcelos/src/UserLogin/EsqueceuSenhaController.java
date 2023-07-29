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
    void enviar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela login");
    }

}