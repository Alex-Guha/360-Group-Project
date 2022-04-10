package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	String customerName;
	String address;
	String cardInfo;
	double acctBalance;
	public Cart cart;
	public String Username;
	public boolean isLoggedIn = false;
	public String searchEntry = "";
	//int tracker = 0;
	int purchases;
	//ArrayList<ArrayList<MenuItem>> orderQueue;
	
	public Customer(String customerName, String address, String cardInfo, double acctBalance, Cart cart) {
		this.customerName = customerName;
		this.address = address;
		this.cardInfo = cardInfo;
		this.acctBalance = acctBalance;
		this.cart = cart;
		this.purchases = 0;
		//this.orderQueue = new ArrayList<ArrayList<MenuItem>>();
		//this.orderQueue = new ArrayList<ArrayList<MenuItem>>();

	}
	
	public Customer() {
		this.customerName = "";
		this.address = "";
		this.cardInfo = "";
		this.acctBalance = 0;
		this.cart = new Cart();
		this.purchases = 0;
		//this.orderQueue = new ArrayList<ArrayList<MenuItem>>();
		//this.orderQueue = new ArrayList<ArrayList<MenuItem>>();

	}
	
	public void initialize(String customerName, String address, String cardInfo) {
		this.customerName = customerName;
		this.address = address;
		this.cardInfo = cardInfo;
		this.acctBalance = 0;
		//this.purchases = 0;
		//this.orderQueue = new ArrayList<ArrayList<MenuItem>>();
	}
	
	public void addToCart(MenuItem item) {
		cart.addItem(item);
	}
	
	public void removeFromCart(int id) {
		cart.removeItem(id);
	}
	
	public ArrayList<MenuItem> getOrder(){
		return cart.getCurrentOrder();
	}
	
	public void updateQuantity(int newProductID, int newQuantity) {
		cart.updateQuantity(newProductID, newQuantity);
	}
	
	public int getQuantity() {
		return cart.getQuantity();
	}
	
	public int getPurchaseNumber() {
		return this.purchases;
		
	}
	
	public void checkOut() {
		//System.out.println(this.purchases);
		if(this.purchases >= 3) {
			
			double f = (cart.calcTotal() * 0.9);
			this.purchases = 0;
			System.out.println("\nYou have earned a reward! You will get 10% off on this purchase.");
			System.out.println("\nOrder Completed! Total: $" + f);
		

			
		} else {
		System.out.println("\nOrder Completed! Total: $" + cart.calcTotal());
		
		}
		
		
		
		/*if(orderQueue.size() == 1) {
			
			System.out.println("There is currently 1 order ahead of you. Your expected wait time is 15 minutes.");
		} else {
			System.out.println("There are currently " + orderQueue.size() + " orders ahead of you. Your expected wait time is " + 15*(orderQueue.size() + 1) + " minutes.");
		}
		
		this.orderQueue.add(cart.getCurrentOrder()); */
		this.purchases++; 
	
	}
	
	public boolean register(String userName, String passWord, String email) { 
    	//checks textfile for matching data. If not, adds user data at next available line
    	
        String registeredUser = userName + "," + passWord + "," + email;
        
        
        try {
            File userList = new File(getClass().getResource("UserList.txt").toURI());
            //String[] parseList = new String[];

            //check for duplicates in text file based on username
            boolean duplicate = false;

            Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.isEmpty())
                	continue;
                String[] parse = data.split(",");
                if (parse[0].equals(userName)) {
               
                    System.out.println("Username already taken");
                    duplicate = true;
                    myReader.close();
                    return false;
                }
            }

            myReader.close();

            //begin writing to file if no duplicates
            if(!duplicate) {
                FileWriter myWriter = new FileWriter(userList, true);
                myWriter.write("\n" + registeredUser);
                myWriter.close();
                
                this.Username = userName;
                isLoggedIn = true;
                return true;
            }
            

        } catch (FileNotFoundException e) {
            System.out.println("An error in registering occurred.");
            e.printStackTrace();
            return false;
            
        } catch (Exception e) {
        	System.out.println("A misc error in registering occurred.");
			e.printStackTrace();
			return false;
		}
        
        return false;
    }

    public boolean login(String username, String password) {
    	try {
    		File userList = new File(getClass().getResource("UserList.txt").toURI());
    		
    		Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.isEmpty())
                	continue;
                String[] parse = data.split(",");
                if (parse[0].equals(username)) {
                	if(parse[1].equals(password) ) {
                		this.Username = username;
                        isLoggedIn = true;
                        myReader.close();
                		return true;
                	}
                }
            }

            myReader.close();
            return false;
            
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();
    		return false;
    	} catch(Exception e) {return false;}


    }
    
    public void logOut() {
		try {
			new PrintWriter("userInfo.txt").close();
		} catch (FileNotFoundException e) {}
    }
}
