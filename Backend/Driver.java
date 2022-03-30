package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Driver
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char input1;
		String inputInfo = new String();
		String line = new String();
		boolean loggedIn = false;
	    boolean isAdmin = false;

		//create objects to be used in this method.
	    User user = new User();
	    Cart cart = new Cart();
	    Menu menu = new Menu();
	    SpecialDeals sDeals = new SpecialDeals();
	    
		try
		{
		// print out the menu
		printMenu();

		// create a BufferedReader object to read input from a keyboard
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);

		do
		{
		System.out.print("What action would you like to perform?\n");
		line = stdin.readLine().trim();  //read a line
		input1 = line.charAt(0);
		input1 = Character.toUpperCase(input1);

		if (line.length() == 1)   //check if a user entered only one character
		 {
		  switch (input1)
		   {
		    case 'A':   //1. Log In
		    	if (loggedIn)
		    	{
		    		System.out.print("Already logged in, please log out if a new user.");
		    	}
		    	
		    	else
		    	{
		    		System.out.print("Please enter your username:\n");
				    String username = stdin.readLine().trim();
				     
				    System.out.print("Please enter your password:\n");
				    String password = stdin.readLine().trim();
				      
			     	loggedIn = user.login(username, password);
			     	isAdmin = user.getIsAdmin();
		    	}
		      break;
		      
		    case 'B':   //2. Sign Up
		    	if (loggedIn)
		    	{
		    		System.out.print("Already logged in, please log out if a new user.");
		    	}
		    	
		    	else
		    	{
			      System.out.print("Please enter your username:\n");
			      String username = stdin.readLine().trim();
			      
			      System.out.print("Please enter your password:\n");
			      String password = stdin.readLine().trim();
			      
			      System.out.print("Please enter your email:\n");
			      String email = stdin.readLine().trim();
			      
			      System.out.print("If admin, please enter code, otherwise type NULL:\n");
				  inputInfo = stdin.readLine().trim();
				  int adminCode = Integer.parseInt(inputInfo);
			      
				  // set admin code so admins making accounts can be verified
			      if (adminCode == 1111) // example code is '1111'
			      {
			    	  isAdmin = true;
			      }
			      
			      loggedIn = user.register(isAdmin, username, password, email);
		    	}
		      break;
		      
		    case 'C':   //3. Add Item to Cart
		    	if (loggedIn)
		    	{
		    		// user clicks button to "add item" in the UI
		    	}
		    	
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
		      break;
		    case 'D':   //4. Remove Item From Cart
		    	if (loggedIn)
		    	{
		    		// user clicks button to "remove item" in the UI
				    System.out.print("Please enter the id of a string to remove:\n");
				    inputInfo = stdin.readLine().trim();
				    int id = Integer.parseInt(inputInfo);
				    cart.removeItem(id);
		    	}
		    	
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
		      break;
		      
		    case 'E':  // 5. Update Quantity
		    	if (loggedIn)
		    	{
		    		// user clicks button to "remove item" in the UI
				    System.out.print("Please enter the id of a string to remove:\n");
				    inputInfo = stdin.readLine().trim();
				    int id = Integer.parseInt(inputInfo);
				    
				    System.out.print("Please enter the id of a string to remove:\n");
				    inputInfo = stdin.readLine().trim();
				    int quantity = Integer.parseInt(inputInfo);
				    cart.updateQuantity(id, quantity);
		    	}
		    	
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
		        break;
		        
		    case 'F':   // View Menu
		    	menu.getList();
			      break;
			      
		    case 'G':   //6. Get Item Price
			    System.out.print("Please enter the id of an item to find the price of:\n");
			    inputInfo = stdin.readLine().trim();
			    int id = Integer.parseInt(inputInfo);
			    
			    menu.findItem(id);
			    
		      break;
		      
		    case 'H':  //7. View Special Deals
		    	sDeals.getMenuItems();
		        break;
		       
		    case 'I':   //Get Cart Total
		    	if (loggedIn)
		    	{
		    		cart.calcTotal();
		    	}
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
			      break;
			      
		    case 'J':   // Checkout
		    	if (loggedIn)
		    	{
		    		cart.checkOut();
		    	}
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
			      break;
			      
			      
			// admin cases
			      
		    case 'K':	// Add Item to Menu
		    	if (isAdmin)
		    	{
				      System.out.print("Please enter item ID:\n");
					  inputInfo = stdin.readLine().trim();
					  int id = Integer.parseInt(inputInfo);
				      
				      System.out.print("Please enter item name:\n");
				      String name = stdin.readLine().trim();
				      
				      System.out.print("Please enter item price:\n");
				      inputInfo = stdin.readLine().trim();
					  int price = Integer.parseInt(inputInfo);
				      
				      System.out.print("Please enter image for item:\n");
				      String imageLink = stdin.readLine().trim();
				      
				      MenuItem newItem = new MenuItem(id, name, price, 0, imageLink);
				      
				      menu.addItem(newItem);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;
			      
		    case 'L':	//Remove Item from Menu
		    	if (isAdmin)
		    	{
				     System.out.print("Please enter item ID:\n");
				     inputInfo = stdin.readLine().trim();
				     int id = Integer.parseInt(inputInfo);
				     
				     menu.removeItem(id);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;
			      
		    case 'M':	// Add Item to Special Deals
		    	if (isAdmin)
		    	{
				      System.out.print("Please enter item ID:\n");
					  inputInfo = stdin.readLine().trim();
					  int id = Integer.parseInt(inputInfo);
				      
				      System.out.print("Please enter item name:\n");
				      String name = stdin.readLine().trim();
				      
				      System.out.print("Please enter item price:\n");
				      inputInfo = stdin.readLine().trim();
					  int price = Integer.parseInt(inputInfo);
				      
				      System.out.print("Please enter image for item:\n");
				      String imageLink = stdin.readLine().trim();
				      
				      MenuItem newItem = new MenuItem(id, name, price, 0, imageLink);
				      
				      sDeals.addMenuItem(newItem);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;
			      
		    case 'N':	// Remove Item from Special Deals
		    	if (isAdmin)
		    	{
				     System.out.print("Please enter item ID:\n");
				     inputInfo = stdin.readLine().trim();
				     int id = Integer.parseInt(inputInfo);
				     
				     sDeals.removeMenuItem(id);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;

		    case 'Q':   //Quit
		      break;

		    case '?':   //Display Menu
		      printMenu();
		      break;
		    default:
		      System.out.print("Unknown action\n");
		      break;
		   }
		}
		else
		{
		  System.out.print("Unknown action\n");
		 }
		} while (input1 != 'Q' || line.length() != 1);
		}
		catch (IOException exception)
		{
		System.out.print("IO Exception\n");
		}

	}
	
	public static void printMenu()
	{
	System.out.print("Choice\t\tAction\n" +
	             "------\t\t------\n" +
	             "A\t\tLog In\n" +
	             "B\t\tCreate an Account\n" +
	             "C\t\tAdd Item to Cart\n" +
	             "D\t\tRemove Item From Cart\n" +
	             "E\t\tUpdate Quantity\n" +
	             "F\t\tView Menu\n" +
	             "G\t\tGet Item Price\n" +
	             "H\t\tView Special Deals\n" +
	             "I\t\tGet Cart Total\n" +
	             "J\t\tCheckout\n" +
	             "K\t\tAdd Item to Menu\n" +
	             "L\t\tRemove Item from Menu\n" +
	             "M\t\tAdd Item to Special Deals\n" +
	             "N\t\tRemove Item from Special Deals\n" +
	             "Q\t\tQuit\n" +
	             "?\t\tDisplay Help\n\n");
	} //end of printMenu()

}

