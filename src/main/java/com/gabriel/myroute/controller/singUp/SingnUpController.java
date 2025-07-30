package com.gabriel.myroute.controller.singUp;

import com.gabriel.myroute.controller.util.CreateScane;
import com.gabriel.myroute.controller.util.AlertException;
import com.gabriel.myroute.entity.User;
import com.gabriel.myroute.service.singnUp.SingnUpService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SingnUpController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private TextField inputTextFildEmail;
    @FXML
    private TextField inputTextFildNome;
    @FXML
    private TextField inputTextFildSenha;
    @FXML
    private TextField inputTextFildTell;

    @FXML
    void signsUp(ActionEvent event) { // quando o botao for clicado
        SingnUpService sUService = new SingnUpService();
        User user = new User(inputTextFildNome.getText(),
                inputTextFildEmail.getText(),
                inputTextFildTell.getText(),
                inputTextFildSenha.getText()
        );// criar um objeto user

        boolean resultVerify = sUService.SingnUp(user);// regra de negocio para criar o novo usuario

        if (resultVerify) {

            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro efetuado com sucesso");
                alert.setHeaderText("Seu cadastro foi realisado ");
                alert.setContentText("Por favor faça o seu login para continuar");
                alert.show();

                CreateScane.createScane(new FXMLLoader(
                                SingnUpController.class.getResource("/com/gabriel/myroute/Home.fxml")),
                        event,
                        ""
                );// cria uma nova janela com a proxima pagina  nesse caso a home

            } catch (IOException e) {
                AlertException.tratamentoDeErro(e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Não foi possivel efetuar o cadastro");
            alert.setHeaderText("Email ou telefone já  cadastrados");
            alert.show();

        }
    }
}
