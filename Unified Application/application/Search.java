package application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import Backend.Customer;
import Backend.MenuItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	
	@FXML
	private Button button;
	
	@FXML
	private VBox searchBox;

	private Customer user;
	private ArrayList<MenuItem> menuList;
	
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
			menuList = new ArrayList<MenuItem>();
			File userList = new File(getClass().getResource("MenuItems.txt").toURI());
			Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.isEmpty())
                	continue;
                String[] parse = data.split("\\|");
                menuList.add(new MenuItem(Integer.parseInt(parse[0]), parse[1], Float.parseFloat(parse[2]), Integer.parseInt(parse[3]), parse[4], parse[5], parse[6], parse[7]));
            }
            myReader.close();
		} catch(Exception e) {
			System.out.println("Error in loading menu.");
			e.printStackTrace();
		}

		// TODO Remove all items that don't match search from the menuList
		try {
			for(int i = 0; i < menuList.size() ; i++) {
				// TODO Compare name of item at i to the search input
				if(!menuList.get(i).getName().toLowerCase().contains(user.searchEntry.toLowerCase())) {
					menuList.remove(i);
					i--;
				}
			}
		} catch(Exception e) {
			System.out.println("Error in curating search results");
			e.printStackTrace();
		}
		
		try {
			for(int i = 0; i < menuList.size() ; i++) {
				HBox container = new HBox();
				container.setPrefSize(200, 100);

				Image picture = new Image(menuList.get(i).getImageLink());
				ImageView image = new ImageView();
				image.setImage(picture);
				image.setFitHeight(150.0);
				image.setFitWidth(150.0);
				container.getChildren().add(image);

				Pane pane = new Pane();
				pane.setPrefSize(317, 149);
				pane.setStyle("-fx-background-color: white;");

				Label dishName = new Label(menuList.get(i).getName());
				dishName.setPrefSize(317, 38);
				dishName.setFont(Font.font("Candara", 20));
				pane.getChildren().add(dishName);
				
				String text = menuList.get(i).getText();
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
				
				Label price = new Label("Price: " + menuList.get(i).getPrice());
				price.setLayoutY(111.0);
				price.setPrefSize(317, 24);
				price.setFont(Font.font("Candara Light", 14));
				pane.getChildren().add(price);

				container.getChildren().add(pane);
				
				Button btn = new Button("Add to Cart");
				int id = menuList.get(i).getId();
				btn.setOnAction(event -> addMenuItem(id-1));
				btn.setPrefSize(82, 149);
				btn.setStyle("-fx-background-color: #f5f5f5;");
				btn.setFont(Font.font("Candara Light", 11));
				container.getChildren().add(btn);
				
				container.setPadding(new Insets(0,0,10,0));
				searchBox.getChildren().add(container);
			}
		} catch(Exception e) {
			System.out.println("Error in rendering search results");
			e.printStackTrace();
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
	
	public void addMenuItem(int id) {
		try {
			user.addToCart(menuList.get(id));
			
			FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(user);
			o.close();
			f.close();
			
			Main m = new Main();
			m.changeScene("AddItemsToCart.fxml");
		} catch(Exception e) {
			System.out.println("Error in saving added item to cart");
			e.printStackTrace();
		}
	}
}
