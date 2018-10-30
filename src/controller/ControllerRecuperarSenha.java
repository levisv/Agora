/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import popups.TelaPopUpRecSenhaDif;
import popups.TelaPopUpRecSenhaCpfEmailDif;
import popups.TelaPopUpRecSenhaSuc;
import popups.TelaPopUpRecSenhaVazio;
import dao.DAOUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static main.Main.main;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerRecuperarSenha implements Initializable {

    public static Stage myStage;
    
    @FXML
    private Text txtRecuperarSenhaTitulo;
    @FXML
    private Button btnVoltarLogin;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCpf;
    @FXML
    private PasswordField pswSenhaNova;
    @FXML
    private Button btnCadastrar;
    @FXML
    private PasswordField pswConfSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        main.Main.myStage.close();
    }

    public static Stage stage = new Stage();

    //ativar pressionar do enter
    @FXML
    public void buttonPressed1(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            cadastrarNovaSenha(event);
        }
    }

    //ativar pressionar do enter
    @FXML
    public void buttonPressed(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            voltarLogin(event);
        }
    }

    //ativar pressionar do enter
    @FXML
    private void voltarLogin(ActionEvent event) {        
        try {
            new main.Main().start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(ControllerRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para recuperar senha
    @FXML
    private void cadastrarNovaSenha(ActionEvent event) {
        //DAOUsuario dao = new DAOUsuario();
        DAOUsuario dao = null;
        try {
            dao = new DAOUsuario();

            String email = txtEmail.getText();
            String cpf = txtCpf.getText();
            String senha = pswSenhaNova.getText();
            String confSenha = pswConfSenha.getText();
            boolean openedMsg = false;

            if ((txtEmail.getText().isEmpty()) || (txtCpf.getText().isEmpty()) || (pswSenhaNova.getText().isEmpty()) || (pswConfSenha.getText().isEmpty())) {

                new TelaPopUpRecSenhaVazio().start(new Stage());
                openedMsg = true;

            }
            Usuario usuario = dao.verificacaoUsuarioRecuperaSenha(email, cpf);
            if (usuario != null && senha.equals(confSenha) && !openedMsg) {
                dao.atualizaSenha(usuario, confSenha);

                new TelaPopUpRecSenhaSuc().start(new Stage());
                openedMsg = true;
            } else if (!senha.equals(confSenha) && !openedMsg) {

                new TelaPopUpRecSenhaDif().start(new Stage());
                openedMsg = true;

            } else if (usuario == null && !openedMsg) {
                new TelaPopUpRecSenhaCpfEmailDif().start(new Stage());
                openedMsg = true;
            }

        } catch (Exception e) {
            System.out.println("");
        }
    }
}
