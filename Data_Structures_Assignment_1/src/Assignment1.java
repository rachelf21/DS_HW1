import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Assignment1 {
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	HashMap<String, Customer> hmap = new HashMap<String, Customer>();
	ArrayList<Order> orders = new ArrayList<Order>();
	ArrayList<Payment> payments = new ArrayList<Payment>();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Assignment1 a = new Assignment1();
		a.readMasterFile();
		a.readTransactionFile();
		a.printBalances();
	}// main

//********************* PRINT BALANCES FOR ALL CUSTOMERS **********************************//
	public void printBalances() {
		String custID = "";
		String companyName = "";
		double prevBalance = 0;
		double orderTotal = orders.get(0).getTotal();
		double paymentTotal = 0;

		for (int i = 0; i < orders.size() - 1; i++) {
			Order current = orders.get(i);
			Order next = orders.get(i + 1);
			custID = current.getCustID();

			try {
				Customer c = hmap.get(custID);
				prevBalance = c.getPrevBalance();
				companyName = c.getName();
				paymentTotal = 0;
				if (current.getCustID().equals(next.getCustID())) {
					orderTotal += next.getTotal();
				} else {
					System.out.println("\n\nName: " + companyName + "\tID: " + current.getCustID());
					System.out.println("Previous Balance: " + formatter.format(prevBalance));
					for (Order o : orders) {
						if (o.getCustID().equals(current.getCustID()))
							System.out.println(o);
					}
					for (Payment p : payments) {
						if (p.getCustID().equals(current.getCustID())) {
							paymentTotal += p.getAmount();
							System.out.println(p);
						}
					}
					System.out.println("Balance Now Due: " + formatter.format(orderTotal + prevBalance - paymentTotal));
					System.out.println("\n");
					orderTotal = next.getTotal(); // starting new balance for next customer
				}
			} catch (NullPointerException e) {
				System.out.println("\n\nThis customer ID does not exist in the Master file.");
				orderTotal = next.getTotal();
			}
		}
	}

//********************* READ TRANSACTION FILE  **********************************//
// Create an ArrayList of Orders and an ArrayList of Payments

	public void readTransactionFile() {
		String line;
		String[] token;

		try {
			File transactionFile = new File(
					"C:\\Users\\Rachel\\Dropbox\\College\\Brooklyn College\\Data Structures\\Assignment1\\transactions.csv");
			Scanner transactions = new Scanner(transactionFile);

			while (transactions.hasNextLine()) {
				line = transactions.nextLine();
				line = line.replace("\"", "");
				token = line.split(",");
				if (token[1].equals("O")) {
					Order o = new Order(token[0], token[2], token[3], Double.parseDouble(token[4]),
							Integer.parseInt(token[5].trim()));
					orders.add(o);
				} else if (token[1].equals("P")) {
					Payment p = new Payment(token[0], token[2], Double.parseDouble(token[6]));
					payments.add(p);
				}
			}

//			for (Order o : orders) 
//				System.out.println(o);
			System.out.println("Orders added: " + orders.size());

//			for (Payment p : payments)
//				System.out.println(p);
			System.out.println("Payments added: " + payments.size());

			transactions.close();
		} // try

		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NumberFormatException e) {
			System.out.println("Transaction File Error: Not a valid number");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("An errror has occurred.");
			System.out.println("Transaction file: " + e.getMessage());
		}
	}

//********************* READ MASTER FILE  **********************************//
// Create a HashMap of Customers using ID as the key and a Customer object as the value
// See Customer class for details of Customer object

	public void readMasterFile() {
		String line;
		String[] token;

		try {
			File masterFile = new File(
					"C:\\Users\\Rachel\\Dropbox\\College\\Brooklyn College\\Data Structures\\Assignment1\\master.csv");
			Scanner master = new Scanner(masterFile);

			while (master.hasNextLine()) {
				line = master.nextLine();
				line = line.replace("\"", "");
				token = line.split(",");
				Customer c = new Customer(token[0], token[1], Double.parseDouble(token[2]));
				hmap.put(token[0], c);
			}

//			Set<String>keys=hmap.keySet();
//			for (String s: keys)
//				System.out.println(hmap.get(s));
			System.out.println("Customers added: " + hmap.size());

			master.close();
		} // try

		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number");
			System.out.println("Master file error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An errror has occurred.");
			System.out.println("Master file: " + e.getMessage());
		}
	}
}// Assignment1
