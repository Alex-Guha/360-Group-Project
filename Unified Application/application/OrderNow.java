package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Backend.Customer;
import Backend.MenuItem;


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
		if(user != null)
			try {
				VBox orderDisplay = new VBox();
				orderDisplay.setAlignment(Pos.TOP_CENTER);
				ArrayList<MenuItem> customerOrder = user.getOrder();
				
				for(int i = 0; i < customerOrder.size() ; i++) {
					HBox container = new HBox();
					container.setPrefSize(600, 100);
	
					Image picture = new Image(customerOrder.get(i).getImageLink());
					ImageView image = new ImageView();
					image.setImage(picture);
					image.setFitHeight(150.0);
					image.setFitWidth(150.0);
					container.getChildren().add(image);
	
					Pane pane = new Pane();
					pane.setPrefSize(317, 149);
					pane.setStyle("-fx-background-color: white;");
	
					Label dishName = new Label(customerOrder.get(i).getName());
					dishName.setPrefSize(318, 38);
					dishName.setFont(Font.font("Candara", 20));
					pane.getChildren().add(dishName);
	
					String text = customerOrder.get(i).getText();
	                String[] parse = text.split("\\|");
					
					Label text1 = new Label(parse[0]);
					text1.setLayoutY(38.0);
					text1.setPrefSize(317, 24);
					text1.setFont(Font.font("Candara Light", 14));
					pane.getChildren().add(text1);
	
					Label text2 = new Label(parse[1]);
					text2.setLayoutY(63.0);
					text2.setPrefSize(317, 24);
					text2.setFont(Font.font("Candara Light", 14));
					pane.getChildren().add(text2);
	
					Label text3 = new Label(parse[2]);
					text3.setLayoutY(87.0);
					text3.setPrefSize(317, 24);
					text3.setFont(Font.font("Candara Light", 14));
					pane.getChildren().add(text3);
					
					Label quantity = new Label("Quantity: " + customerOrder.get(i).getQuantity());
					quantity.setLayoutY(111.0);
					quantity.setPrefSize(317, 24);
					quantity.setFont(Font.font("Candara Light", 14));
					pane.getChildren().add(quantity);
	
					container.getChildren().add(pane);
					
					Button btn = new Button("Remove");
					int id = customerOrder.get(i).getId();
					btn.setOnAction(event -> menuItemBtn(id));
					btn.setPrefSize(82, 149);
					btn.setStyle("-fx-background-color: #e3e3e3;");
					btn.setFont(Font.font("Candara Light", 11));
					container.getChildren().add(btn);
					
					container.setPadding(new Insets(0,0,10,0));
					orderDisplay.getChildren().add(container);
					VBox.setMargin(orderDisplay, new Insets(0,0,0,10));
					
					totalPrice += (float) customerOrder.get(i).getQuantity() * customerOrder.get(i).getPrice();
				}
				
				Label total = new Label("Order Total: " + totalPrice);
				total.setPrefSize(317, 24);
				total.setFont(Font.font("Candara Light", 14));
				orderDisplay.getChildren().add(total);
				orderPane.getChildren().add(orderDisplay);
			} catch(Exception e) {
				//System.out.println("Nothing in cart");
				e.printStackTrace();
			}
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
	
	public void menuItemBtn(int id) {
		try {
			user.removeFromCart(id);
			
			FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(user);
			o.close();
			f.close();

			Main m = new Main();
			m.changeScene("OrderNow.fxml");
		} catch(Exception e) {
			System.out.println("You somehow found an error where there really, really shouldn't be one. Well done!");
			e.printStackTrace();
		}
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
