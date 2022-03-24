package Project;

public class MenuItem
{
	private int id;
	private String name;
	private float price;
	private int quantity;
	private String imageLink;
	
	public MenuItem(int id, String name, float price, int quantity, String imageLink) {
		// TODO Auto-generated constructor stub
		//super(ArrayList<MenuItem> menuItems);
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imageLink = imageLink;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public String getName()
	{
		return name;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public int getId()
	{
		return id;
	}

}
