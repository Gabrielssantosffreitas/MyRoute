package com.gabriel.myroute.controller.login;
import java.io.IOException;
import com.gabriel.myroute.controller.interfaces.Controller;
import com.gabriel.myroute.controller.util.CreateScane;
import com.gabriel.myroute.controller.util.AlertException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginController implements Controller {

    @FXML
    private TextField inputTextFildEmail;
    @FXML
    private TextField inputTextFildSenha;

    @FXML
    void logar(ActionEvent event) {// quando o botao logar for clicado
        boolean isLogado = true;

        if (isLogado) {
            try {
                CreateScane.createScane(new FXMLLoader(
                        LoginController.class.getResource("/com/gabriel/myroute/SearchOrPlan.fxml")),
                        event,
                        ""
                );
            } catch (IOException e) {
                AlertException.tratamentoDeErro(e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Esse usuario nao existe");
            alert.show();
        }
    }
}
