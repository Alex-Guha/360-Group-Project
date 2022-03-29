//package Project;

public class Customer extends User// extends User
{
	String customerName;
	String address;
	String cardInfo;
	double acctBalance;
	Cart cart;
	
	public Customer(String customerName, String address, String cardInfo, double acctBalance, Cart cart, String passWord, String email)
	{
		super(false, customerName, passWord, email); //call constructor in User
		
		this.customerName = customerName;
		this.address = address;
		this.cardInfo = cardInfo;
		this.acctBalance = acctBalance;
		this.cart = cart;
	}
	
	public void editCart(String action, int menuPrice)
	{
		// what do i do here again ???
	}
	
	public String viewCartDetails()
	{
		return "The cart containing ... has a total of ...";
	}
	
	public void checkOut()
	{
		// link to order 
	}
}
