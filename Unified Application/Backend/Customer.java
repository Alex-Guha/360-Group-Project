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
	
	public Customer(String customerName, String address, String cardInfo, double acctBalance, Cart cart) {
		this.customerName = customerName;
		this.address = address;
		this.cardInfo = cardInfo;
		this.acctBalance = acctBalance;
		this.cart = cart;
	}
	
	public Customer() {
		this.customerName = "";
		this.address = "";
		this.cardInfo = "";
		this.acctBalance = 0;
		this.cart = new Cart();
	}
	
	public void initialize(String customerName, String address, String cardInfo) {
		this.customerName = customerName;
		this.address = address;
		this.cardInfo = cardInfo;
		this.acctBalance = 0;
	}
	
	public void addToCart(MenuItem item) {
		cart.addItem(item);
	}
	
	public void removeFromCart(MenuItem item) {
		cart.removeItem(item.getId());
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
	
	public void checkOut() {
		System.out.println("Order Completed! Total: $" + cart.calcTotal());
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
