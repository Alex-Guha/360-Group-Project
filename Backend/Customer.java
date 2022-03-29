//package Project;

public class Customer extends User// extends User
{
	String customerName;
	String address;
	String cardInfo;
	double acctBalance;
	Cart cart;
	Menu menu;
	
	public Customer(String customerName, String address, String cardInfo, double acctBalance, Cart cart, String passWord, String email)
	{
		super(false, customerName, passWord, email); //call constructor in User
		
		this.customerName = customerName;
		this.address = address;
		this.cardInfo = cardInfo;
		this.acctBalance = acctBalance;
		this.cart = cart;
		menu = new Menu();
	}
	
	public void addToCart(MenuItem item)
	{
		// what do i do here again ???
		cart.addItem(item);
		
	}
	
	public void removeItemCart(MenuItem item) {
		
		cart.removeItem(item.getId());
	}
	
	public String viewCartDetails()
	{
		return "The cart containing " + menu.getList().toString() + " has a total of " + Float.toString(cart.calculateTotal()) + "\n";
	}
	
	public void checkOut()
	{
		// link to order 
	}
}
