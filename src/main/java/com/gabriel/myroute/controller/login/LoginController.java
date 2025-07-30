package com.gabriel.myroute.controller.login;
import java.io.IOException;

import com.gabriel.myroute.controller.SarchOrPlan.SarchOrPlanController;
import com.gabriel.myroute.controller.interfaces.Controller;
import com.gabriel.myroute.controller.util.CreateScane;
import com.gabriel.myroute.entity.User;
import com.gabriel.myroute.service.login.LoginService;
import com.gabriel.myroute.util.Alerts;
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
        LoginService lg = new LoginService();
        
        User usuario = lg.logar(inputTextFildEmail.getText(), inputTextFildSenha.getText());
    	

        if (usuario != null) {
            try {
            	
              SarchOrPlanController controller = (SarchOrPlanController) CreateScane.createScane(new FXMLLoader(
                        LoginController.class.getResource("/com/gabriel/myroute/SearchPlan/Main.fxml")),
                        event,
                        "Serch or plan"
                );
              controller.setUser(usuario);
              
            } catch (IOException e) {
                AlertException.tratamentoDeErro(e);
                e.printStackTrace();
            }
        } else {
        	Alerts alert = new Alerts();
            alert.alertError("FALHA AO LOGAR", "erro no login", "Por favor verificar se o email e a senha estão corretas");
        }
    }
}
