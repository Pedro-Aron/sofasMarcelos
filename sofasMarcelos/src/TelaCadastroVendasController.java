import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private TextField campo_valor_produto;

    @FXML
    void cadastrando(ActionEvent event) {
        System.out.println("chegou aqui");
        ManejoDB.cadastroVenda(campo_id_produto.getText(), Float.parseFloat(campo_valor_produto.getText()), campo_cpf_cliente.getText(), Integer.parseInt(campo_quantidade.getText()));
    }

    @FXML
    void calcular_comissao(ActionEvent event) {

    }

    @FXML
    void voltarTelaVendedorVendas(ActionEvent event) {
        App.change_scene("tela espaco vendedor");
    }

}
