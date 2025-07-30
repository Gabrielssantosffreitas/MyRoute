package com.gabriel.myroute.controller.util;

import javafx.scene.control.Alert;

public class AlertException {
    public static void tratamentoDeErro(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText("ERRO IOException");
        alert.setContentText(e.getMessage());
        alert.show();
        e.printStackTrace();
    }
}
