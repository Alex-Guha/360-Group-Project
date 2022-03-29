//package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Menu
{
	private ArrayList<MenuItem> menuList;
	
	public Menu()
	{
		
		//automatically generate a cenralized menuList
		//THIS ACTS AS THE ONE MENU THE CUSTOMER SEES
		this.menuList = new ArrayList<MenuItem>();
		
		
		try { //read menuItems text file to automatically populate the menu
    		File userList = new File("MenuItems.txt");
    		
    		Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
                menuList.add(new MenuItem(Integer.parseInt(parse[0]), parse[1], Float.parseFloat(parse[2]), Integer.parseInt(parse[3]), parse[4]));
            }

            myReader.close();
           
    	} catch(FileNotFoundException e) { //in case we mess up and there is no file
    		e.printStackTrace();
    	}
		
	}
	
	public void getList()
	{
		ListIterator<MenuItem> iterator = menuList.listIterator();
		while(iterator.hasNext())
		{
			MenuItem item = iterator.next();
			System.out.println(item);
		}
	}
	
	public void addItem(MenuItem newItem)
	{
		//add new item to arraylist
		menuList.add(newItem);
		
		//add new item to textfile too
		try {
            File userList = new File("MenuItems.txt");
            //String[] parseList = new String[];

            //check for duplicates in text file based on username
            boolean duplicate = false;

            Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
                if (parse[0].equals(Integer.toString(newItem.getId()))) {
               
                    System.out.println("Username already taken");
                    duplicate = true;
                    //return false;
                }
            }

            myReader.close();

            //begin writing to file if no duplicates
            if(!duplicate) {
                FileWriter myWriter = new FileWriter(userList);
                myWriter.write("\n" + newItem.toString() + "\n");
                myWriter.close();
            }
            

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            //return false;
            
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println("Item has been succesfully added!");
	}
	
	public void removeItem(int id)
	{
		boolean removed = false;
		ListIterator<MenuItem> iterator = menuList.listIterator();
		
		while(iterator.hasNext())
		{
			MenuItem item = iterator.next();
			if (item.getId() == id)
			{
				menuList.remove(item);
				removed = true;
			}
		}
		
		if (removed)
			System.out.println("Item has been succesfully removed!");
		else
			System.out.println("Item not found");
	}
	
	
	public String toString() {
		String result = "";
		
		for(int i = 0; i < menuList.size(); i ++) {
			result += menuList.get(i).toString();
		}
		
		return result;
	}

}
