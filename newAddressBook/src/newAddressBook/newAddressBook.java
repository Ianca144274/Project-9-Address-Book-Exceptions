package newAddressBook;

import java.util.Scanner;
import java.util.ArrayList;

public class newAddressBook {

	static ArrayList<Contact> addressBook = new ArrayList<Contact>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Please select an option 1-5 from the menu below:");
			System.out.println("1. Add new contact");
			System.out.println("2. Edit existing contact");
			System.out.println("3. Delete existing contact");
			System.out.println("4. Print all contact details (Show All)");
			System.out.println("5. Quit");

			int menuChoice = s.nextInt();
			s.nextLine();

			switch (menuChoice) {
			case 1:
				addContact(s);
				break;
			case 2:
				editContact(s);
				break;
			case 3:
				deleteContact(s);
				break;
			case 4:
				// System.out.println(addressBook.toString());
				printAddressBook();
				break;
			case 5:
				System.out.println("Thank you, bye-bye!");
				System.exit(0);
				break;
			}
		}
	}

	public static void addContact(Scanner s) {
		int choice = 0;
		System.out.println("To add a contact please enter the following details: name, email & number:");
		while (choice < 2) {
			System.out.println("Enter name");
			String name = s.nextLine();
			System.out.println("Enter email");
			String email = s.nextLine();
			System.out.println("Enter number");
			String number = s.nextLine();
			
			try {
				Contact c = new Contact(name, email, number);
				addressBook.add(c);
			} catch (invalidEmailException e) {
				System.out.println(e.getMessage());
				addContact(s);
			} catch (invalidPhoneException e) {
				System.out.println(e.getMessage());
				addContact(s);
			}
			
			System.out.println("Would you like to add another contact?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = s.nextInt();
			s.nextLine();
		}
	}

	public static void printAddressBook() {
		int i = 1;
		for (Contact c : addressBook) {
			System.out.println(i + ". " + c.getName() + ", " + c.getEmail() + ", " + c.getNumber());
			i++;
		}
	}
	
	public static int getIndex(Scanner s) {
		int choice = 0;
		System.out.println("Please select a contact from the list:");
		printAddressBook();
		choice = s.nextInt();
		s.nextLine();
		return (choice - 1);
	}

	public static void editContact(Scanner s) {
		int index = getIndex(s);
		Contact c = addressBook.get(index);
		System.out.println("You may edit name, email or number:");
		int one = 1;

		while (one == 1) {
			System.out.println("What would you like to do?");
			System.out.println("1. Edit name");
			System.out.println("2. Edit email");
			System.out.println("3. Edit number");
			int editOptions = s.nextInt();
			s.nextLine();

			if (editOptions == 1) {
				System.out.println("Please set value of new name");
				String newName = s.nextLine();
				c.setName(newName);
			} else if (editOptions == 2) {
				System.out.println("Please set value of new email");
				String newEmail = s.nextLine();
				try {
					c.setEmail(newEmail);
				} catch (invalidEmailException e) {
					System.out.println(e.getMessage());
				}

			} else if (editOptions == 3) {
				System.out.println("Please set value of new number");
				String newNumber = s.nextLine();
				try {
					c.setNumber(newNumber);
				} catch (invalidPhoneException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("Please selection options 1, 2 or 3");
			}

			System.out.println("Would you like to edit another contact?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			one = s.nextInt();
			if (one == 2) {
				break;
			} else {
				editContact(s);
			}

		}
	}

	public static void deleteContact(Scanner s) {
		int choice = 1;

		while (choice == 1) {
			int index = getIndex(s);
			Contact c = addressBook.get(index);
			System.out.println("Are you sure you want to delete " + c.getName() + " ?");

			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = s.nextInt();
			s.nextLine();

			if (choice == 1) {
				addressBook.remove(index);
			} else if (choice == 2) {
				break;
			} else {
				System.out.println("Please select 1 or 2");
			}
			System.out.println("Would you like to Delete another name?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			choice = s.nextInt();
			if (choice == 2) {
				break;
			}
		}
	}
}