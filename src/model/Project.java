package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;


public class Project{
	
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;

	private DateFormat formatter;

	/*
	 * This method is the constructor of the class Project
	 * @param name is the name of the project
	 * @param clientName is the name of the client
	 * @param projectType is the type of the project
	 * @param initialDate is the initial date of the project
	 * @param finalDate is the final date of the project
	 * @param budget is the total budget of the project
	 */
	public Project(String name, String clientName, String projectType, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");
		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getProjectInfo() throws ParseException{
		return "\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}
}


