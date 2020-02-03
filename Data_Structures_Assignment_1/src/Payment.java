import java.text.NumberFormat;

public class Payment {
	String custID;
	String transNumber;
	double amount;

	public Payment(String id, String trans, double amt) {
		custID = id;
		transNumber = trans;
		amount = amt;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return "PAYMENT [Transaction#: " + transNumber + " | Amount: " + formatter.format(amount) + "]";
	}

}
