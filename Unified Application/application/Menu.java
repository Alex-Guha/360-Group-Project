package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Backend.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Menu {
	@FXML
	private Button button;
	
	private Customer user;
	@FXML
	private Button loginBtn;
	
	public void initialize() {
		try {
			FileInputStream fi = new FileInputStream(new File("userInfo.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			user = (Customer) oi.readObject();
			
			oi.close();
			fi.close();
			if(user.Username.isEmpty())
				throw new Exception();
			if(user.isLoggedIn) {
				loginBtn.setText(user.Username);
			}
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
		if(user != null) {
			if(!user.isLoggedIn) {
				Main m = new Main();
				m.changeScene("Login.fxml");
			}
		} else {
			Main m = new Main();
			m.changeScene("Login.fxml");
		}
	}
	
	public void menuItem1(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem2(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem3(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem4(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	
	public void menuItem5(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem6(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem7(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem8(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem9(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem10(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	
	public void menuItem11(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
	public void menuItem12(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	
}
