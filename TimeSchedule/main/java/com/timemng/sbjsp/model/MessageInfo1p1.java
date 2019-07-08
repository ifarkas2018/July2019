//project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.model;

// MessageInfo1p1 - model class ( the class representing the data of the record in the message table )
public class MessageInfo1p1 {
	// @@@@@@@@@@@@ what about first name, last name, email
	private String employeeID; 
	private String message; // the message
	
	// constructor of the class 
	public MessageInfo1p1(String message, String employeeID) {
		super();
		this.message = message;
		this.employeeID = employeeID;
	}

}


