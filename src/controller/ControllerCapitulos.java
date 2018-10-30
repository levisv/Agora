/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import popups.TelaPopUpMinhaBiblioteca;
import popups.TelaPopUp;
import popups.TelaPopUpPerfil;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.Main;
import popups.TelaPopUpCapitulos;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerCapitulos implements Initializable {

    public static Stage myStage;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnBiblioteca;
    @FXML
    private TextField txtPesquisar;
    @FXML
    private Button btnPlayer;
    @FXML
    private Button btnCapitulos;
    
    public static int aux;


    //public int aux;
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

    //chamar tela de perfil
    @FXML
    private void acessarPerfil(ActionEvent event) {
        try {
            new TelaPopUpPerfil().start(new Stage());
            TelaPopUpCapitulos.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //chamar tela de biblioteca
    @FXML
    private void acessarBiblioteca(ActionEvent event) {
        try {
            new TelaPopUpMinhaBiblioteca().start(new Stage());
            TelaPopUpCapitulos.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //chamar tela do player
    @FXML
    private void acessarPlayer(ActionEvent event) {
        try {
            new TelaPopUp().start(new Stage());
            TelaPopUpCapitulos.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    private void acessarCapitulos(ActionEvent event) {
        
    }
    
    //passar caminhos dos capitulos 1
    @FXML
    private void acessarcapitulo1(ActionEvent event) {
        if (Main.aux == 1) {
            Main.caminhoarq = null;
            executar("..\\Agora-master\\src\\audio\\senhora_01_alencar_64kb.mp3", 
                        "Senhora", "José de Alencar", "Romance", "..\\Agora-master\\src\\imagens\\senhora.jpg");
        }
        if (Main.aux == 2) {
            Main.caminhoarq = null;
            executar("..\\Agora-master\\src\\audio\\viuvinha_01_alencar_64kb.mp3", 
                        "A Viuvinha", "José de Alencar", "Romance", "..\\Agora-master\\src\\imagens\\Viuvinha.jpg");
        }
    }

    
   //passar caminhos dos capitulos 2
    @FXML
    private void acessarcapitulo2(ActionEvent event) {

        if (Main.aux == 1) {
            Main.caminhoarq = null;
            executar("..\\Agora-master\\src\\audio\\senhora_02_alencar_64kb.mp3", 
                        "Senhora", "José de Alencar", "Romance", "..\\Agora-master\\src\\imagens\\senhora.jpg");
        }
        if (Main.aux == 2) {
            Main.caminhoarq = null;
            executar("..\\Agora-master\\src\\audio\\viuvinha_02_alencar_64kb.mp3", 
                        "A Viuvinha", "José de Alencar", "Romance", "..\\Agora-master\\src\\imagens\\Viuvinha.jpg");
        }
    }

    //começar a execução do player
    public void executar(String caminho, String nome, String autor, String genero, String imagem) {
        try {
            if (Main.mediaPlayer != null) {
                Main.mediaPlayer.stop();
                Main.mediaPlayer = null;
                Main.caminhoarq = caminho;
                Main.nomeLivro = nome;
                Main.autor = autor;
                Main.genero = genero;
                Main.imagem = imagem;
                Main.aux1 = 1;
                new TelaPopUp().start(new Stage());
                TelaPopUpCapitulos.myStage.close();
            } else {
                Main.caminhoarq = caminho;
                Main.nomeLivro = nome;
                Main.autor = autor;
                Main.genero = genero;
                Main.imagem = imagem;
                Main.aux1 = 1;
                new TelaPopUp().start(new Stage());
                TelaPopUpCapitulos.myStage.close();
            }
        } catch (Exception e) {
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
            acessarcapitulo1(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed8(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            acessarcapitulo2(event);
        }
    }

}
