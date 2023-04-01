package model;

import java.util.Calendar;

public class Controller {

	private static Project[] projects= new Project[10];
	/*
	 * This method is the constructor of the class Controller
	 * @param projectName is the name of the project
	 * @param clientName is the name of the client
	 * @param projectType is the type of the project
	 * @param startDate is the initial date of the project
	 * @param endDate is the final date of the project
	 * @param budget is the total budget of the project
	 * @param projectCount is the number of projects
	 */
	public Controller(String projectName, String clientName, String projectType, Calendar startDate, Calendar endDate, double budget, int projectCount) {
		projects[projectCount] = new Project(projectName, clientName, projectType, startDate, endDate, budget);
	}

	// Date class also has their own before() and after() method
	/*
	 * This method searches for projects that start after a certain date
	 * @param date is the date after which the projects start
	 */
	public static void searchProjectsAfterDate(Calendar date) {
		// search for the proyects that start after the given date
		for (int i = 0; i < 10; i++) {
			if(projects[i]!=null && projects[i].getInitialDate().after(date)) {
				System.out.println(projects[i].getName());
				}
			}
		}
	
	// Date class also has their own before() and after() method
	/*
	 * This method searches for projects that end before a certain date
	 * @param date is the date before which the projects end
	 */
	public static void searchProjectsBeforeDate(Calendar date) {
		// search for the proyects tha end before the given date
		for (int i = 0; i < 10; i++) {
			if (projects[i]!=null && projects[i].getFinalDate().before(date)) {
				System.out.println(projects[i].getName());
			}
		}

	}
}
