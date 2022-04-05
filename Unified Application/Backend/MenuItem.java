package Backend;

import java.io.Serializable;

public class MenuItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float price;
	private int quantity;
	private String imageLink;
	private String textLine1;
	private String textLine2;
	private String textLine3;
	
	public MenuItem(int id, String name, float price, int quantity, String imageLink, String textLine1, String textLine2, String textLine3) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imageLink = imageLink;
		this.textLine1 = textLine1;
		this.textLine2 = textLine2;
		this.textLine3 = textLine3;
	}
	
	
	//setter methods
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	
	//getter methods
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getImageLink() {
		return imageLink;
	}
	
	public String getText() {
		return textLine1 + "|" + textLine2 + "|" + textLine3;
	}
	
	//toString
	public String toString() {
		String result = "";
		result += Integer.toString(id) + "," + name + "," + Float.toString(price) + "," + Integer.toString(quantity) + "," + imageLink + "\n";
		return result;
	}
	
}
