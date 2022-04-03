package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Backend.Customer;
import Backend.MenuItem;
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
		
		if(user == null) {
			user = new Customer();
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
		
		user.addToCart(new MenuItem(1, "Sweet Dream", 3, 1, "@../images/1.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem2(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(2, "Crystal Shrimp", 3, 1, "@../images/2.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem3(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(3, "Udon Noodles", 9, 1, "@../images/3.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem4(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(4, "Braised Meat", 9, 1, "@../images/4.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	
	public void menuItem5(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(5, "Butter Crab", 13, 1, "@../images/5.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem6(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(6, "Victorious Legend", 13, 1, "@../images/6.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem7(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(7, "Sashimi Platter", 13, 1, "@../images/7.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem8(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(8, "Cold Cut Platter", 11, 1, "@../images/8.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem9(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(9, "Berry & Mint Burst", 6, 1, "@../images/9.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem10(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(10, "Wolfhook Juice", 6, 1, "@../images/10.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	
	public void menuItem11(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(11, "Rice Pudding", 5, 1, "@../images/11.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
	public void menuItem12(ActionEvent event) throws IOException {
		
		user.addToCart(new MenuItem(12, "Tricolor Dango", 5, 1, "@../images/12.jpg"));
		
		FileOutputStream f = new FileOutputStream(new File("userInfo.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(user);
		o.close();
		f.close();
		
		Main m = new Main();
		m.changeScene("AddItemsToCart.fxml");
	}
	
}
