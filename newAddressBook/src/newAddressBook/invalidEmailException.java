package newAddressBook;

public class invalidEmailException extends Exception {
		
		public invalidEmailException(String message) {
	        super("Invalid email address: " + message);
	    }	
	}