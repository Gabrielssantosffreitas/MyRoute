package com.gabriel.myroute.controller.Home;
import com.gabriel.myroute.controller.util.CreateScane;
import com.gabriel.myroute.controller.util.AlertException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    void logar(ActionEvent event) {
        try {
            CreateScane.createScane(new FXMLLoader(
                    HomeController.class.getResource("/com/gabriel/myroute/Login.fxml")),
                    event,
                    "Login"
            );

        } catch (IOException e) {
          AlertException.tratamentoDeErro(e);
        }
    }

    @FXML
    void singUp(ActionEvent event) {
            try {
                CreateScane.createScane(new FXMLLoader(
                        HomeController.class.getResource("/com/gabriel/myroute/Sign Up.fxml")),
                        event,
                        "Login"
                );
            } catch (Exception e) {
            	System.out.println(e.getMessage());
                AlertException.tratamentoDeErro(e);
            }
    }
}
