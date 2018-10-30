/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerRecuperarSenha.stage;
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
import main.Main;
import popups.TelaPopUp;
import popups.TelaPopUpCadastro;
import popups.TelaPopUpCapitulos;
import popups.TelaPopUpInfoCadaSuc;
import popups.TelaPopUpPerfil;
import popups.TelaPopUpRecSenha;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerInfoCadastroComSucesso implements Initializable {

    @FXML
    private Button btnEntrarAuto;
    @FXML
    private Button btnVoltarTelaLogin;

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
            logarAutomaticamente(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed2(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            VoltarTelaParaLogin(event);
        }
    }
    
    //logar automaticamente
    @FXML
    private void logarAutomaticamente(ActionEvent event) throws IOException {
        try {
            new TelaPopUp().start(new Stage());
            TelaPopUpInfoCadaSuc.myStage.close();
            TelaPopUpCadastro.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //acessar tela de login
    @FXML
    private void VoltarTelaParaLogin(ActionEvent event){
        try {
            new Main().start(new Stage());
            TelaPopUpInfoCadaSuc.myStage.close();
            TelaPopUpCadastro.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
}