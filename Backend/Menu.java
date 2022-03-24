package Project;

import java.util.ArrayList;
import java.util.ListIterator;

public class Menu extends MenuItem
{
	private ArrayList<MenuItem> menuItem;
	
	public Menu(ArrayList<MenuItem> menuItem, int id, String name, float price, int quantity, String ImageLink)
	{
		super(id, ImageLink, price, quantity, ImageLink); 
		this.menuItem = menuItem;
	}
	
	public void getList()
	{
		ListIterator<MenuItem> iterator = menuItem.listIterator();
		while(iterator.hasNext())
		{
			MenuItem item = iterator.next();
			System.out.println(item);
		}
	}
	
	public void addItem()
	{
		
		System.out.println("Item has been succesfully added!");
	}
	
	public void removeItem(int id)
	{
		boolean removed = false;
		ListIterator<MenuItem> iterator = menuItem.listIterator();
		
		while(iterator.hasNext())
		{
			MenuItem item = iterator.next();
			if (item.getId() == id)
			{
				menuItem.remove(item);
				removed = true;
			}
		}
		
		if (removed)
			System.out.println("Item has been succesfully removed!");
		else
			System.out.println("Item not found");
	}

}
