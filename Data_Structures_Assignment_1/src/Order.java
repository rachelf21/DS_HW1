import java.text.NumberFormat;

public class Order {
	String custID;
	String transNumber;
	String itemName;
	double amount;
	int quantity;
	double total;

	public Order(String id, String trans, String n, double amt, int qty) {
		custID = id;
		transNumber = trans;
		itemName = n;
		amount = amt;
		quantity = qty;
		total = amount * quantity;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getTransNumber() {
		return transNumber;
	}

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotal() {
		return total;
	}	

	@Override
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return "ORDER   [Transaction#: " + transNumber + " | Item: " + itemName + " | Price: "
				+ formatter.format(amount) + " | Quantity: " + quantity + "]";
	}
}
