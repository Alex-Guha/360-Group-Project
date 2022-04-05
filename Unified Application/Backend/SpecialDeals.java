package Backend;

public class SpecialDeals extends MenuItem {
	//the way deals work is that there are a list of menuitems with an extra parameter. this extra parameter
	//acts as the percent to be marked off. The deal items are identical to menuItems, ids included. At the time of calculating prices,
	//the special deal replaces the meal.

	private static final long serialVersionUID = 1L;
	private int DiscountPercent;
	
	//constructor
	public SpecialDeals(int id, String name, float price, int quantity,  int DiscountPercent, String imageLink, String text1, String text2, String text3) {
		super(id, name, price, quantity, imageLink, text1, text2, text3);
		this.DiscountPercent = DiscountPercent;
	}
	
	public int getPercentage() {
		return DiscountPercent;
	}
	
	public String toString() { //i avoid using the built-in arraylist tostring function so if you see that please fix it future zack
		String result = "";
		result += Integer.toString(super.getId()) + "," + super.getName() + "," + Float.toString(super.getPrice()) + "," + Integer.toString(super.getQuantity()) + 
				"," + Integer.toString(DiscountPercent) + "," + super.getImageLink() + "\n"; // + menuItems.toString() 
		
		//result += ;
		return result;
	}
}
