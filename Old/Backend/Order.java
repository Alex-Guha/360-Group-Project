import java.util.ArrayList;

public class Order {

	
	private int orderID;
	private String dateCreated;
	private String dateShipped;
	private String customerName;
	private int quantity;
	private float unitCost;
	private int deal_price;
	private int discount_percentage;
	private float total;
	private ArrayList<MenuItem> menuItems;
	
	public Order(int orderID, String dateCreated, String dateShipped, String customerName, int quantity, float unitCost, int deal_price, int discount_percentage, float total, ArrayList<MenuItem> menuItems ) {
		
		this.orderID = orderID;
		this.dateCreated = dateCreated;
		this.dateShipped = dateShipped;
		this.customerName = customerName;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.deal_price = deal_price;
		this.discount_percentage = discount_percentage;
		this.total = total;
		this.menuItems = menuItems;
		
	}
	
	
}
