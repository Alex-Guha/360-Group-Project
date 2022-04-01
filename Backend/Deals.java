import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.util.*;

public class Deals{
	
	private ArrayList<SpecialDeals> deals; // = new ArrayList<SpecialDeals>();

	public Deals() {
		// TODO Auto-generated constructor stub
		//super(id, name, price, menuItems, percentage, ImageLink);
		this.deals = new ArrayList<SpecialDeals>();
		
		
		//this.menuList = new ArrayList<MenuItem>();
		
		//read menuItems text file to automatically populate the deals
		//text file is formatted as NewDeal,id,name,price,percentage,imageLink
		//followed by several lines of MenuItems that the deal applies to
		try { 
    		File userList = new File("DealsList.txt");
    		//SpecialDeals newDeal = null;
    		
    		Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
              
                SpecialDeals newDeal = new SpecialDeals(Integer.parseInt(parse[0]), parse[1], Float.parseFloat(parse[2]), Integer.parseInt(parse[3]), Integer.parseInt(parse[4]), parse[5]);
                deals.add(newDeal);
                	
               
                
                
            }

            myReader.close();
           
    	} catch(FileNotFoundException e) { //in case we mess up and there is no file
    		e.printStackTrace();
    	}
	}
	
	public ArrayList<SpecialDeals> getList() {
		return this.deals;
		
		
	}
	
	public void addItem(SpecialDeals newDeal) {
		this.deals.add(newDeal);
		
		//add new item to textfile too
		try {
            File userList = new File("DealsList.txt");
            //String[] parseList = new String[];

            //check for duplicates in text file based on username
            boolean duplicate = false;

            Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
                if (parse[0].equals(Integer.toString(newDeal.getId()))) {
               
                    System.out.println("\nItem already added\n");
                    duplicate = true;
                    return;
                    //return false;
                }
            }

            myReader.close();

            //begin writing to file if no duplicates
            if(!duplicate) {
                FileWriter myWriter = new FileWriter(userList, true);
                myWriter.write(newDeal.toString());
                
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
		
		System.out.println("\nItem has been succesfully added!\n");
	}
	
	
	public void removeItem(int i) {
		//this.deals.remove(deals.indexOf(this.getbyID(i)));
		
		SpecialDeals temp = this.getbyID(i);
		boolean removed = false;
		ListIterator<SpecialDeals> iterator = deals.listIterator();
		
		while(iterator.hasNext())
		{
			SpecialDeals item = iterator.next();
			if (item.getId() == i)
			{
				temp = item;
				deals.remove(item);
				removed = true;
				break;
			}
		}
		
		
		
		
		try {
    		//Instantiating the File class
    	      //String filePath = "D://input.txt";
    	      //Instantiating the Scanner class to read the file
    	      Scanner scan = new Scanner(new File("DealsList.txt"));
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
    	      String oldInfo = Integer.toString(temp.getId()) + "," + temp.getName() + "," + Float.toString(temp.getPrice()) + "," + Integer.toString(temp.getQuantity()) + 
    					"," + Integer.toString(temp.getPercentage()) + "," + temp.getImageLink() + "\n"; // + menuItems.toString() 
    			 //temp.getMenuItems().toString();
    	      
    	      String newLine = "";
    	      //Replacing the old line with new line
    	      fileContents = fileContents.replaceAll(oldInfo, newLine);
    	      //instantiating the FileWriter class
    	      FileWriter writer = new FileWriter("DealsList.txt");
    	      //System.out.println("");
    	      //System.out.println("new data: "+fileContents);
    	      writer.append(fileContents);
    	      writer.flush();
    	      writer.close();
    	      
    	      
    	      if (removed) {
    				System.out.println("\nItem has been succesfully removed!\n");
    			
    			}
    			else {
    				System.out.println("\nItem not found\n");	
    				return;
    			}
    	      
    	      
    	      
    		} catch(IOException e) {
    			e.printStackTrace();
    			System.out.println("something went wrong :(");
    		}
	}
	
	/*
	public float findDeal(MenuItem item) {
		ArrayList<Integer> discounts = new ArrayList<Integer>();
		float markoff = 1;
		
		for(int i = 0; i < this.deals.size(); i++) {
			
			for(int o = 0; o < this.deals.get(i).getMenuItems().size(); o++) {
				
				if(this.deals.get(i).getMenuItems().get(o).equals(item)) {
					discounts.add(this.deals.get(i).getPercentage());
				}
			}
		}
		
		if(discounts.size() > 0) {
			markoff = Collections.min(discounts);

			
		}
		
		return markoff;
	}*/
	public SpecialDeals getbyID(int id) {
		//SpecialDeals result = null;
		
		for(int i = 0; i < deals.size(); i++) {
			
			//System.out.println(deals.get(i).getId());
			//System.out.println(id);

			
			if(this.deals.get(i).getId() == id) {
				//System.out.print("hi");
				return this.deals.get(i);
				
			}
		}
		
		return null;
		
	}
	
	public String displayDeals() {
		String result = "";
		for(int i = 0; i < deals.size(); i ++) {
			
			result += deals.get(i).toString() + "\n";
		}
		return result;
		
	}

}
