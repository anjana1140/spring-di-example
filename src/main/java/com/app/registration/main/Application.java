package com.app.registration.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.registration.dao.StudentPersistDaoImpl;
import com.app.registration.model.Student;
import com.app.registration.service.StudentRegistrationService;
import com.app.registration.service.StudentRegistrationServiceImpl;
import com.app.registration.util.JdbcClient;

public class Application {

	private StudentRegistrationService studentRegistrationService;

	private Scanner sc;

	public Application() {	

		studentRegistrationService = new StudentRegistrationServiceImpl();
		sc = new Scanner(System.in);

	}

	public static void main(String[] args) throws SQLException {	
		

		Application app = new Application();

		app.greeting();

		app.startApplication();

	}

	public void greeting() {
		System.out.println("Welcome to Student Registration");
	}

	public void startApplication() throws SQLException {

		int opCode = 0;
		while (opCode != 7) {
			System.out.println("List of Operations: ");
			System.out.println("1. Register a new Student");
			System.out.println("2. Update a Student");
			System.out.println("3. Retrieve a Student");
			System.out.println("4. Remove a Student");
			System.out.println("5. Display all Students");
			System.out.println("6. Remove all Students");
			System.out.println("7. Exit Application");
			System.out.print("Select a operation: ");
			opCode = sc.nextInt();

			switch (opCode) {

			case 1:
				this.register();
				break;

			case 2:
				
				this.update();
				break;

			case 3:
				this.display();
				break;

			case 4:
				System.out.println("Remove  is under construction");
				break;

			case 5:
				System.out.println("View All :");
				List<Student> stuList=studentRegistrationService.retriveAll();
				stuList.forEach(s -> System.out.println(s));
				break;

			case 6:
				System.out.println("Delete All is under construction");
				break;

			case 7:
				System.out.println("Exiting the application");
				System.exit(0);
			default:
				System.out.println("incorrect Operation code");

			}
		}

	}

	public void register() {
		System.out.println("Provide Input for Registration");
		System.out.print("Name: ");
		String studentName = sc.next();
		System.out.println();

		System.out.print("Standard:");
		String standard = sc.next();
		System.out.println();

		System.out.print("Section:");
		String section = sc.next();
		System.out.println();

		System.out.print("School:");
		String school = sc.next();
		System.out.println();

		System.out.print("City:");
		String city = sc.next();
		System.out.println();

		System.out.print("Pincode: ");
		int pincode = sc.nextInt();
		System.out.println();

		String id = studentRegistrationService.registerStudent(studentName, standard, section, school, city, pincode);

		System.out.println("Registration is done. ID: " + id);
	}
	
	
	public void update() {
		
		System.out.println("Provide Input for Updation");
		
		
		System.out.print("ID ");
		String studentId = sc.next();
		System.out.println();
		
		if(studentRegistrationService.retrive(studentId.trim()) == null) {
			System.out.println("Your ID: "+studentId);
			throw new NullPointerException("No Record exists for this id ");
			
		}
 
		System.out.print("Name: ");
		String studentName = sc.next();
		System.out.println();

		System.out.print("Standard:");
		String standard = sc.next();
		System.out.println();

		System.out.print("Section:");
		String section = sc.next();
		System.out.println();

		System.out.print("School:");
		String school = sc.next();
		System.out.println();

		System.out.print("City:");
		String city = sc.next();
		System.out.println();

		System.out.print("Pincode: ");
		int pincode = sc.nextInt();
		System.out.println();
		
		
		
		studentRegistrationService.update( studentId,studentName, standard, section, school, city, pincode);
		
		System.out.println("Update is done.");
	}
	
	public void display() {
		System.out.print("Enter Student ID: ");
		String id = sc.next();
		System.out.println();
		System.out.println(studentRegistrationService.retrive(id));	
	}

}
