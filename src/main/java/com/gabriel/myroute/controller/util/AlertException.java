package com.gabriel.myroute.controller.util;

import com.gabriel.myroute.util.Alerts;

import javafx.scene.control.Alert;

public class AlertException {
    public static void tratamentoDeErro(Exception e){
       Alerts alert = new Alerts();
       alert.alertError("ERRO", "HOUVE UMA EXCEPTION", "");
       
    }
}
