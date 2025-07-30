package com.gabriel.myroute.controller.Search;


import java.net.URL;
import java.util.ResourceBundle;

import com.gabriel.myroute.controller.interfaces.Controller;
import com.gabriel.myroute.entity.User;
import com.gabriel.myroute.serviceSearch.ServiceSearch;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SearchController implements Controller, Initializable{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	private User user;
	private ServiceSearch service = new ServiceSearch()	;
	

	public void setUser(User user) {
		this.user = user;
	}
	
	@FXML
    private TextArea inputTextAreaPreferencia;

    @FXML
    private TextField inputTextFildCidade;

    @FXML
    private TextField inputTextFildNome;

    @FXML
    void search() {
    	service.pesquisar(inputTextFildCidade.getText(),inputTextFildNome.getText(),inputTextAreaPreferencia.getText(),this.user.getId());

    }
}
