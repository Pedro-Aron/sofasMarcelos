import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EsqueceuSenhaErrorController {

    @FXML
    private Button botao_voltar;

    @FXML
    private TextField campo_email_recuperar;

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela esqueceu senha");
    }

}
