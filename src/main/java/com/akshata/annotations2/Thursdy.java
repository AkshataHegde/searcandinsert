package com.akshata.annotations2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Thursdy {

	public static void main(String[] args) {
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();

		ContactDetails contact = new ContactDetails();

		contact.setName("Divya");
		contact.setContactNumber(123456789);

		session.persist(contact);
		t.commit();
		
		System.out.println("Enter the name");
		Scanner reader = new Scanner(System.in);
		String search = reader.nextLine();

		List contacts = session
				.createQuery(" FROM com.akshata.annotations2.ContactDetails where name like '" + search + "%'").list();
		for (Iterator iterator = contacts.iterator(); iterator.hasNext();) {
			System.out.println();
			ContactDetails search_name = (ContactDetails) iterator.next();
			System.out.println(search_name.getName());
			System.out.println(search_name.getContactNumber());
			
			
		}
		session.close();
	}
}