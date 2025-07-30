package com.gabriel.myroute;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Cria um objeto FXMLLoader para carregar a interface gráfica (FXML)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/gabriel/myroute/Home.fxml"));

    // Carrega o arquivo FXML e cria a cena (a interface visual que será mostrada na janela)
        Scene scene = new Scene(fxmlLoader.load());
    // colocar os estilo
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
    // Define o título da janela (Stage)

        stage.setTitle("MyRoute");

        // impede que a pessoa maximise
        stage.setResizable(false);
    // Define a cena que será exibida na janela
        stage.setScene(scene);

    // Mostra a janela na tela
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}