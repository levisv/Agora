/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import popups.TelaPopUpRecSenha;
import popups.TelaPopUp;
import popups.TelaPopUpCadastro;
import static controller.ControllerRecuperarSenha.stage;
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
import javafx.stage.Stage;
import main.Main;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerLogin implements Initializable {

    public static Usuario usuario;

    @FXML
    private Button btnContaGoogle;
    @FXML
    private Button btnTelaCadastro;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pswSenha;
    @FXML
    private Button btnEsqueciSenha;
    @FXML
    private Button btnEntrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (TelaPopUpRecSenha.myStage != null) {
            TelaPopUpRecSenha.myStage.close();
        }
        
    }

    //ativar pressionar do enter
    @FXML
    public void buttonPressed3(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            recuperarSenha(event);
        }
    }

    //ativar pressionar do enter
    @FXML
    public void buttonPressed2(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarTelaCadastro(event);
            
        }
    }

    //ativar pressionar do enter
    @FXML
    public void buttonPressed(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarTelaHome(event);
        }
    }

    //acessar tela de cadastro
    @FXML
    private void acessarTelaCadastro(ActionEvent event) {
        new TelaPopUpCadastro().start(new Stage());       
        Main.myStage.close();
    }
    
    //acessar tela de recuperar senha
    @FXML
    private void recuperarSenha(Event event) {        
        new TelaPopUpRecSenha().start(new Stage());
        Main.myStage.close();
    }

    //acessar tela inicial
    @FXML
    private void acessarTelaHome(ActionEvent event) 
    {
        System.out.println(btnEntrar.getId());
        DAOUsuario dao = null;
        try {
            dao = new DAOUsuario();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        String email = txtEmail.getText();
        String senha = pswSenha.getText();

        if ((txtEmail.getText().isEmpty()) || (pswSenha.getText().isEmpty())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/telas/ErroRetornoVazioLogin.fxml"));

                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ControllerRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            usuario = dao.verificacaoUsuarioLogin(email, senha);
            if (usuario != null) {
                try {
                    //abrir tela player
                    new TelaPopUp().start(new Stage());
                } catch (Exception e) {
                    System.out.println("deu ruim");
                }
            } else {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/telas/ErroEmailSenhaIncorretosLogin.fxml"));

                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(ControllerRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
