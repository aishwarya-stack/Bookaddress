package www.bridgelabz.demobook;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Contactdetails {

	private static final Logger LOG = LogManager.getLogger("BookAddress.class");
	Integer[] phoneNumber = new Integer[10];
	String[] Address = new String[10];
	String[] Firstname = new String[10];
	String[] Lastname = new String[10];

	public void getValue(int phonenumber, String address, String firstname, String lastname, int length, int time) {
		int count = 0;

		for (int i = time; i < length; i++) {
			phoneNumber[i] = phonenumber;
			Address[i] = address;
			Firstname[i] = firstname;
			Lastname[i] = lastname;
			// count=count+1;
		}
		LOG.info("phoneNumber" + Arrays.toString(phoneNumber));
		LOG.info("Address" + Arrays.toString(Address));
		LOG.info("Firstname" + Arrays.toString(Firstname));
		LOG.info("Lastname" + Arrays.toString(Lastname));

	}

	public void replace(String name, String newname) {

		boolean result = (Arrays.asList(Firstname).contains(name));
		if (result == true) {
			Firstname[0] = newname;
		}
		// boolean contains = Arrays.stream(Firstname).anyMatch("name"::equals);
		// for(int i=0;i<10;i++)
		// {

		// }
		LOG.info("Firstname" + Arrays.toString(Firstname));

	}

	public void delete(String name) 
	{
		for (int i = 0; i < 10; i++) {
			boolean result = (Arrays.asList(Firstname).contains(name));
			if (result == true) {
				Firstname[i] = null;
				Lastname[i] = null;
				Address[i] = null;
				phoneNumber[i] = null;

				LOG.info("" + i);

			}
		} // boolean contains = Arrays.stream(Firstname).anyMatch("name"::equals);
			// for(int i=0;i<10;i++)
			// {

		// }
		LOG.info("Firstname" + Arrays.toString(Firstname));
		LOG.info("Firstname" + Arrays.toString(Lastname));
		LOG.info("Firstname" + Arrays.toString(Address));
		LOG.info("Firstname" + Arrays.toString(phoneNumber));

	}

}

public class BookAddress extends Contactdetails {
	private static final Logger LOG = LogManager.getLogger("BookAddress.class");
	private static final String NULL = null;

	public static void main(String[] args) {
		LOG.info("Welcome to address Book Program");

		Scanner value = new Scanner(System.in);

		BookAddress contact = new BookAddress();

		// LOG.info("1.ADD 2.REPLACE 3.DELETE");
		// 1LOG.info("enter Your Choice");
		int Check = value.nextInt();
		int choice;
		do {
			LOG.info("1.ADD 2.REPLACE 3.DELETE");
			LOG.info("enter Your Choice");
			Check = value.nextInt();
			switch (Check) {
			case 1:
				LOG.info("enter the number of contact you want to add:");
				int length = value.nextInt();
				for (int i = 0; i < length; i++) {
					LOG.info("enter the phonenumber");
					int phonenumber = value.nextInt();

					LOG.info("enter the address");
					String address = value.nextLine();

					LOG.info("enter the firstname");
					String firstname = value.nextLine();

					LOG.info("enter the lastname");
					String lastname = value.nextLine();

					int time = i;
					contact.getValue(phonenumber, address, firstname, lastname, length, time);
				}
				// contact.getValue(phonenumber,address,firstname,lastname);
				break;

			case 2:
				Scanner sc = new Scanner(System.in);
				LOG.info("enter the name you want to rename");
				String name = sc.nextLine();

				Scanner next = new Scanner(System.in);
				LOG.info("enter the new name");
				String newname = next.nextLine();

				contact.replace(name, newname);

				break;
				
			case 3:
				Scanner cvb=new Scanner(System.in);
				LOG.info("enter the name you want to rename");
				 name=cvb.nextLine();
				
				
				contact.delete(name);
				
				break;

			default:
				// empHr = 0;
				break;

			}
			LOG.info("do you want to continue? 1.yes 2.No");
			choice = value.nextInt();
		} while (choice == 1);

	}
}