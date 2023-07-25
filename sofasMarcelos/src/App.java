import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {
    private static Scene telaLoginTela; 
    private static Scene telaCadastroTela; 
    private static Stage stage; 
    public static void main(String[] args) throws Exception {
        if (!ManejoDB.conectar()) {
            System.out.println("NAO CONECTOU");
            return;
        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage; 
        final FXMLLoader telaLoginXml = new FXMLLoader(getClass().getResource("telaLogin.fxml"));
        telaLoginTela = new Scene(telaLoginXml.load());

        final FXMLLoader telaCadastroXML = new FXMLLoader(getClass().getResource("telaCadastro.fxml")); 
        telaCadastroTela = new Scene(telaCadastroXML.load()); 
        
        stage.setScene(telaLoginTela);
        stage.show();
    }

    public static void change_scene(int codigo_tela){
        switch (codigo_tela){
            case 1: 
                stage.setScene(telaCadastroTela);
                break;
            case 2: 
                stage.setScene(telaLoginTela); 
        }
    }
}
