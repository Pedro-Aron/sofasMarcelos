import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class TelaProdutosController {

    @FXML
    private Button cadastro_produto;

    @FXML
    private TextField estoque_inicial;

    @FXML
    private TextField valor_produto;

    @FXML
    private Button reestocar;

    @FXML
    private TextField reestoque;

    @FXML
    private TextField campo_id;

    @FXML
    private TextField campo_nome;

    @FXML
    private TextArea campo_descricao;

    @FXML
    void reestocando(ActionEvent e) {
        if (ManejoDB.reestoque(campo_id.getText(), Integer.parseInt(reestoque.getText())) == false)
            System.out.println("Verifique os itens reestocados");
    }

    @FXML
    void cadastrando(ActionEvent e) {
        if (ManejoDB.cadastroProduto(campo_nome.getText(), campo_descricao.getText(), Integer.parseInt(estoque_inicial.getText()), Float.parseFloat(valor_produto.getText())) == false)
            System.out.println("Verifique a tentativa de cadastro novamente");
    }

    @FXML
    void voltarTelaLoginAPartirTelaCadastroProduto(ActionEvent event) {
        App.change_scene("tela espaco vendedor");
    }

}
