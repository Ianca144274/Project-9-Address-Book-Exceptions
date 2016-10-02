package newAddressBook;

public class Contact {
	private String name;
	private String email;
	private String number;
	
	public Contact() {
	}

	public Contact(String name, String email, String number) throws invalidEmailException, invalidPhoneException {
		this.name = name;
		setEmail(email);
		setNumber(number);
		}
	
	public String getName() {
		return this.name;
	}
	
	public String setName(String newName) {
		return (this.name = newName);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String setEmail(String newEmail) throws invalidEmailException {
		if (newEmail.indexOf("@") == -1) {
			throw new invalidEmailException(newEmail);
		} else {
			return (this.email = newEmail);
		}
	}
	
	public String getNumber() {
		return this.number;
	}
	
	 public String setNumber(String newNumber) throws invalidPhoneException {
			if (newNumber.length() != 10) {
				throw new invalidPhoneException(newNumber);
			} else {
				return (this.number = newNumber);
			}
	 }
}

