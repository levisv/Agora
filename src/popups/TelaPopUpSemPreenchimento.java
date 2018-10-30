/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CodePlus
 */
public class TelaPopUpSemPreenchimento extends Application{

    public static Stage myStage;
    
    
    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/telas/ErroRetornoVazioCadastro.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            myStage = primaryStage;
            primaryStage.show();
        }catch(Exception e){
            System.out.println("deu ruim");
        }
    }
    
}