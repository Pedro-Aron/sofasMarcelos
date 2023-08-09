import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaCadastroVendaController {

    @FXML
    private Button cadastro_venda;

    @FXML
    private Button calculo_comissao;

    @FXML
    private TextField campo_cpf_cliente;

    @FXML
    private TextField campo_id_produto;

    @FXML
    private TextField campo_quantidade;

    @FXML
    private TextField campo_valor_produto;

    @FXML
    void cadastrando(ActionEvent event) {

    }

    @FXML
    void reestocando(ActionEvent event) {

    }

    @FXML
    void voltarTelaVendedorVendas(ActionEvent event) {
        App.change_scene("tela espaco vendedor");
    }

}
