package utilitarios;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import popups.*;

public class Util {
    
    public static void fecharTelaPlayer(){
        try {
            Class classe = TelaPopUp.class;
            ((TelaPopUp)classe.newInstance()).myStage.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar tela player");
        }
    }
    
    public static void fecharTelaBiblioteca(){
        try {
            Class classe = TelaPopUpMinhaBiblioteca.class;
            ((TelaPopUpMinhaBiblioteca)classe.newInstance()).myStage.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar tela player");
        }
    }
    
    public static void fecharTelaPerfil(){
        try {
            Class classe = TelaPopUpMinhaBiblioteca.class;
            ((TelaPopUpPerfil)classe.newInstance()).myStage.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar tela player");
        }
    }
    
    public static void fecharTelaCapitulos(){
        try {
            Class classe = TelaPopUpMinhaBiblioteca.class;
            ((TelaPopUpCapitulos)classe.newInstance()).myStage.close();
        } catch (Exception ex) {
            System.out.println("Erro ao fechar tela player");
        }
    }
    
    
    
}
