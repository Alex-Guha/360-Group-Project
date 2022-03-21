package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Controller {
	public Controller() {}
	
	@FXML
	private Button button;
	
	public void navigateToMenu(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Menu.fxml");
	}
	
	public void navigateToOrder(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("OrderNow.fxml");
	}
	
	public void navigateToDeals(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("SpecialDeals.fxml");
	}
	
	public void navigateToAbout(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("AboutUs.fxml");
	}
	
	public void navigateToLogin(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
}
