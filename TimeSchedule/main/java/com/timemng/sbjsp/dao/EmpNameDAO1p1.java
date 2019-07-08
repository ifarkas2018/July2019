//project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.dao;

//importing the classes
import java.util.List;
import javax.sql.DataSource;

import com.timemng.sbjsp.mapper.EmpMapper1p1;
import com.timemng.sbjsp.mapper.EmpNameMapper1p1;
import com.timemng.sbjsp.model.EmpNameInfo1p1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpNameDAO1p1 extends JdbcDaoSupport {

@Autowired
public EmpNameDAO1p1(DataSource dataSource) {
	this.setDataSource(dataSource);
}

// getName - retrieving name of the employee with the certain empID 
public List<EmpNameInfo1p1> getName() {
 	List<EmpNameInfo1p1> list = null; // initialising the list
 	
 	// SQL_EMP_NAME - the String that contains the part of the query onto which the WHERE clause was added 
    String sql = EmpNameMapper1p1.SQL_EMP_NAME;
    try {
     	Object[] params = new Object[] {};
     	// EmpNameMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( EmpNameInfo.java )
     	EmpNameMapper1p1 mapper = new EmpNameMapper1p1();
     	// running the query and retrieving the list of employee name with the specified employee ID
     	list = this.getJdbcTemplate().query(sql, params, mapper);
     } catch (Exception e) {
     	
     }
     return list; // return the name for the employee with the certain empID
}
 
// getEmployeeID - retrieving the employee ID for the employee with the certain name ( argument )
public List<EmpNameInfo1p1> getEmployeeID( String firstName, String lastName) {
	List<EmpNameInfo1p1> list = null; // initialising the list
	
	// SQL_EMP_ID - the String that contains the query on which the WHERE clause was added depending on the value of the firstName, lastName  
	String sql = EmpNameMapper1p1.SQL_EMP_ID;
	try {
	   	Object[] params = new Object[] {};
	   	// EmpNameMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( EmpNameInfo.java )
	   	EmpNameMapper1p1 mapper = new EmpNameMapper1p1();
	   	// running the query and retrieving the employee ID with the certain first name and last name
	   	list = this.getJdbcTemplate().query(sql, params, mapper);
	} catch (Exception e) {
	   	
   }
   return list; // return the employee ID for the employee with the certain first name and last name
}
 
// getEmpEmail - retrieving the email for the employee with the certain employee ID and name ( argument )
public List<EmpNameInfo1p1> getEmpEmail() {
	List<EmpNameInfo1p1> list = null; // initialising the list
	
	// SQL_EMP_ID - the String that contains the query on which the WHERE clause was added depending on the value of the employee ID, first name, last name  
	String sql = EmpNameMapper1p1.SQL_USR_EMAIL;
	try {
	   	Object[] params = new Object[] {};
	   	// EmpNameMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( EmpNameInfo.java )
	   	EmpNameMapper1p1 mapper = new EmpNameMapper1p1();
	   	// running the query and retrieving the email for the employee with the certain employee ID and name
	   	list = this.getJdbcTemplate().query(sql, params, mapper);
	} catch (Exception e) {
	   	
	}
	return list; // return the email for the employee with the certain employee ID and name
}


// updateEmail - adding the email to the table employee ( for the employee with emp_id ) 
public int updateEmail() {
	int numRows=-1; // number of rows affected with the update statement
	    
	// SQL_UPD_EMAIL is the string that contains the UPDATE query for updating the email in the table employee for the employee with emp_id  
	// in the form contact_form.jsp
	String sql = EmpNameMapper1p1.SQL_UPD_EMAIL;
	try {
	    //Object[] params = new Object[] {}; if I DELETE THIS would it still WORK @@@@@@@@@@@@@@@@
	    // EmployeeMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( EmpNameInfo.java )
	    // EmpMapper1p1 mapper = new EmpMapper1p1(); if I DELETE THIS would it still WORK @@@@@@@@@@@@@@@@
	    // running the query of updating the email in the table employee for the employee with emp_id
	    numRows = this.getJdbcTemplate().update(sql);
	} catch (Exception e) {
	     	
	}
	     
	// returns the number of rows affected with the update statement ( if an exception occurred -1 is returned )
	return numRows; 
}

// add to the SQL query the WHERE clause - where ( emp_id = id of the employee ) 
public void addToQueryStrName(String empID ) {

  	// if other user ( regular or admin ) logged in before then the original SQL_EMP_NAME got changed so I have to reset it to its original value 
  	EmpNameMapper1p1.resetSQL_EMP_NAME();
  	String sql = EmpNameMapper1p1.SQL_EMP_NAME;
  	
  	// I am changing the SQL query to return the employee's first and last name ( for the given employee's ID ) 
  	sql += " where emp_id='" + empID + "' ";
  
  	sql += ";";
  	
  	// update the SQL_EMP_NAME to the sql
  	EmpNameMapper1p1.updateSQL_NAME(sql);
}

// add to the SQL query the WHERE clause - where ( firstName = first name of the employee ) and ( lastName = last name of the employee )
public void addToQueryStrID(String firstName, String lastName ) {

	boolean firstNameEx; // does the first name exist
	boolean lastNameEx; // does the last name exist
	
	// if the user ( admin ) logged in and queried the database for some other employee ID the original SQL_EMP_ID got changed so I have to reset it to its original value 
	EmpNameMapper1p1.resetSQL_EMP_ID();
	String sql = EmpNameMapper1p1.SQL_EMP_ID;
	
	firstNameEx = ((firstName!=null) && (!firstName.equals(""))); // does the first name exist
	lastNameEx = ((lastName!=null) && (!lastName.equals(""))); // does the last name exist
	if (firstNameEx){
		// I am changing the SQL query to return the employee's ID for the entered first and last name  
		sql += " where first_name='" + firstName + "' ";
		
		if (lastNameEx) 
			sql += "and";
	} else if (lastNameEx) {
		sql += " where";
	}
		
	if (lastNameEx){
		// I am changing the SQL query to return the employee's ID for the entered last name  
		sql += " last_name='" + lastName + "' ";
	}
	sql += ";";
	
	// update the SQL_EMP_NAME to the sql
	EmpNameMapper1p1.updateSQL_EMP_ID(sql);
}

// add to the SQL query the WHERE clause - where ( firstName = first name of the employee ) ( OR firstName LIKE '%' if firstName == '' )
// and ( lastName = last name of the employee ) ( OR lastName LIKE '%' if lastName == '' )
public void addToQueryStrEmail(String empID, String firstName, String lastName ) {
	
	boolean empIDEx; // does the empID exist
	boolean firstNameEx; // does the first name exist
	boolean lastNameEx; // does the last name exist
	
	// if the user ( admin ) logged in and queried the database for some other email the original SQL_USR_EMAIL got changed so I have to reset it to its original value 
	EmpNameMapper1p1.resetSQL_USR_EMAIL();
	String sql = EmpNameMapper1p1.SQL_USR_EMAIL;
	
	empIDEx = ((empID!=null) && (!empID.equals(""))); // does the first name exist
	firstNameEx = ((firstName!=null) && (!firstName.equals(""))); // does the first name exist
	lastNameEx = ((lastName!=null) && (!lastName.equals(""))); // does the last name exist
	
	sql += " where";
	
	if (empIDEx) {
		sql += " emp_id = '" + empID + "'";
	} else {
		sql += " emp_id LIKE '%'";
	}
	
	sql += " and ";
	
	if (firstNameEx){
		sql += " first_name = '" + firstName + "'";
	} else {
		sql += " first_name LIKE '%'";
	}
	
	sql += " and "; 
	
	if (lastNameEx){
		sql += " last_name = '" + lastName + "'";
	} else {
		sql += " last_name LIKE '%'";
	}
	
	// update the SQL_USR_EMAIL to the sql
	EmpNameMapper1p1.updateSQL_USR_EMAIL(sql);
	
}

// add to the UPDATE query the email and the WHERE clause - where emp_id=i
public void addToQueryUpdEmail(String empID, String email ) {
	
	//boolean empIDEx; // does the empID exist
	//boolean firstNameEx; // does the first name exist
	//boolean lastNameEx; // does the last name exist
	
	// if the user ( admin ) logged in and queried the database for some other email the original SQL_UPD_EMAIL got changed so I have to reset it to its original value 
	EmpNameMapper1p1.resetSQL_UPD_EMAIL();
	
	String sql = EmpNameMapper1p1.SQL_UPD_EMAIL;
	
	sql += "'" + email + "'" + " where emp_id='" + empID + "';";
	
	// update the SQL_USR_EMAIL to the sql
	EmpNameMapper1p1.updateSQL_UPD_EMAIL(sql);

}
}
