/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ControllerCapitulos.aux;
import popups.TelaPopUpCapitulos;
import popups.TelaPopUp;
import popups.TelaPopUpPerfil;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.Main;
import popups.TelaPopUpMinhaBiblioteca;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerMinhaBiblioteca implements Initializable {

    //public static Stage myStage;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnDownloads;
    @FXML
    private Button btnBiblioteca;
    @FXML
    private TextField txtPesquisar;
    @FXML
    private Button btnConfirmarPesquisa;
    @FXML
    private ImageView b;
    @FXML
    private Button btnPlayer;
    @FXML
    private Button btnCapitulos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Main.myStage.close();
    }    
 
    @FXML
    private void acessarHome(ActionEvent event) {
    }

    //acessar tela de perfil
    @FXML
    private void acessarPerfil(ActionEvent event) {
        try {
            new TelaPopUpPerfil().start(new Stage());
            TelaPopUpMinhaBiblioteca.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    private void acessarDownloads(ActionEvent event) {
    }

    @FXML
    private void acessarBiblioteca(ActionEvent event) {

    }

    @FXML
    private void pesquisar(ActionEvent event) {
    }

    @FXML
    private void confirmarPesquisa(ActionEvent event) {
    }

    //acessar tela de player
    @FXML
    private void acessarPlayer(ActionEvent event) {
        try {
            new TelaPopUp().start(new Stage());
            TelaPopUpMinhaBiblioteca.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //acessar tela de capitulos
    @FXML
    private void acessarCapitulos(ActionEvent event) throws IOException {
        try {
            new TelaPopUpCapitulos().start(new Stage());
            TelaPopUpMinhaBiblioteca.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
    //acessar capitulos do audiolivro senhora
    @FXML
    private void senhora(ActionEvent event)  throws IOException {
         Main.aux = 1;
        
        try {
            new TelaPopUpCapitulos().start(new Stage());
            TelaPopUpMinhaBiblioteca.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
        
    }
    
    //acessar capitulos do audiolivro A viuvinha
    @FXML
    private void viuvinha(ActionEvent event)  throws IOException {
         Main.aux = 2;
        
        try {
            new TelaPopUpCapitulos().start(new Stage());
            TelaPopUpMinhaBiblioteca.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
        
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed3(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarBiblioteca(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed4(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarPlayer(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed5(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarPerfil(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed6(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarCapitulos(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed7(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            senhora(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
        public void buttonPressed8(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            viuvinha(event);
        }
    }
}
