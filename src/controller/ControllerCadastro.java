package controller;

import popups.TelaPopUpInfoCadaSuc;
import popups.TelaPopUpSemPreenchimento;
import dao.DAOUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import popups.TelaPopUpCadastro;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerCadastro implements Initializable {

    
    public static Stage myStage;
    @FXML
    private Button btnContaGoogle;
    @FXML
    private TextField txtNomeCadastro;
    @FXML
    private TextField txtEmailCadastro;
    @FXML
    private TextField txtCpfCadastro;
    @FXML
    private TextField txtLoginCadastro;
    @FXML
    private PasswordField pswSenhaCadastro;
    @FXML
    private Button btnCadastrar;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TelaPopUpCadastro.myStage.close();
        
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            voltarLogin(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed1(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            cadastrarUsuario(event);
        }
    }
    
    //cadastrar usuario
    @FXML
    private void verificacaoInputs() throws ClassNotFoundException, IllegalAccessException, SQLException, InstantiationException, IOException, NoSuchAlgorithmException{
        Usuario usuarios = new Usuario(null, null, null, null, null);
        usuarios.setNome(txtNomeCadastro.getText());
        usuarios.setEmail(txtEmailCadastro.getText());
        usuarios.setCpf(txtCpfCadastro.getText());
        usuarios.setLogin(txtLoginCadastro.getText());
        usuarios.setSenha(pswSenhaCadastro.getText());
        
        // fazendo a validação dos dados
        if ((txtNomeCadastro.getText().isEmpty()) || (txtEmailCadastro.getText().isEmpty()) || (txtCpfCadastro.getText().isEmpty()) || (txtLoginCadastro.getText().isEmpty()) || (pswSenhaCadastro.getText().isEmpty())) {
            new TelaPopUpSemPreenchimento().start(new Stage());
        }
        else {
            // instanciando a classe DAOUsuario do pacote dao e criando seu objeto dao
            DAOUsuario dao = new DAOUsuario();
            dao.inserirPessoa(usuarios);
            new TelaPopUpInfoCadaSuc().start(new Stage());
        }
    }
    
    //cadastro usuario
    @FXML
    private void cadastrarUsuario(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        try {
            verificacaoInputs();
        } catch (ClassNotFoundException | IllegalAccessException | SQLException | InstantiationException ex) {
            Logger.getLogger(ControllerCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //voltar login
    @FXML
    private void voltarLogin(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        new Main().start(new Stage());
        TelaPopUpCadastro.myStage.close();
        
    }
    
    
}
