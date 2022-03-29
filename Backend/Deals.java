import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.util.*;

public class Deals{
	
	private ArrayList<SpecialDeals> deals; // = new ArrayList<SpecialDeals>();

	public Deals(ArrayList<SpecialDeals> deals) {
		// TODO Auto-generated constructor stub
		//super(id, name, price, menuItems, percentage, ImageLink);
		this.deals = new ArrayList<SpecialDeals>();
		
		
		//this.menuList = new ArrayList<MenuItem>();
		
		//read menuItems text file to automatically populate the deals
		//text file is formatted as NewDeal,id,name,price,percentage,imageLink
		//followed by several lines of MenuItems that the deal applies to
		try { 
    		File userList = new File("DealsList.txt");
    		SpecialDeals newDeal = null;
    		
    		Scanner myReader = new Scanner(userList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parse = data.split(",");
                if(parse[0].equals("NewDeal")) {
                	newDeal = new SpecialDeals(Integer.parseInt(parse[1]), parse[2], Float.parseFloat(parse[3]), Integer.parseInt(parse[4]), parse[5]);
                deals.add(newDeal);
                	
                } else {
                	
                	newDeal.getMenuItems().add(new MenuItem(Integer.parseInt(parse[0]), parse[1], Float.parseFloat(parse[2]), Integer.parseInt(parse[3]), parse[4]));
                }
                
                
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
                if (parse[1].equals(Integer.toString(newDeal.getId()))) {
               
                    System.out.println("\nItem already added\n");
                    duplicate = true;
                    //return false;
                }
            }

            myReader.close();

            //begin writing to file if no duplicates
            if(!duplicate) {
                FileWriter myWriter = new FileWriter(userList);
                myWriter.write(newDeal.toString());
                for(int i = 0; i < newDeal.getMenuItems().size(); i++) {
                	
                	myWriter.write(newDeal.getMenuItems().get(i).toString());
                }
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
		this.deals.remove(i);
		
		SpecialDeals temp = null;
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
			}
		}
		
		if (removed) {
			System.out.println("\nItem has been succesfully removed!\n");
		
		}
		else {
			System.out.println("\nItem not found\n");	
			return;
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
    	      String oldInfo = Integer.toString(i) + "," + temp.getName() + "," + Float.toString(temp.getPrice()) + "," + 
    	      Integer.toString(temp.getPercentage()) + "," + temp.getImageLink() + "\n"; //temp.getMenuItems().toString();
    	      for(int o = 0; o < temp.getMenuItems().size(); o++) {
    	    	  
    	    	  oldInfo += temp.getMenuItems().get(o).toString();
    	      }
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
    		} catch(IOException e) {
    			e.printStackTrace();
    			System.out.println("something went wrong :(");
    		}
	}
	
	
	public float findDeal(MenuItem item) {
		ArrayList<Integer> discounts = new ArrayList<Integer>();
		float markoff = 0;
		
		for(int i = 0; i < this.deals.size(); i++) {
			
			for(int o = 0; o < this.deals.get(i).getMenuItems().size(); o++) {
				
				if(this.deals.get(i).getMenuItems().get(o).equals(item)) {
					discounts.add(this.deals.get(i).getPercentage());
				}
			}
		}
		
		markoff = Collections.min(discounts);
		
		return markoff;
	}

}
