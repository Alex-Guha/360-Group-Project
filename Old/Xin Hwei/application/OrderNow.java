package application;

import javafx.application.Application;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class OrderNow {
	
	@FXML
	private Button button;
	
	@FXML 
	private Pane orderPane;

	private double totalPrice = 0;
	
	public void initialize() {
		VBox orderDisplay = new VBox();
		currentOrder customerOrder[] = customerCart.getCurrentOrder();
		for(int i = 0; i<customerOrder.length ; i++) {
			HBox hBox = new HBox();
			Label menuItem = new Label(customerOrder[i].getName());
			hBox.getChildren().add(menuItem);
			Label quantity = new Label("Quantity: " + customerOrder[i].getQuantity());
			hBox.getChildren().add(quantity);
			Button remove = new Button("Remove");
			hBox.getChildren().add(remove);
			orderDisplay.getChildren().add(hBox);
			
			totalPrice = (float)customerOrder[i].getQuantity() + customerOrder[i].getPrice();
		}
		Label total = new Label("Order Total: " + totalPrice);
		orderDisplay.getChildren().add(total);
		orderPane.getChildren.().add(orderDisplay);
		
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
		m.changeScene("PaymentPage.fxml");
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
		m.changeScene("Login.fxml");
	}	
		
	
	
}
