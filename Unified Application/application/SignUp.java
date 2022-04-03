package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Backend.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp {
	@FXML
	private Label title;
	
	@FXML
	private TextField Email;
	
	@FXML
	private TextField Email2;
	
	@FXML
	private TextField Username;

	@FXML
	private PasswordField Password;

	@FXML
	private PasswordField Password2;
	
	private Customer user;
	
	public void initialize() {
		try {
			FileInputStream fi = new FileInputStream(new File("userInfo.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			user = (Customer) oi.readObject();
			
			oi.close();
			fi.close();
		} catch (Exception e) {
			//System.out.println("User is not logged in");
		}
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
	
	public void signUp(ActionEvent event) {
		try {
			String email = Email.getText();
			String email2 = Email2.getText();
			String username = Username.getText();
			String password = Password.getText();
			String password2 = Password2.getText();
			
			if(email.equals(email2) && !email.isEmpty()) {
				if(password.equals(password2) && !password.isEmpty()) {
					if(!username.isEmpty()) {
						if(user.register(username, password, email)) {
							FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
							ObjectOutputStream o = new ObjectOutputStream(f);
							o.writeObject(user);
							o.close();
							f.close();
							
							Main m = new Main();
							m.changeScene("sample.fxml");
						} else {
							title.setText("User already exists");
							title.setTextFill(Color.RED);
						}
					} else {
						title.setText("Username field empty");
						title.setTextFill(Color.RED);
					}
				} else {
					title.setText("Passwords do not match");
					title.setTextFill(Color.RED);
				}
			} else {
				title.setText("Email address do not match");
				title.setTextFill(Color.RED);
			}

		} catch(Exception e) {
			title.setText("Something went wrong");
			title.setTextFill(Color.RED);
		}
	}
}