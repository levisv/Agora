/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import popups.TelaPopUpCapitulos;
import popups.TelaPopUpMinhaBiblioteca;
import popups.TelaPopUp;
import entidades.Usuario;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import popups.TelaPopUpPerfil;
import popups.TelaPopUpRecSenha;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerPerfil implements Initializable {

    ControllerLogin usuarioLogin = new ControllerLogin();

    public static Stage myStage;
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
    private Button btnPlayer;
    @FXML
    private Button btnCapitulos;
    @FXML
    private Button btnAlterarPerfil;
    @FXML
    private Button btnVoltarTelaLogin;
    @FXML
    private Text txtLogin;
    @FXML
    private Text txtNome;
    @FXML
    private Text txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtLogin.setText(usuarioLogin.usuario.getLogin());
        txtEmail.setText(usuarioLogin.usuario.getEmail());
        txtNome.setText(usuarioLogin.usuario.getNome());
        //Main.myStage.close();
    }

    @FXML
    private void acessarHome(ActionEvent event) {
    }

    @FXML
    private void acessarPerfil(ActionEvent event) {

    }

    @FXML
    private void acessarDownloads(ActionEvent event) {
    }

    //acessar tela de biblioteca
    @FXML
    private void acessarBiblioteca(ActionEvent event) {
        Parent root = null;
        try {
            new TelaPopUpMinhaBiblioteca().start(new Stage());
            TelaPopUpPerfil.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
        Scene scene = new Scene(root);
        main.Main.myStage.setScene(scene);
    }

    @FXML
    private void pesquisar(ActionEvent event) {
    }

    @FXML
    private void confirmarPesquisa(ActionEvent event) {
    }

    //acessar tela do player
    @FXML
    private void acessarPlayer(ActionEvent event) {
        try {
            new TelaPopUp().start(new Stage());
            TelaPopUpPerfil.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //acessar tela dos capitulos
    @FXML
    private void acessarCapitulos(ActionEvent event) {
        try {
            new TelaPopUpCapitulos().start(new Stage());
            TelaPopUpPerfil.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //acessar tela do login
    @FXML
    private void voltarTelaLogin(ActionEvent event) {
        try {
            new Main().start(new Stage());
            TelaPopUpPerfil.myStage.close();
            Main.mediaPlayer.pause();
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            voltarTelaLogin(event);
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
    

}
