package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Backend.Customer;


public class OrderNow {
	
	@FXML
	private Button button;
	
	@FXML 
	private Pane orderPane;

	private double totalPrice = 0;
	
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
		
		VBox orderDisplay = new VBox();
		// currentOrder customerOrder[] = customerCart.getCurrentOrder();
		ArrayList<String> customerOrder = new ArrayList<String>();
		customerOrder.add("TEST TEST TEST 123");
		customerOrder.add("TEST TEST TEST 456");
		customerOrder.add("TEST TEST TEST 789");
		for(int i = 0; i < customerOrder.size() ; i++) {
			HBox hBox = new HBox();
			Label menuItem = new Label(customerOrder.get(i)); // customerOrder[i].getName()
			hBox.getChildren().add(menuItem);
			Label quantity = new Label("Quantity: " + 3); // customerOrder[i].getQuantity()
			hBox.getChildren().add(quantity);
			Button remove = new Button("Remove");
			hBox.getChildren().add(remove);
			orderDisplay.getChildren().add(hBox);
			
			//totalPrice = (float) customerOrder[i].getQuantity() * customerOrder[i].getPrice();
			totalPrice = ((float) 3) * 4.99;
		}
		Label total = new Label("Order Total: " + totalPrice);
		orderDisplay.getChildren().add(total);
		orderPane.getChildren().add(orderDisplay);
		
		/*VBox orderDisplay = new VBox();
		HBox hBox = new HBox();
		Label menuItem = new Label("dango milk");
		hBox.getChildren().add(menuItem);
		Label quantity = new Label("Quantity: 1");
		hBox.getChildren().add(quantity);
		Button remove = new Button("Remove");
		hBox.getChildren().add(remove);
		orderDisplay.getChildren().add(hBox);
			
		totalPrice = 1.00;
		Label total = new Label("Order Total: $" + totalPrice);
		orderDisplay.getChildren().add(total);
		orderPane.getChildren().add(orderDisplay);*/
		
		
	}
	
	
	public void navigateToPaymentPage() throws IOException {
		Main m = new Main();
		m.changeScene("Payment.fxml");
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
		
	
	
}
