package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Backend.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
	@FXML
	private Button button;
	@FXML
	private TextField loginUsername;
	@FXML
	private PasswordField loginPassword;
	@FXML
	private Label title;
	
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
	
	public void navigateToFAQ(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("FAQ.fxml");
	}
	
	public void navigateToAbout(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("AboutUs.fxml");
	}
	
	public void navigateToLogin(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void login(ActionEvent event) {
		try {
			String username = loginUsername.getText();
			String password = loginPassword.getText();
			
			Customer user = new Customer();
			
			if(user.login(username, password)) {
				FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(user);
				o.close();
				f.close();
				Main m = new Main();
				m.changeScene("sample.fxml");
			} else {
				title.setText("Username or Password incorrect");
				title.setTextFill(Color.RED);
			}
		} catch(Exception e) {
			title.setText("Something went wrong");
			title.setTextFill(Color.RED);
		}
	}

	public void navigateToSignUp(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("SignUp.fxml");
	}
}