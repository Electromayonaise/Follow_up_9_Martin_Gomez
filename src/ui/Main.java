package ui;

import java.util.Scanner;
import java.util.Calendar;
import model.Controller;

public class Main{
	/*	
	 * This method is used to avoid writing System.out.println() every time
	 * @param a is the object to be printed 
	 */
	public static void print(Object a) {
		System.out.println(a);
	}

	private static Scanner reader;
	private Controller [] controller;

	public Main() {
		reader = new Scanner(System.in);
		controller = new Controller[10];
	}

	/*	
	 * This method is the main method of the program
	 */

	public static void main(String[] args) {
		Main exe = new Main();
		int option;
		do{
		exe.menu();
		option=reader.nextInt();
		switch(option) {
		case 1:
			exe.RegisterProject();
			break;
		case 2:
			exe.searchProjectsBeforeDate();
			break;
		case 3:
			exe.searchProjectsAfterDate();
			break;
		default: 
			print("Please select a valid option");
			exe.menu();
			break;
		}
		} while(option != 4);

	}

	/*
	 * This method prints the menu of the program
	 */
	public void menu() {
		print("Please select an option");
		print("1. Register a project");
		print("2. Search projects that end before a certain date");
		print("3. Search projects that start after a certain date");
		print("4. Exit");
	}

	/*
	 * This method registers a project
	 */
	public void RegisterProject() {
		int projectCount = 0;
		String answer = "n";
		do{
		print("Please enter the project name");
		String projectName = reader.next();
		print("Please enter the name of the client");
		String clientName = reader.next();
		print("Please enter the type of project");
		String projectType = reader.next();
		print("Please enter the proyect's start year");
		int startYear = reader.nextInt();
		print("Please enter the proyect's start month");
		int startMonth = reader.nextInt();
		print("Please enter the proyect's start day");
		int startDay = reader.nextInt();
		Calendar startDate = Calendar.getInstance();
		startDate.set(startYear, startMonth, startDay);
		print("Please enter the proyect's end year");
		int endYear = reader.nextInt();
		print("Please enter the proyect's end month");
		int endMonth = reader.nextInt();
		print("Please enter the proyect's end day");
		int endDay = reader.nextInt();
		Calendar endDate = Calendar.getInstance();
		endDate.set(endYear, endMonth, endDay);
		print("Please enter the project's budget");
		double budget = reader.nextDouble();
		controller[projectCount] = new Controller(projectName, clientName, projectType, startDate, endDate, budget,projectCount);
		print("Do you want to register another project? (Y/N)");
		answer = reader.next();
		answer=answer.toUpperCase();
		if(answer.equals("Y")) {
			projectCount++;
			} else {
				print("you have registered " + (projectCount+1) + " projects");
				}
			
		} while(projectCount < 10 & answer.equals("Y"));
	}

	/*
	 * This method searches for projects that start after a certain date
	 */
	public void searchProjectsAfterDate() {
		print("Please enter the date AFTER which the proyects you want to search for begin");
		print("Please enter the day");
		int day = reader.nextInt();
		print("Please enter the month");
		int month = reader.nextInt();
		print("Please enter the year");
		int year = reader.nextInt();
		Calendar desiredAfterDate = Calendar.getInstance(); // just to avoid errors
		desiredAfterDate.clear(); // clears the input
		desiredAfterDate.set(year, month, day);
		Controller.searchProjectsAfterDate(desiredAfterDate);
	}
	
	/*
	 * This method searches for projects that end before a certain date
	 */
	public void searchProjectsBeforeDate() {
		print("Please enter the date BEFORE the projects you want to search for end");
		print("Please enter the day");
		int day = reader.nextInt();
		print("Please enter the month");
		int month = reader.nextInt();
		print("Please enter the year");
		int year = reader.nextInt();
		Calendar desiredBeforeDate = Calendar.getInstance(); // just to avoid errors
		desiredBeforeDate.clear(); // clears the input
		desiredBeforeDate.set(year, month, day);
		Controller.searchProjectsBeforeDate(desiredBeforeDate);
	}
}
