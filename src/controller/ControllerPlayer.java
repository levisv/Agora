package controller;

import popups.TelaPopUpCapitulos;
import popups.TelaPopUpMinhaBiblioteca;
import popups.TelaPopUpPerfil;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import popups.*;

/**
 * FXML Controller class
 *
 * @author luisf
 */
public class ControllerPlayer implements Initializable {

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
    private Button playVideo;
    @FXML
    private Slider sldVolume;
    @FXML
    private Slider sldTempo;
    @FXML
    public ImageView capaAudioLivro;
    @FXML
    public Text nomeAutor;
    @FXML
    public Text nomeAudiolivro;
    @FXML
    public Text Genero;

    private static Double value = 1.0;

    private Duration duration;
    
    public static Stage myStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(Main.aux1 == 1){
            File audiolivro = new File(Main.caminhoarq);
            Main.caminhoarq = audiolivro.toURI().toString();
            if (Main.caminhoarq != null) {
                Media media = new Media(Main.caminhoarq);
                Main.mediaPlayer = new MediaPlayer(media);

                Main.mediaPlayer.setOnReady(new Runnable() {
                    public void run() {
                        duration = Main.mediaPlayer.getMedia().getDuration();
                        updateValues();
                        Main.aux1 =- 1;
                    }
                });
                
                Main.mediaPlayer.play();
            }
        }

        
        if (Main.mediaPlayer != null) {            
            sldVolume.setValue(Main.mediaPlayer.getVolume() * 100);
            duration = Main.mediaPlayer.getMedia().getDuration();
            updateValues();
            sldTempo.valueProperty().addListener(new InvalidationListener() {
                public void invalidated(Observable ov) {
                    if (sldTempo.isValueChanging()) {
                        // multiply duration by percentage calculated by slider position
                        Main.mediaPlayer.seek(duration.multiply(sldTempo.getValue() / 100.0));
                    }
                }
            });
            sldVolume.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    Main.mediaPlayer.setVolume(sldVolume.getValue() / 100);
                }
            });
            
            nomeAutor.setText(Main.autor);
                nomeAudiolivro.setText(Main.nomeLivro);
                Genero.setText(Main.genero);
                File file = new File(Main.imagem);
                Image capa = new Image(file.toURI().toString());
                capaAudioLivro.setImage(capa);
        }
        
        Main.myStage.close();
    }

    @FXML
    private void acessarHome(ActionEvent event) {
    }

    //acessar tela de perfil
    @FXML
    private void acessarPerfil(ActionEvent event) {
        try {
            new TelaPopUpPerfil().start(new Stage());
            TelaPopUp.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    private void acessarDownloads(ActionEvent event) {
    }

    //acessar tela de biblioteca
    @FXML
    private void acessarBiblioteca(ActionEvent event) {
        try {
            new TelaPopUpMinhaBiblioteca().start(new Stage());
            TelaPopUp.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    private void pesquisar(ActionEvent event) {
    }

    @FXML
    private void confirmarPesquisa(ActionEvent event) {
    }

    @FXML
    private void acessarPlayer(ActionEvent event) {

    }

    //acessar tela de capitulos
    @FXML
    private void acessarCapitulos(ActionEvent event) {
        try {
            new TelaPopUpCapitulos().start(new Stage());
            TelaPopUp.myStage.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
    
    //informações referentes ao audiolivro aberto
    @FXML
    public void informação(String nomeLivro, String autor, String genero) {
        nomeAutor.setText(autor);
        nomeAudiolivro.setText(nomeLivro);
        Genero.setText(genero);
   }

    //execução do player
    @FXML
    public void player() {    
        try {
            File audiolivro = new File(Main.caminhoarq);
            Main.caminhoarq = audiolivro.toURI().toString();
            if (Main.caminhoarq != null) {
                Media media = new Media(Main.caminhoarq);
                Main.mediaPlayer = new MediaPlayer(media);

                Main.mediaPlayer.setOnReady(new Runnable() {
                    public void run() {
                        duration = Main.mediaPlayer.getMedia().getDuration();
                        updateValues();
                    }
                });

                
                Main.mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable ov) {
                        Duration currentTime = Main.mediaPlayer.getCurrentTime();
                        if (!sldTempo.isDisabled() && !sldTempo.isValueChanging()) {
                            sldTempo.setValue(currentTime.divide(duration).toMillis() * 100.0);
                        }
                    }
                });

                sldTempo.valueProperty().addListener(new InvalidationListener() {
                    public void invalidated(Observable ov) {
                        if (sldTempo.isValueChanging()) {
                            // multiply duration by percentage calculated by slider position
                            Main.mediaPlayer.seek(duration.multiply(sldTempo.getValue() / 100.0));
                        }
                    }
                });

                sldVolume.setValue(Main.mediaPlayer.getVolume() * 100);
                sldVolume.valueProperty().addListener(new InvalidationListener() {

                    @Override
                    public void invalidated(Observable observable) {
                        Main.mediaPlayer.setVolume(sldVolume.getValue() / 100);
                    }
                });
                
                nomeAutor.setText(Main.autor);
                nomeAudiolivro.setText(Main.nomeLivro);
                Genero.setText(Main.genero);
                File file = new File(Main.imagem);
                Image capa = new Image(file.toURI().toString());
                capaAudioLivro.setImage(capa);

                Main.mediaPlayer.play();
            }
        } catch (RuntimeException exception) {

        }

    }

    //ativar volume
    public void updateValues() {
        try {
            Duration currentTime = Main.mediaPlayer.getCurrentTime();
            sldTempo.setDisable(duration.isUnknown());
            if (!sldTempo.isDisabled()
                    && duration.greaterThan(Duration.ZERO)
                    && !sldTempo.isValueChanging()) {
                sldTempo.setValue(currentTime.divide(duration).toMillis() * 100.0);
            }
        } catch (Exception e) {

        }
    }

    //iniciar/pausar audiolivro
    @FXML
    private void playVideo(ActionEvent event) {
        try {
            if(Main.mediaPlayer !=null){
            Main.mediaPlayer.play();
            Main.mediaPlayer.pause();
            }else{
                player();
            }
        } catch (RuntimeException exception) {

        }
    }

    //aumentar velocidade audiolivro
    @FXML
    private void fastVideo(ActionEvent event) {
        try {
            value += 0.1;
            Main.mediaPlayer.setRate(value);
        } catch (Exception e) {

        }
    }

    //diminuir velocidade audiolivro
    @FXML
    private void slowVideo(ActionEvent event) {
        try {
            value -= 0.1;
            Main.mediaPlayer.setRate(value);
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
            fastVideo(event);
        }
    }

    //ativar pressionar do enter
    @FXML
    public void buttonPressed8(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            slowVideo(event);
        }
    }
    
    //ativar pressionar do enter
    @FXML
    public void buttonPressed9(KeyEvent e) throws IOException, NoSuchAlgorithmException {
        if (e.getCode().toString().equals("ENTER")) {
            ActionEvent event = null;
            playVideo(event);
        }
    }
}
