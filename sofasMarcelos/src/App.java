import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        if (!ManejoDB.conectar()) 
            return;

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final FXMLLoader telaLoginXml = new FXMLLoader(getClass().getResource("telaLogin.fxml"));
        Scene telaLoginTela = new Scene(telaLoginXml.load());

        primaryStage.setTitle("Log-in e cadastro");
        primaryStage.setScene(telaLoginTela);
        primaryStage.show();
    }
}
