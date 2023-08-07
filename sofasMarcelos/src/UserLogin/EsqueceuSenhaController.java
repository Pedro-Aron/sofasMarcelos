import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EsqueceuSenhaController {

    @FXML
    private Button botao_enviar;

    @FXML
    private Button botao_voltar;

    @FXML
    private TextField campo_email_recuperar;

    @FXML
    void enviar(ActionEvent event) throws SQLException {
        boolean flag = ManejoDB.confere_email(campo_email_recuperar.getText());
        
        if(!flag){
            App.change_scene("tela esqueceu senha error");
            return; 
        }
            // mudar para a tela que diz que enviou 
            // e enviar o código para este email 

        Random random = new Random(); 
        int codigo_verificacao_int = random.nextInt(10000);
        String codigo_verificacao_str = String.format("%04d", codigo_verificacao_int);

        final String EMAIL_MARCELO = "sofasmarcelos@gmail.com"; 
        final String SENHA_MARCELO = "feitocomexcelencia"; 
        
        Properties properties=new Properties();
        System.out.println("Chegou aqui1");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.startls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust","*");
         System.out.println("Chegou aqui3");

        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EMAIL_MARCELO, SENHA_MARCELO);

            }
        });

        session.setDebug(false);

        try {
            Message message= new MimeMessage(session);
                            System.out.println("Aqui");

            Address[] addresses= InternetAddress.parse("rafasilvam220@gmail.com");
            message.setFrom(new InternetAddress( EMAIL_MARCELO));
          
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject("CODIGO DE VERIFICAÇAO");
            message.setText(codigo_verificacao_str);

            Transport.send(message);
            

        } catch (MessagingException e) {
             e.printStackTrace();
            // TODO: handle exception
        }
    
        


    }

    @FXML
    void voltar(ActionEvent event) {
        App.change_scene("tela login");
    }

}