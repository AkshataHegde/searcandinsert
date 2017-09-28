package com.akshata.annotations2;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) throws IOException {

		while (true) {

			Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

			Transaction t = session.beginTransaction();

			/*
			 * ContactDetails contact = new ContactDetails();
			 * 
			 * contact.setName("Divya"); contact.setContactNumber("123456789");
			 * 
			 * session.persist(contact); t.commit();
			 */

			System.out.println("Enter your choice");
			System.out.println("Press i to insert name");
			System.out.println("Press s to search name");

			Scanner reader = new Scanner(System.in);
			// String option = reader.nextLine();

			char c = (char) System.in.read();

			if (c == 'i') {

				ContactDetails contact = new ContactDetails();

				System.out.println("Enter the phone number");
				int phonenumber = reader.nextInt();
				contact.setContactNumber(phonenumber);

				System.out.println("Enter the name");

				Scanner scanner = new Scanner(System.in);
				String contactname = scanner.nextLine();

				// String contactname = reader.nextLine();
				contact.setName(contactname);

				session.persist(contact);

				session.persist(contact);
				t.commit();

				System.out.println("successfully inserted!!");

				System.out.println("Do you want to continue yes/quit!!");

				Scanner scan = new Scanner(System.in);

				String input = scan.next();

				if (input.equals("quit")) {

					System.out.println("THANK YOU.....BYE....!!");
					System.exit(0);
				}

				else if (input.equals("yes")) {
					continue;
				} else {
					System.out.println("You have not entered valid option....Bye");
					System.exit(0);
				}

			}

			else if (c == 's') {
				// Scanner reader = new Scanner(System.in);

				Scanner scanInput = new Scanner(System.in);
				System.out.println("Enter the name to be searched");
				// String search= scanInput.nextLine();
				String search = scanInput.next();
				List contacts = session
						.createQuery(" FROM com.akshata.annotations2.ContactDetails where name like '" + search + "%'")
						.list();
				System.out.println(contacts.size());
				for (Iterator iterator = contacts.iterator(); iterator.hasNext();) {
					System.out.println();
					ContactDetails search_name = (ContactDetails) iterator.next();

					String searchedname = search_name.getName();

					// System.out.println(search_name.getName());
					// System.out.println(search_name.getContactNumber());
					if (searchedname != null && !searchedname.isEmpty()) {
						System.out.println(search_name.getName());
						System.out.println(search_name.getContactNumber());

					} else {
						System.out.println("name not found!!!");
					}
				}

				System.out.println("Do you want to continue yes/quit!!");

				Scanner scan = new Scanner(System.in);

				String input = scan.next();

				if (input.equals("quit")) {

					System.out.println("THANK YOU.....BYE....!!");
					System.exit(0);
				}

				else if (input.equals("yes")) {
					continue;
				} else {
					System.out.println("You have not entered valid option.....Bye");
					System.exit(0);
				}

			}
			session.close();

		}

		/*
		 * System.out.println("Enter the name"); Scanner reader = new
		 * Scanner(System.in); String search = reader.nextLine();
		 * 
		 * List contacts = session
		 * .createQuery(" FROM com.akshata.annotations2.ContactDetails where name like '"
		 * + search + "%'").list(); for (Iterator iterator = contacts.iterator();
		 * iterator.hasNext();) { System.out.println(); ContactDetails search_name =
		 * (ContactDetails) iterator.next(); System.out.println(search_name.getName());
		 * System.out.println(search_name.getContactNumber());
		 */

	}

}
