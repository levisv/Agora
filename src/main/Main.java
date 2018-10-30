package main;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author luisf
 */
public class Main extends Application {
    public static Scene SCENE;
    public static Stage myStage;
    public static MediaPlayer mediaPlayer; 
    public static String caminhoarq;
    public static int aux;
    public static int aux1;
    public static String nomeLivro;
    public static String genero;
    public static String autor;
    public static String imagem;
    
    public controller.ControllerPlayer player;

    public static void main(String[] args) {
            launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        Parent root;

        root = FXMLLoader.load(getClass().getResource("/telas/Login.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        myStage = primaryStage;
        primaryStage.show();
    }
}
