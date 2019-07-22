//project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.dao;

//importing the classes
import java.util.List;
import javax.sql.DataSource;

//import com.timemng.sbjsp.mapper.EmpMapper1p1;
import com.timemng.sbjsp.mapper.CustEmailMapper1p1;
import com.timemng.sbjsp.mapper.EmpDeptMapper1p1;
import com.timemng.sbjsp.model.CustEmailInfo1p1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustEmailDAO1p1 extends JdbcDaoSupport {

@Autowired
public CustEmailDAO1p1(DataSource dataSource) {
	this.setDataSource(dataSource);
}

// getCustEmail - retrieving the email for the customer with the certain customer ID and name ( argument )
public List<CustEmailInfo1p1> getCustEmail() {
	List<CustEmailInfo1p1> list = null; // initialising the list
	
	// SQL_CUST_ID - the String that contains the query on which the WHERE clause was added depending on the value of the customer ID, first name, last name  
	String sql = CustEmailMapper1p1.SQL_CUST_EMAIL;
	try {
	   	Object[] params = new Object[] {};
	   	// CustEmailMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( CustEmailInfo.java )
	   	CustEmailMapper1p1 mapper = new CustEmailMapper1p1();
	   	// running the query and retrieving the email for the customer with the certain customer ID and name
	   	list = this.getJdbcTemplate().query(sql, params, mapper);
	} catch (Exception e) {
	   	
	}
	return list; // return the email for the customer with the certain name
}

/*
// addCustomer - adding the new customer ( with the first name fname, last name lname and email ) to the table customer 
public int addCustomer(String fName, String lName, String email) {
	int numRows=-1; // number of rows affected with the insert statement
	    
	 	// ADD_EMP_SQL is the String that contains the query on which I added the first name, last name, department depending on the data the user entered in the Add Employee form
	 	// in the form addempl_fcont.jsp 
	     String sql = EmpDeptMapper1p1.ADD_EMP_SQL;
	     try {
	     	//Object[] params = new Object[] {}; if I DELETE THIS would it still WORK @@@@@@@@@@@@@@@@
	     	// EmployeeMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( EmployeeInfo.java )
	     	//EmpMapper1p1 mapper = new EmpMapper1p1(); if I DELETE THIS would it still WORK @@@@@@@@@@@@@@@@
	     	// running the query of adding a new user with the fName ( first name ), lName ( last name ), department
	     	numRows = this.getJdbcTemplate().update(sql);
	     } catch (Exception e) {
	     	
	     }
	     
	  // returns the number of rows affected with the insert statement ( if an exception occurred -1 is returned )
	  return numRows; 
	 }
*/

// updateCustEmail - running the query SQL_ADD_CUST, SQL_UPD_EMAIL ( CustEmailMapper.java )
public int updateInsertEmail(String qry) {
	int numRows=-1; // number of rows affected with the update statement
	    
	// OLD -- SQL_UPD_EMAIL is the string that contains the UPDATE query for updating the email in the table customer for the customer with cust_id  
	// in the form contact_form.jsp -- OLD @@@@@@@@@@@@@@@@@@@@
	// called from the MainController; qry is SQL_ADD_CUST, SQL_UPD_EMAIL
	String sql = qry; // @@@@@@@@@@@@@@ CustEmailMapper1p1.SQL_UPD_EMAIL
	try {
	    // running the query qry
	    numRows = this.getJdbcTemplate().update(sql);
	} catch (Exception e) {
	     	
	}
	     
	// returns the number of rows affected with the update or insert statement ( if an exception occurred -1 is returned )
	return numRows; 
}


// add to the SQL query the WHERE clause - where ( first_name = firstName ) ( OR first_name LIKE '%' if firstName == '' )
// and ( last_name = lastName ) ( OR last_name LIKE '%' if lastName == '' )
public void addToQueryStrEmail(String firstName, String lastName ) {
	
	// boolean custIDEx; // does the custID exist
	boolean firstNameEx; // does the first name exist
	boolean lastNameEx; // does the last name exist
	
	// if the user ( admin ) logged in and queried the database for some other email the original SQL_CUST_EMAIL got changed so I have to reset it to its original value 
	CustEmailMapper1p1.resetSQL_CUST_EMAIL();
	String sql = CustEmailMapper1p1.SQL_CUST_EMAIL;
	
	// custIDEx = ((custID!=null) && (!custID.equals(""))); // does the first name exist
	firstNameEx = ((firstName!=null) && (!firstName.equals(""))); // does the first name exist
	lastNameEx = ((lastName!=null) && (!lastName.equals(""))); // does the last name exist
	
	sql += " where";
	
	//if (custIDEx) {
		// sql += " cust_id = '" + custID + "'";
	//} else {
		// sql += " cust_id LIKE '%'";
	//}
	
	//sql += " and ";
	
	if (firstNameEx) // {
		sql += " first_name = '" + firstName + "'";
	//} else {
		//sql += " first_name LIKE '%'";
	//}
	
	sql += " and "; 
	
	if (lastNameEx) // {
		sql += " last_name = '" + lastName + "'";
	//} else {
		//sql += " last_name LIKE '%'";
	//}
	
	sql += ";";
	// update the SQL_USR_EMAIL to the sql
	CustEmailMapper1p1.updateSQL_CUST_EMAIL(sql);
	
}


// adds to the SQL query the first name, last name, email depending on the data the user entered in the Contact Us form
// if the user didn't enter first name or last name or the email ( in the form ) then this method returns false
public boolean addToQueryAddCust(String fName, String lName, String email ) {

	boolean returnVal; // the value returned by the method
	// if the user before completed the Contact Us form then the original SQL_ADD_CUST got changed so I have to reset it to its original value 
	CustEmailMapper1p1.resetSQL_ADD_CUST(); 
	  	
	String sql = CustEmailMapper1p1.SQL_ADD_CUST;
	  	
	if ((!(fName.equals(null))) && (!(lName.equals(null)))) {
		sql += "'" + fName + "',"; // add the first name to the insert
	  	sql += "'" + lName + "'"; // add the last name to the insert
	  	if (!(email.equals(null))){
	  		sql += ",'" + email + "'"; // add the department to the insert
	  	} else {
	  		sql += ",''"; 
	  	}
	  	sql += ");"; 
	  	
	  	returnVal = true;
	} else {
		returnVal = false; // the user didn't enter first name or last name
	}	  	
	  	
	// update the SQL_ADD_CUST to the sql
	CustEmailMapper1p1.updateSQL_ADD_CUST(sql);
	  	
	return returnVal;
}

// @@@@@@@@@@@@@@ COMMENT this one OUT when changed the emp_message
// add to the UPDATE query the email and the WHERE clause - where cust_id=i
public void addToQueryUpdEmail(String custID, String email ) {
	
	//boolean empIDEx; // does the empID exist
	//boolean firstNameEx; // does the first name exist
	//boolean lastNameEx; // does the last name exist
	
	// if the user ( admin ) logged in and queried the database for some other email the original SQL_UPD_EMAIL got changed so I have to reset it to its original value 
	CustEmailMapper1p1.resetSQL_UPD_EMAIL();
	
	String sql = CustEmailMapper1p1.SQL_UPD_EMAIL;
	
	sql += "'" + email + "'" + " where cust_id='" + custID + "';";
	
	// update the SQL_USR_EMAIL to the sql
	CustEmailMapper1p1.updateSQL_UPD_EMAIL(sql);

}


}

