import java.util.ArrayList;

public class SpecialDeals {

	private int id;
	private String name;
	private float price;
	private ArrayList<MenuItem> menuItems;
	private int percentage;
	private String ImageLink;
	
	
	public SpecialDeals(int id, String name, float price, ArrayList<MenuItem> menuItems, int percentage, String ImageLink) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.menuItems = new ArrayList<MenuItem>();
		this.percentage = percentage;
		this.ImageLink = ImageLink;
	}

}
