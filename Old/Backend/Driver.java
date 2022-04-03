//package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;


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
	    //SpecialDeals sDeals =new SpecialDeals(2, "Grug Goop Celebration", 11.11F, 90, "", 30);
	   //ArrayList<SpecialDeals> dealsList = new ArrayList<SpecialDeals>();
	    Deals deals = new Deals();
	    //deals.addItem(sDeals);
	    User user = new User();
	    Cart cart = new Cart(2, 123);
	    Menu menu = new Menu();
	    
	    MenuItem water = new MenuItem(0, "Water", 0.00f, 1, "");
	    
	    //SpecialDeals sDeals = new SpecialDeals();
	    
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
		    	if (user.getLoggedIn())
		    	{
		    		System.out.print("Already logged in, please log out if a new user.\n");
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
		    	if (user.getLoggedIn())
		    	{
		    		System.out.print("Already logged in, please log out if a new user.\n");
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
			      try {
			    	   inputInfo = stdin.readLine().trim();
					  int adminCode = Integer.parseInt(inputInfo);
				      
					  // set admin code so admins making accounts can be verified
				      if (adminCode == 1111) // example code is '1111'
				      {
				    	  isAdmin = true;
				      } else {
				    	  isAdmin = false;
				      }
				      
				      loggedIn = user.register(isAdmin, username, password, email);
			    	  
			      } catch(NumberFormatException e) {
			    	  System.out.println("Code not valid, registering as Customer\n");
			    	  isAdmin = false;
			    	  loggedIn = user.register(isAdmin, username, password, email);
			    	  
			      }
				 
		    	}
		      break;
		      
		    case 'C':   //3. Add Item to Cart
		    	if (user.getLoggedIn())
		    	{
		    		// user clicks button to "add item" in the UI
		    		//cart.addItem(water); // TEST      DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
		    		System.out.print("Please enter the id of a food to add\n");
				    inputInfo = stdin.readLine().trim();
				    int id = Integer.parseInt(inputInfo);
				    MenuItem temp = menu.findItem(id);
				    
				    if(temp != null) {
				    	cart.addItem(temp);
			    		System.out.println(cart.toString());
				    	
				    	
				    }
				    
				    
		    	}
		    	
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
		      break;
		    case 'D':   //4. Remove Item From Cart
		    	if (user.getLoggedIn())
		    	{
		    		// user clicks button to "remove item" in the UI
				    System.out.print("Please enter the id of a string to remove:\n");
				    inputInfo = stdin.readLine().trim();
				    int id = Integer.parseInt(inputInfo);
				    cart.removeItem(id);
		    		System.out.println(cart.toString());

		    	}
		    	
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
		      break;
		      
		    case 'E':  // 5. Update Quantity
		    	if (user.getLoggedIn())
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
		    	System.out.println(menu.toString());
			      break;
			      
		    case 'G':   //6. Get Item Price
			    System.out.print("Please enter the id of an item to find the price of:\n");
			    inputInfo = stdin.readLine().trim();
			    int id = Integer.parseInt(inputInfo);
			    
			    System.out.println(Integer.toString(menu.findItem(id).getId()));
			    
		      break;
		      
		    case 'H':  //7. View Special Deals
		    	System.out.println(deals.displayDeals());
		        break;
		       
		    case 'I':   //Get Cart Total
		    	if (user.getLoggedIn())
		    	{
		    		System.out.println(Float.toString(cart.calcTotal()));
		    	}
		    	else
		    	{
		    		System.out.print("Please log in or sign up first\n");
		    	}
			      break;
			      
		    case 'J':   // Checkout
		    	if (user.getLoggedIn())
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
		    	if (user.getIsAdmin())
		    	{
				      System.out.print("Please enter item ID:\n");
					  inputInfo = stdin.readLine().trim();
					  id = Integer.parseInt(inputInfo);
				      
				      System.out.print("Please enter item name:\n");
				      String name = stdin.readLine().trim();
				      
				      System.out.print("Please enter item price:\n");
				      inputInfo = stdin.readLine().trim();
					  float price = Float.parseFloat(inputInfo);
				      
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
		    	if (user.getIsAdmin())
		    	{
				     System.out.print("Please enter item ID:\n");
				     inputInfo = stdin.readLine().trim();
				     id = Integer.parseInt(inputInfo);
				     
				     menu.removeItem(id);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;
			      
		    case 'M':	// Add Item to Special Deals
		    	if (user.getIsAdmin())
		    	{
				      System.out.print("Please enter Item ID:\n");
					  inputInfo = stdin.readLine().trim();
					  id = Integer.parseInt(inputInfo);
				      
				      System.out.print("Please enter item name:\n");
				      String name = stdin.readLine().trim();
				      
				      System.out.print("Please enter item price:\n");
				      inputInfo = stdin.readLine().trim();
					  float price = Float.parseFloat(inputInfo);
				      
				      System.out.print("Please enter image for item:\n");
				      String imageLink = stdin.readLine().trim();
				      
				      System.out.print("Please enter Discount pergentage (percent that gets knocked off):\n");
					  inputInfo = stdin.readLine().trim();
					  int discount = Integer.parseInt(inputInfo);
				      
				     SpecialDeals newDeal = new SpecialDeals(id, name, price, 1, discount, imageLink);
				      
				      deals.addItem(newDeal);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;
			      
		    case 'N':	// Remove Item from Special Deals
		    	if (user.getIsAdmin())
		    	{
				     System.out.print("Please enter item ID:\n");
				     inputInfo = stdin.readLine().trim();
				     id = Integer.parseInt(inputInfo);
				     
				     
				     deals.removeItem(id);
		    	}
		    	else
		    	{
		    		System.out.print("You do not have access to this action\n");
		    	}
			      break;
			      
		    case 'Z':
		    	if(user.getLoggedIn()) {
		    		user.logOut();
		    		System.out.println("Successfully Logged out\n");
		    	} else {
		    		
		    		System.out.println("Not logged in\n");

		    	}
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
	             "Z\t\tLog Out\n" + 
	             "Q\t\tQuit\n" +
	             "?\t\tDisplay Help\n\n");
	} //end of printMenu()

}

