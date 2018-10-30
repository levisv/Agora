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
import popups.TelaPopUpCadastro;
import popups.TelaPopUpSemPreenchimento;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerErroRetornoVazioCadastro implements Initializable {

    @FXML
    private Button btnVoltarTelaCadastro;

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
            VoltarTelaCadastro(event);
        }
    }

    //chamar tela de cadastro
    @FXML
    private void VoltarTelaCadastro(ActionEvent event) throws IOException {
        try {
            TelaPopUpSemPreenchimento.myStage.close();
        } catch (Exception e) {
            
        }
    }
    
}
