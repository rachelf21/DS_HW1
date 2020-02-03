import java.util.ArrayList;

public class Customer {
	String name;
	String custID;
	double prevBalance;
	ArrayList<Order> items;
	ArrayList<Payment> payments;

	public Customer(String id, String n) {
		custID = id;
		name = n;
	}

	public Customer(String id, String n, double balance) {
		custID = id;
		name = n;
		prevBalance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcustID() {
		return custID;
	}

	public void setcustID(String custID) {
		this.custID = custID;
	}

	public double getPrevBalance() {
		return prevBalance;
	}

	public void setPrevBalance(double prevBalance) {
		this.prevBalance = prevBalance;
	}

	public ArrayList<Order> getItems() {
		return items;
	}

	public void setItems(ArrayList<Order> items) {
		this.items = items;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", custID=" + custID + ", prevBalance=" + prevBalance + "]";
	}



}
