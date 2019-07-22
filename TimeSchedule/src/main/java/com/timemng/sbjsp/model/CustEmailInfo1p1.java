//project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.model;

// CustEmailInfo1p1 - model class ( the class representing the customer ID, first name, last name, email from the customer table )
public class CustEmailInfo1p1 extends CustNameInfo1p1 {

/*	
private String employeeID; // the employee's ID
private String firstName; // the employee's first name
private String lastName; // the employee's last name
*/ 
private String email; 

	// constructor of the class
	public CustEmailInfo1p1( String customerID, String firstName, String lastName, String email ) {
		super(customerID, firstName, lastName);
		/*
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		*/
		this.email = email;
	}

	// get the employee ID
	/*
	public String getEmployeeID() {
		return employeeID;
	}
	*/

	// set the employee ID
	/*
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	*/

	// get the first name
	/*
	public String getFirstName() {
		return firstName;
	}
	*/
	
	// set the first name
	/*
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	*/
	
	// get the last name
	/*
	public String getLastName() {
		return lastName;
	}
	*/

	// set the first name
	/*
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	*/
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}


