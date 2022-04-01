//package Project;

import java.util.ArrayList;
import java.util.ListIterator;


public class Cart 
{
	private int quantity;
	private int productId;
	private ArrayList<MenuItem> currentOrder;
	private Deals dealList;
	
	public Cart(int quantity, int productID) {
		this.quantity = quantity;
		this.productId = productID;
		this.currentOrder = new ArrayList<MenuItem>();
		this.dealList = new Deals();
		
	}
	
	
	
	
	
	public void setCurrentOrder(ArrayList<MenuItem> currentorder) {
		this.currentOrder = currentOrder;
		
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}
	
	public void setProductId(int productID) {
		this.productId = productID;		
	}
	
	
	public ArrayList<MenuItem> getCurrentOrder(){
		
		return this.currentOrder;
	}
	
	public int getQuantity() {
		return this.quantity;
		
	}
	
	public int getProductID() {
		
		return this.productId;
	}
	
	public void addItem(MenuItem newItem)
	{
		currentOrder.add(newItem);
		System.out.println("\nNew item has been added");
		
	}
	
	public void removeItem(int newProductID)
	{
		ListIterator<MenuItem> iterator = currentOrder.listIterator();
		
		while(iterator.hasNext()) 
		{
			MenuItem itemCompare = iterator.next();
			
			if (itemCompare.getId() == newProductID)
			{
				currentOrder.remove(itemCompare);
				System.out.println("\n Item has been removed");
				break;
			}
		}
	}
	
	public void updateQuantity(int newProductID, int newQuantity)
	{
		ListIterator<MenuItem> iterator = currentOrder.listIterator();
		
		while(iterator.hasNext()) 
		{
			MenuItem itemCompare = iterator.next();
			
			if (itemCompare.getId() == newProductID)
			{
				int oldQuantity = itemCompare.getQuantity();
				itemCompare.setQuantity(newQuantity);
				
				System.out.println("\nThe quantity " + Integer.toString(oldQuantity) + " has been changed to " + Integer.toString(newQuantity) + "\n");
				break;
			}
		}
		
	}
	
	public float calcTotal() {
		float total = 0;
		
		for(int i = 0; i < this.currentOrder.size(); i++) {
			boolean match = false;
			int referenceID = 0;
			int referenceQuantity = 0;
			//total += this.currentOrder.get(i).getPrice() * dealList.findDeal(currentOrder.get(i)) * this.currentOrder.get(i).getQuantity();
			
			for(int o = 0; o < dealList.getList().size() || o < this.currentOrder.size(); o++) {
				if(this.currentOrder.get(i).getId() == dealList.getList().get(o).getId()) {
					match = true;
					referenceID = this.currentOrder.get(i).getId();
					referenceQuantity = this.currentOrder.get(i).getQuantity();
				}
				
			}
			
			if(match) {
				
				SpecialDeals replacement = dealList.getbyID(referenceID);
				total += replacement.getPrice() * ((100 - replacement.getPercentage()) / 100) * referenceQuantity;
			} else {
				
				total += this.currentOrder.get(i).getPrice() * this.currentOrder.get(i).getQuantity();
			}
		}
		
		
		return total;
	}
	
	public void checkOut()
	{
		System.out.println("Order Completed!");
	}
	
	public String toString() {
		String result = "";
		for(int i = 0; i < currentOrder.size(); i++) {
			result += currentOrder.get(i).toString();
			
		}
		
		return result;
		
	}
}
