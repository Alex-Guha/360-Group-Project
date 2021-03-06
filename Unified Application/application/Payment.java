package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Backend.Customer;
import Backend.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Payment {
	@FXML
	private Button button;

	@FXML 
	private Pane itemListPane;
	
	@FXML
	private Label title;
	
	@FXML
	private TextField creditCardNum;
	@FXML
	private TextField creditCardName;
	@FXML
	private TextField address;
	
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
		
		try {
			VBox orderDisplay = new VBox();
			ArrayList<MenuItem> customerOrder = user.getOrder();
			double totalPrice = 0;
			
			for(int i = 0; i < customerOrder.size() ; i++) {
				HBox hBox = new HBox();
				Label menuItem = new Label(customerOrder.get(i).getName());
				hBox.getChildren().add(menuItem);
				Label quantity = new Label("Quantity: " + customerOrder.get(i).getQuantity());
				hBox.getChildren().add(quantity);
				orderDisplay.getChildren().add(hBox);
				
				totalPrice += (float) customerOrder.get(i).getQuantity() * customerOrder.get(i).getPrice();
			}
			
			Label total = new Label("Order Total: " + totalPrice);
			orderDisplay.getChildren().add(total);
			itemListPane.getChildren().add(orderDisplay);
		} catch(NullPointerException e) {
			//System.out.println("Nothing in cart");
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
	
	public void checkout(ActionEvent event) throws IOException {
		try {
			String cardNum = creditCardNum.getText().replaceAll(" ", "");
			String cardName = creditCardName.getText();
			String Address = address.getText();
			if(cardNum.length() == 16) {
				if(user == null) {
					user = new Customer();
				}
				
				user.initialize(cardNum, cardName, Address);
				
				user.checkOut();
				
				user.cart.clearCart();
				
				FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(user);
				o.close();
				f.close();
				
				Main m = new Main();
				m.changeScene("sample.fxml");
			} else {
				title.setText("Credit Card Number Invalid");
				creditCardNum.setText("");
				title.setTextFill(Color.RED);
			}
		} catch(Exception e) {}
	}
}
