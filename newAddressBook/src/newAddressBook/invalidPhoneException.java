package newAddressBook;

public class invalidPhoneException extends Exception {
		
		public invalidPhoneException(String message) {
	        super("Invalid phone number: " + message);
	    }	
	}