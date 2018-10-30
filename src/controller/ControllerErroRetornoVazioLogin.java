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

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerErroRetornoVazioLogin implements Initializable {

    @FXML
    private Button btnVoltarTela;

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
            VoltarTela(event);
        }
    }

    //acessar tela de login
    @FXML
    private void VoltarTela(ActionEvent event) throws IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/telas/Login.fxml"));
    
        } catch (IOException ex) {
            Logger.getLogger(ControllerRecuperarSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        main.Main.myStage.setScene(scene);
        ControllerRecuperarSenha.stage.close(); // codigo foda q o eduany fez pra fechar o popup
    }
    
}
