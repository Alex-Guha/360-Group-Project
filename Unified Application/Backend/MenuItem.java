package Backend;

public class MenuItem {
	private int id;
	private String name;
	private float price;
	private int quantity;
	private String imageLink;
	
	public MenuItem(int id, String name, float price, int quantity, String imageLink) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imageLink = imageLink;
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
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
		
	}
	
	
	//getter methods
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public int getQuantity() {
		
		return quantity;
	}
	
	public String getImageLink() {
		
		return imageLink;
	}
	
	//toString
	public String toString() {
		String result = "";
		result += Integer.toString(id) + "," + name + "," + Float.toString(price) + "," + Integer.toString(quantity) + "," + imageLink + "\n";
		return result;
	}
	
}
