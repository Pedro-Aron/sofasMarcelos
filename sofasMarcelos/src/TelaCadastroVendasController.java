import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class TelaCadastroVendasController {

    @FXML
    private Button botao_comissao;

    @FXML
    private Button cadastro_venda;

    @FXML
    private TextField campo_cpf_cliente;

    @FXML
    private TextField campo_id_produto;

    @FXML
    private TextField campo_quantidade;

    @FXML
    private TextField campo_nome_cliente;

    @FXML private Label label_comissoes;

    @FXML
    void cadastrando(ActionEvent event) {
        ManejoDB.cadastroVenda(campo_id_produto.getText(), campo_nome_cliente.getText(), campo_cpf_cliente.getText(), Integer.parseInt(campo_quantidade.getText()));
    }

    @FXML
    void calcular_comissao(ActionEvent event) {
        label_comissoes.setText("R$ "+Float.toString(ManejoDB.calculaComissoes()));
    }

    @FXML
    void voltarTelaVendedorVendas(ActionEvent event) {
        App.change_scene("tela espaco vendedor");
    }

}
