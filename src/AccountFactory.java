import java.util.ArrayList;

public class AccountFactory {
	
	public static CustomerAccount createAccount(String type, Customer customer, ArrayList<Customer> customerList) {
		
		String number = generateAccountNumber(type, customer, customerList);
		ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		CustomerAccount account = null;
		
		switch (type) {
		
		case "Current Account":
			int randomPIN = (int)(Math.random()*9000)+1000;
	           String pin = String.valueOf(randomPIN);
	    
	           ATMCard atm = new ATMCard(randomPIN, true);
	    	
	    	account = new CustomerCurrentAccount(atm, number, 0, transactionList);
			
 		
		case "Deposit Account":
			account = new CustomerDepositAccount(0, number, 0, transactionList);
		}
		return account;
	}
	
	public static String generateAccountNumber(String type, Customer customer, ArrayList<Customer> customerList) {
		String prefix = "";
		
		switch (type) {
		case "Current Account":
			prefix = "C";
		
		case "Deposit Account":
			prefix = "D";
		}
		
		return prefix + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1);
	}

}
