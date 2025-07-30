package com.gabriel.myroute.controller.userController;

import com.gabriel.myroute.controller.interfaces.Controller;
import com.gabriel.myroute.entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserController implements Controller {
	private User user;
	
	public void setUser(User user) {
		this.user = user;
			
		outputLabelNome.setText(this.user.getNome());
		outputLabelId.setText(String.valueOf(this.user.getId()));
		outputLabelEmail.setText(this.user.getEmail());
		System.out.println("user:" +  this.user.getEmail());
	}
	
	@FXML
    private Label outputLabelEmail;

    @FXML
    private Label outputLabelId;

    @FXML
    private Label outputLabelNome;
	
	
}
