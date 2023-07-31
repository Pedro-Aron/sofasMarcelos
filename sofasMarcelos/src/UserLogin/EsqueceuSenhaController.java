import java.sql.SQLException;
import java.util.Random;

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

        Random random = new Random(); 
        int codigo_verificacao_int = random.nextInt(10000);
        String codigo_verificacao_str = String.format("%04d", codigo_verificacao_int);

        final String EMAIL_MARCELO = "sofasmarcelos@gmail.com"; 
        final String SENHA_MARCELO = "feitocomexcelencia"; 



    }

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela login");
    }

}