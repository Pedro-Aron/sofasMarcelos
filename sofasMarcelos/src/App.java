import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Scene telaLoginTela; 
    private static Scene telaLoginErrorTela; 
    private static Scene telaCadastroTela; 
    private static Scene telaCadastroErrorTela; 
    private static Scene telaCadastroCorretoTela; 
    private static Scene telaEsqueceuSenhaTela; 
    private static Scene telaEsqueceuSenhaErrorTela; 
    private static Scene telaEspacoVendedorTela; 

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
        
        final FXMLLoader telaLoginErrorXML = new FXMLLoader(getClass().getResource("telaLoginError.fxml"));
        telaLoginErrorTela = new Scene(telaLoginErrorXML.load()); 
        
        final FXMLLoader telaCadastroXML = new FXMLLoader(getClass().getResource("telaCadastro.fxml")); 
        telaCadastroTela = new Scene(telaCadastroXML.load());  
        
        final FXMLLoader telaCadastroErrorXML = new FXMLLoader(getClass().getResource("telaCadastroError.fxml"));
        telaCadastroErrorTela = new Scene(telaCadastroErrorXML.load());

        final FXMLLoader telaCadastroCorretoXML = new FXMLLoader(getClass().getResource("telaCadastroCorreto.fxml")); 
        telaCadastroCorretoTela = new Scene(telaCadastroCorretoXML.load()); 

        final FXMLLoader telaEsqueceuSenhaXML = new FXMLLoader(getClass().getResource("telaEsqueceuSenha.fxml"));
        telaEsqueceuSenhaTela = new Scene(telaEsqueceuSenhaXML.load()); 
        
        final FXMLLoader telaEsqueceuSenhaErrorXML = new FXMLLoader(getClass().getResource("telaEsqueceuSenhaError.fxml"));
        telaEsqueceuSenhaErrorTela = new Scene(telaEsqueceuSenhaErrorXML.load()); 

        final FXMLLoader telaEspacoVendedorXML = new FXMLLoader(getClass().getResource("ESPACO_VENDEDOR/tela_espaco_vendedor.fxml"));
        telaEspacoVendedorTela = new Scene(telaEspacoVendedorXML.load());

        stage.setScene(telaLoginTela);
        stage.show();
    }

    public static void change_scene(String codigo_tela){
        switch (codigo_tela){
            case "tela login": 
                stage.setScene(telaLoginTela);
                break; 
            case "tela login error": 
                stage.setScene(telaLoginErrorTela); 
                break;
            case "tela cadastro": 
                stage.setScene(telaCadastroTela);
                break; 
            case "tela cadastro error": 
                stage.setScene(telaCadastroErrorTela);
                break; 
            case "tela cadastro correto":
                stage.setScene(telaCadastroCorretoTela);
                break; 
            case "tela esqueceu senha":     
                stage.setScene(telaEsqueceuSenhaTela);
                break; 
            case "tela esqueceu senha error": 
                stage.setScene(telaEsqueceuSenhaErrorTela);
                break;
            case "tela espaco vendedor": 
                stage.setScene(telaEspacoVendedorTela);
                stage.setMaximized(true);
                break;
        }
    }
}
