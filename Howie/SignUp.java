package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class SignUp {
	@FXML
	private Button signUpDone;
	
	@FXML
	private TextField txtField1;
	
	@FXML
	private TextField txtField2;
	
	@FXML
	private TextField txtField3;

	@FXML
	private PasswordField password1;

	@FXML
	private PasswordField password2;
	
	public void initialize() {
		 
	}
	
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
		m.changeScene("LogIn.fxml");
	}


	/**
	* body functions
	*/
	public void navigateToOurMenu(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Menu.fxml");
	}

	public void navigateToLogin(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LogIn.fxml");
	}
}