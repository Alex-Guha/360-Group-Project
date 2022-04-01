import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {
    //class variables
	
	
    private boolean isAdmin;
    private boolean loggedIn;
    private String userName;
    private String passWord;
    private String email;
    
    
    
    //constructor
    public User(boolean isAdmin, String userName, String passWord, String email) {
    	this.isAdmin = isAdmin;
    	this.loggedIn = false;
    	this.userName = userName;
    	this.passWord = passWord;
    	this.email = email;
    	
    }
    
    public User(String userName, String passWord, String email) {
    	this.isAdmin = false;
    	this.loggedIn = false;
    	this.userName = userName;
    	this.passWord = passWord;
    	this.email = email;
    }
    
    public User() {
    	this.isAdmin = false;
    	this.loggedIn = false;
    	this.userName = "";
    	this.passWord = "";
    	this.email = "";
    	
    }
	// removed constructor (JENNA)
    //replace constructor and made 2 more lol (ZACK)

    //class methods
    
    
    //accesssors
    public boolean getIsAdmin() {
    	
    	return this.isAdmin;
    } 
    
    public String getUserName() {
    	
    	return this.userName;
    }
    
    public String getPassword() {
    	return this.passWord;
    }
    
    public String getEmail() {
    	
    	return this.email;
    }
    
    public boolean getLoggedIn() {
    	
    	return this.loggedIn;
    }
    
    
    //setter methods for whatever reason
    public void setIsAdmin(boolean isAdmin) {
    	this.isAdmin = isAdmin;
    	
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    
    public void setPassWord(String passWord) {
    	this.passWord = passWord;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    
    //meat and potatoes of the class, the REAL class methods
    
  //isAdmin,username,password,email
    public boolean register(boolean isAdmin, String userName, String passWord, String email) { 
    	//checks textfile for matching data. If not, adds user data at next available line
    	
        String registeredUser = Boolean.toString(isAdmin) + ","  + userName + "," + passWord + "," + email;
        
        
        try {
            File userList = new File("UserList.txt");
            //String[] parseList = new String[];

            //check for duplicates in text file based on username
            boolean duplicate = false;

            Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
                if (parse[1].equals(userName)) {
               
                    System.out.println("Username already taken");
                    duplicate = true;
                    return false;
                }
            }

            myReader.close();

            //begin writing to file if no duplicates
            if(!duplicate) {
                FileWriter myWriter = new FileWriter(userList, true);
                myWriter.write(registeredUser + "\n");
                myWriter.close();
            }
            

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
            
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	System.out.println("An error occurred.");
			e.printStackTrace();
		}
        
        return true;
    }

    public boolean login(String username, String password) {
    	//checks if username and password match that of the textfile. If so, change the loggedIn 
    	//boolean to true for this user object
    	try {
    		File userList = new File("UserList.txt");
    		
    		Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
                if (parse[1].equals(username)) {
                	if(parse[2].equals(password) ) {
                		if(Boolean.parseBoolean(parse[0])) {
                			this.isAdmin = true;
                		}
                		this.loggedIn = true;
                		return true;
                	}
                    
                }
            }

            myReader.close();
            System.out.println("Credentials do not match. Please try again.");
            return false;
            
    	} catch(FileNotFoundException e) {
    		e.printStackTrace();
    		return false;
    	}


    }
    
    public void updateProfile(String username, String password, String email) {
    	//similar to the remove methods in Deals and Menu, this replaces instances of old, incorrect data with updated data 
    	if(this.loggedIn == true) {
    		try {
    		//Instantiating the File class
    	      //String filePath = "D://input.txt";
    	      //Instantiating the Scanner class to read the file
    	      Scanner scan = new Scanner(new File("UserList.txt"));
    	      //instantiating the StringBuffer class
    	      StringBuffer buffer = new StringBuffer();
    	      //Reading lines of the file and appending them to StringBuffer
    	      while (scan.hasNextLine()) {
    	         buffer.append(scan.nextLine()+System.lineSeparator());
    	      }
    	      String fileContents = buffer.toString();
    	      //System.out.println("Contents of the file: "+fileContents);
    	      //closing the Scanner object
    	      scan.close();
    	      String oldInfo = Boolean.toString(this.isAdmin) + ","  + this.userName + "," + this.passWord + "," + this.email;
    	      String newLine = Boolean.toString(isAdmin) + ","  + username + "," + password + "," + email;
    	      //Replacing the old line with new line
    	      fileContents = fileContents.replaceAll(oldInfo, newLine);
    	      //instantiating the FileWriter class
    	      FileWriter writer = new FileWriter("UserList.txt");
    	      //System.out.println("");
    	      //System.out.println("new data: "+fileContents);
    	      writer.append(fileContents);
    	      writer.flush();
    	      writer.close();
    		} catch(IOException e) {
    			e.printStackTrace();
    			System.out.println("something went wrong :(");
    		}
    	}
    	
    	
    }
    
    public void logOut() {
    	
    	this.loggedIn = false;
    }
    
    
}
