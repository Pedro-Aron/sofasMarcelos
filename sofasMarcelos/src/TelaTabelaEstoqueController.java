import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaTabelaEstoqueController implements Initializable {
    @FXML private TableView<Produto> tabela_produtos;

    @FXML private TableColumn<Produto, String> coluna_nome_produto;

    @FXML private TableColumn<Produto, String> coluna_descricao_produto;

    @FXML private TableColumn<Produto, String> coluna_id_produto;

    @FXML private TableColumn<Produto, String> coluna_cpf_vendedor;

    @FXML private TableColumn<Produto, Float> coluna_preco;

    @FXML private TableColumn<Produto, Integer> coluna_estoque;

    @FXML private Button voltarEstoque;

    @FXML void voltarTelaVendedorEstoque(ActionEvent event) {
        App.change_scene("tela espaco vendedor");
    }

    @FXML public void initialize(URL location, ResourceBundle resources) {
        coluna_nome_produto.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
        coluna_descricao_produto.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
        coluna_id_produto.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));
        coluna_cpf_vendedor.setCellValueFactory(new PropertyValueFactory<Produto, String>("cpfVendedor"));
        coluna_preco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
        coluna_estoque.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));

        ObservableList<Produto> listaProdutos = tabela_produtos.getItems();
        listaProdutos.clear();

        try {
            ResultSet listaCrua = ManejoDB.resgataProdutos();
            while (listaCrua.next()) 
                listaProdutos.add(new Produto(listaCrua.getString(1), listaCrua.getString(3), listaCrua.getString(2), listaCrua.getString(6), listaCrua.getInt(5), listaCrua.getFloat(4)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
        
        tabela_produtos.setItems(listaProdutos);
    }
}
