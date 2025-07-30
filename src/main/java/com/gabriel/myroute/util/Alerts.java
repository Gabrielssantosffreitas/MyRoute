package com.gabriel.myroute.util;

import javafx.scene.control.Alert;

public class Alerts {
	private Alert alertBase(String title,String header,String content, Alert.AlertType tipo) {
		 Alert alert = new Alert(tipo);
         alert.setTitle(title);
         alert.setHeaderText(header);
         alert.setContentText(content);
         alert.show();
         return alert;

	}
	public Alert alertInformation(String title,String header,String content) { return this.alertBase(title, header, content,Alert.AlertType.INFORMATION);}
	
	public Alert alertError(String title,String header,String content) { return this.alertBase(title, header, content,Alert.AlertType.ERROR);}
	
	public Alert alertWarning(String title,String header,String content) {return this.alertBase(title, header, content,Alert.AlertType.WARNING);}
	
	public Alert alertConfirmation(String title,String header,String content) {return this.alertBase(title, header, content,Alert.AlertType.CONFIRMATION);}
	
}
