package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.PersonDaoImplJDBC;
import model.Person;

public class PersonController {
	private static PersonController controller;
	private PersonDaoImplJDBC dao;
	private ArrayList<Person> people;

	private PersonController() {
		dao = new PersonDaoImplJDBC();
	}

	public static PersonController getInstance() {
		if (controller == null) {
			controller = new PersonController();
		}
		return controller;
	}

	public void init() {
		try {
			// connect ddbb
			dao.connect();
			
			// INSERT sample
			// insert 2 people
			//TODO
			
			// SELECT ALL sample
			//get all people
			System.out.println("List of all people:");
			people = dao.getPeople();
			System.out.println(people.toString());

			// SELECT WHERE sample
			// get a specific person by dni
			System.out.println("List of specific person:");
			Person person = dao.getPerson("71111111C");
			System.out.println(person.toString());
			
			
			// UPDATE sample
			// update a specific person by dni
			//TODO
			
			// DELETE sample
			// delete a specific person by dni
			//TODO

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} finally {
			try {
				dao.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
