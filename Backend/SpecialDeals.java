import java.util.ArrayList;

public class SpecialDeals {

	private int id;
	private String name;
	private float price;
	private ArrayList<MenuItem> menuItems;
	private int percentage;
	private String ImageLink;
	
	
/*	public SpecialDeals(int id, String name, float price, int percentage, String ImageLink) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.menuItems = new ArrayList<MenuItem>();
		this.percentage = percentage;
		this.ImageLink = ImageLink;
	} */ // use MenuItems object
	

		public void addMenuItem(MenuItem item) {
			
			menuItems.add(item);
			System.out.println("\nItem has been succesfully added!\n");
		}
		
		public void removeMenuItem(int id) {
			
			menuItems.remove(id);
			System.out.println("Item has been succesfully removed!");
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
		public String toString() { //i avoid using the built-in arraylist tostring function so if you see that please fix it future zack
			String result = "";
			result += Integer.toString(id) + "," + name + "," + Float.toString(price) + "," + Integer.toString(percentage) + ","; // + menuItems.toString() 
			for(int o = 0; o < menuItems.size(); o++) {
  	    	  
  	    	  result += menuItems.get(o).toString();
  	        }
			result += "," + ImageLink + "\n";
			return result;
		}
		

}
