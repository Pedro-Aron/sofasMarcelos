

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EspacoVendedorController {

    @FXML
    private ImageView icone_cliente;

    @FXML
    private ImageView icone_estoque;

    @FXML
    private ImageView icone_produto;

    @FXML
    private ImageView icone_vendedor;

    @FXML
    void cadastrar_produto(MouseEvent event) {
        App.change_scene("tela cadastro produtos");
    }

    @FXML
    void cadastrar_vendedor(MouseEvent event) {
        App.change_scene("tela cadastro");
    }

    @FXML
    void consultar_cliente(MouseEvent event) {
        App.change_scene("tela cadastro vendas");
    }

    @FXML
    void consultar_estoque(MouseEvent event) {
        App.change_scene("tela tabela estoque");
    }
        @FXML
    void volta_tela_login(ActionEvent event) {
        App.change_scene("tela login");
    }

}
