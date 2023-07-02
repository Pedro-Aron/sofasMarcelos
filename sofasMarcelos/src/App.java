import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final FXMLLoader telaLoginXml = new FXMLLoader(getClass().getResource("telaLogin.fxml"));
        Scene telaLoginCena = new Scene(telaLoginXml.load());

        primaryStage.setTitle("Log-in e cadastro");
        primaryStage.setScene(telaLoginCena);
        primaryStage.show();

        Button botaoLogin = (Button) telaLoginCena.lookup("#botaoCadastroTela1");
        TextField campoEmail = (TextField) telaLoginCena.lookup("#campoEmailTela1");
        PasswordField campoSenha = (PasswordField) telaLoginCena.lookup("#campoSenhaTela1");

        botaoLogin.setOnAction((e) -> {
            System.out.println(campoEmail.getText());
            System.out.println(campoSenha.getText());
        });
    }
}
