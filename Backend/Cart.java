package Project;

import java.util.ArrayList;
import java.util.ListIterator;


public class Cart 
{
	private int quantity;
	private int productId;
	private ArrayList<MenuItem> item = new ArrayList<MenuItem>();
	
	public void addItem(MenuItem newItem)
	{
		item.add(newItem);
	}
	
	public void removeItem(int newProductID)
	{
		ListIterator<MenuItem> iterator = item.listIterator();
		
		while(iterator.hasNext()) 
		{
			MenuItem itemCompare = iterator.next();
			
			if (itemCompare.getId() == newProductID)
			{
				item.remove(itemCompare);
				
				break;
			}
		}
	}
	
	public void updateQuantity(int newProductID, int newQuantity)
	{
		ListIterator<MenuItem> iterator = item.listIterator();
		
		while(iterator.hasNext()) 
		{
			MenuItem itemCompare = iterator.next();
			
			if (itemCompare.getId() == newProductID)
			{
				itemCompare.setQuantity(newQuantity);
				
				break;
			}
		}
		
	}
}
