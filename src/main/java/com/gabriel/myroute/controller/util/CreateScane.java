package com.gabriel.myroute.controller.util;
import com.gabriel.myroute.controller.interfaces.Controller;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import java.io.IOException;

public class CreateScane {
    public  static Controller createScane(FXMLLoader loader, Event event, String textoDaJanela) throws IOException {
        Parent arquivoFXml = loader.load(); // caregar o arquivo da cena

        Object objectEvento =  event.getSource();// pegar o objeto que chamou esse envento

        Node nodeEvento = (Node) objectEvento;// transforma o objeto  um objeto fxml

        Stage janela = (Stage) nodeEvento.getScene().getWindow(); // pegar a janela da qual o objeto faz parte

        Scene cena =  new Scene(arquivoFXml);// adicionar o arquivo a cena

        cena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());// adicionar a biblioteca de estilo

        janela.setTitle("MyRoute "+textoDaJanela); //adicionar o nome da janela

        janela.setResizable(false);// nao deixa a pesso redmencionar a janela

        janela.setScene(cena);// adicionar a cena na janela

        janela.show();// abrir a janela

        return loader.getController();
    }
}
