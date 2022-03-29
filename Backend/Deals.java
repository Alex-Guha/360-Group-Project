import java.util.ArrayList;

public class Deals{
	
	private ArrayList<SpecialDeals> deals; // = new ArrayList<SpecialDeals>();

	public Deals(ArrayList<SpecialDeals> deals, int id, String name, float price, ArrayList<MenuItem> menuItems, int percentage, String ImageLink) {
		// TODO Auto-generated constructor stub
		//super(id, name, price, menuItems, percentage, ImageLink);
		this.deals = new ArrayList<SpecialDeals>();
	}
	
	public ArrayList<SpecialDeals> getList() {
		return this.deals;
	}
	
	public void addItem(SpecialDeals newDeal) {
		this.deals.add(newDeal);
	}
	
	public void removeItem(int i) {
		this.deals.remove(i);
	}

}
