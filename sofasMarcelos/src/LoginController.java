
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//classe responsável pelo controle da tela de login
public class LoginController {

    //cada um dos atributos representa um "elemento" da página inicial de login
    @FXML
    private Button botaoCadastroTela1;

    @FXML
    private Button botaoLoginTela1;

    @FXML
    private TextField campoEmailTela1;

    @FXML
    private PasswordField campoSenhaTela1;

    //método executado após pressionar o botao de login
    @FXML
    void fazerLogin(ActionEvent event) {
        //pegando os valores armazenados nos campos de login
        String senha = campoSenhaTela1.getText();
        String email = campoEmailTela1.getText();

        System.out.println(email);
        System.out.println(senha);
    }

}
