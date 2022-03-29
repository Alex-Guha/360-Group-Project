
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char input1;
		String inputInfo = new String();
		int operation2;
		String line = new String();

		//create a linked list to be used in this method.
		LinkedList list1 = new LinkedList();

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
		    case 'A':   //1. Add String
		      System.out.print("Please enter a string to add:\n");
		      String str1 = stdin.readLine().trim();
		      list1.add(str1);
		      break;
		    case 'B':   //2. Count the number of occurrences of a string
		      System.out.print("Please enter a string to count:\n");
		      inputInfo = stdin.readLine().trim();
		      operation2=list1.count(inputInfo);
		      System.out.print("string occurs " + operation2 + " time(s)\n");
		      break;
		    case 'C':   //3. Search for the Index of a String
		      System.out.print("Please enter a string to search:\n");
		      inputInfo = stdin.readLine().trim();
		      operation2=list1.search(inputInfo);
		      if (operation2 > -1)
		        System.out.print("string found at " + operation2 + "\n");
		      else
		        System.out.print("string not found\n");
		      break;
		    case 'D':   //4. remove String at an Index
		      System.out.print("Please enter an index of a string to remove:\n");
		      inputInfo = stdin.readLine().trim();
		      int index = Integer.parseInt(inputInfo);
		      Object removed = list1.remove(index);
		      if(removed != null) {
		          System.out.print("The string " + removed + " was removed\n");
		      }
		      else {
		          System.out.println("The index is out of bounds");
		      }
		      break;
		    case 'E':  // 5. List Current Size
		        System.out.print("The current size is " + list1.size() + "\n");
		        break;
		    case 'L':   //6. List Strings
		      System.out.print(list1.toString());
		      break;
		    case 'F':  //7. Remove last few Strings from End
		        System.out.print("Please enter a number of elements to remove from the end:\n");
		        inputInfo = stdin.readLine().trim();
		        int howManyR = Integer.parseInt(inputInfo);
		        list1.removeLastFew(howManyR);
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
	             "A\t\tAdd String\n" +
	             "B\t\tCount Occurrences\n" +
	             "C\t\tSearch\n" +
	             "D\t\tRemove\n" +
	             "E\t\tSize\n" +
	             "L\t\tList Strings\n" +
	             "F\t\tRemove String\n" +
	             "Q\t\tQuit\n" +
	             "?\t\tDisplay Help\n\n");
	} //end of printMenu()

}
