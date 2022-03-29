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
		
		public void setMenuItems(ArrayList<MenuItem> menuItems) {
			this.menuItems = menuItems;
			
		}
		
		public void setPercentage(int percentage)
		{
			this.percentage = percentage;
		}
		
		public void setImageLink(String imageLink) {
			this.ImageLink = imageLink;
			
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
		
		public ArrayList<MenuItem> getMenuItems() {
			
			return menuItems;
		}
		
		public int getPercentage() {
			
			return percentage;
		}
		
		public String getImageLink() {
			
			return ImageLink;
		}
		
		//toString
		public String toString() {
			String result = "";
			result += "\n" + Integer.toString(id) + "," + name + "," + Float.toString(price) + "," + Integer.toString(percentage) + "," + menuItems.toString() + "," + ImageLink + "\n";
			return result;
		}
		

}
