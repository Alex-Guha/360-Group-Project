//package Project;

import java.util.ArrayList;
import java.util.ListIterator;


public class Cart 
{
	private int quantity;
	private int productId;
	private ArrayList<MenuItem> currentOrder;
	
	public Cart(int quantity, int productID, ArrayList<MenuItem> item) {
		this.quantity = quantity;
		this.productId = productID;
		this.currentOrder = new ArrayList<MenuItem>();
		
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
				
				System.out.println("\nThe quantity " + Integer.toString(oldQuantity) + " has been changed to " + Integer.toString(newQuantity));
				break;
			}
		}
		
	}
	
	
}
