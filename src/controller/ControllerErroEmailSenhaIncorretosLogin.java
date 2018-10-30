/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import popups.TelaPopUpCapitulos;
import popups.TelaPopUpErroSenhaIncoLogin;
import popups.TelaPopUpPerfil;
import popups.TelaPopUpRecSenha;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerErroEmailSenhaIncorretosLogin implements Initializable {

    @FXML
    private Button btnVoltarTelaLogin;
    @FXML
    private Button btnRecuperarSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            VoltarTelaLogin(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed2(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            telaRecuperarSenha(event);
        }
    }

    // chamar tela de login
    @FXML
    private void VoltarTelaLogin(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/telas/Login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ControllerRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        main.Main.myStage.setScene(scene);
        ControllerRecuperarSenha.stage.close();
    }

    //chamar tela de recuperar senha
    @FXML
    private void telaRecuperarSenha(ActionEvent event) {
        try {
            new TelaPopUpRecSenha().start(new Stage());
            TelaPopUpErroSenhaIncoLogin.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
}
