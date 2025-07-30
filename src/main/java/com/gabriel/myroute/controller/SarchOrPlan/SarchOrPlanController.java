package com.gabriel.myroute.controller.SarchOrPlan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.gabriel.myroute.controller.Plan.PlanController;
import com.gabriel.myroute.controller.Search.SearchController;
import com.gabriel.myroute.controller.interfaces.Controller;
import com.gabriel.myroute.controller.userController.UserController;
import com.gabriel.myroute.controller.util.AlertException;
import com.gabriel.myroute.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class SarchOrPlanController implements Controller, Initializable {
	private User user;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	private Tab outputTabInfo;

	@FXML
	private Tab outputTabPlan;

	@FXML
	private Tab outputTabSeach;

	private Controller loaderUser() throws IOException {
		FXMLLoader userLoader = new FXMLLoader(getClass().getResource("/com/gabriel/myroute/SearchPlan/User.fxml"));
		AnchorPane searchContent = userLoader.load();
		Controller userController = userLoader.getController();
		outputTabInfo.setContent(searchContent);
		return (Controller) userController;

	}

	private Controller loaderPlan() throws IOException {
		FXMLLoader userLoader = new FXMLLoader(getClass().getResource("/com/gabriel/myroute/SearchPlan/Plan.fxml"));
		AnchorPane searchContent = userLoader.load();
		Controller userController = userLoader.getController();
		outputTabPlan.setContent(searchContent);
		return (Controller) userController;

	}

	private Controller loaderSearch() throws IOException {
		FXMLLoader userLoader = new FXMLLoader(getClass().getResource("/com/gabriel/myroute/SearchPlan/Search.fxml"));
		AnchorPane searchContent = userLoader.load();
		Controller userController = userLoader.getController();
		outputTabSeach.setContent(searchContent);
		return (Controller) userController;

	}

	public void setUser(User user) {
		this.user = user;

		try {
			UserController userController = (UserController) loaderUser();

			SearchController searchController = (SearchController) loaderSearch();

			PlanController planController = (PlanController) loaderPlan();
			
			userController.setUser(this.user);
			searchController.setUser(this.user);
			planController.setUser(this.user);
			

		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			AlertException.tratamentoDeErro(e);
		}

	}

}
