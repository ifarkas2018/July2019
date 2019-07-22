// project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.dao;


	
//importing the classes
import java.util.List;
import javax.sql.DataSource;

//import com.timemng.sbjsp.mapper.CustEmailMapper1p1;
//import com.timemng.sbjsp.mapper.EmpMapper1p1;
import com.timemng.sbjsp.mapper.CustIDMapper1p1;
import com.timemng.sbjsp.model.CustIDInfo1p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustIDDAO1p1 extends JdbcDaoSupport {

@Autowired
public CustIDDAO1p1(DataSource dataSource) {
	this.setDataSource(dataSource);
}

// getCustID - retrieving the customer ID for the customer with the certain name and email ( argument )
public List<CustIDInfo1p1> getCustID() {
	List<CustIDInfo1p1> list = null; // initialising the list
	
	// SQL_CUST_ID - the String that contains the query on which the WHERE clause was added depending on the value of the first name, last name and email  
	String sql = CustIDMapper1p1.SQL_CUST_ID;
	try {
	   	Object[] params = new Object[] {};
	   	// CustIDMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( CustIDInfo.java )
	   	CustIDMapper1p1 mapper = new CustIDMapper1p1();
	   	// running the query and retrieving the customer ID for the customer with the certain name and email
	   	list = this.getJdbcTemplate().query(sql, params, mapper);
	} catch (Exception e) {
	   	
	}
	return list; // return the email for the customer with the certain name
}
	
// add to the SQL query the WHERE clause - where ( firstName = first name of the customer ) 
// and ( lastName = last name of the customer ) and ( email = Email )
public void addToQueryCustID(String firstName, String lastName, String email ) {
		
		// boolean custIDEx; // does the custID exist
		boolean firstNameEx; // does the first name exist
		boolean lastNameEx; // does the last name exist
		boolean emailEx; // does the email exist
		
		// if the customer filled in the Contact Us form before the original SQL_CUST_ID got changed so I have to reset it to its original value 
		CustIDMapper1p1.resetSQL_CUST_ID();
		String sql = CustIDMapper1p1.SQL_CUST_ID;
		
		// custIDEx = ((custID!=null) && (!custID.equals(""))); // does the first name exist
		firstNameEx = ((firstName!=null) && (!firstName.equals(""))); // does the first name exist
		lastNameEx = ((lastName!=null) && (!lastName.equals(""))); // does the last name exist
		emailEx = ((email!=null) && (!email.equals("")));
		
		sql += " where";
		
		//if (custIDEx) {
			// sql += " cust_id = '" + custID + "'";
		//} else {
			// sql += " cust_id LIKE '%'";
		//}
		
		//sql += " and ";
		
		if (firstNameEx) // {
			sql += " first_name='" + firstName + "'";
		//} else {
			//sql += " first_name LIKE '%'";
		//}
		
		if (lastNameEx) {
			sql += " and"; 
			sql += " last_name='" + lastName + "'";
		//} else {
			//sql += " last_name LIKE '%'";
		}
		
		if (emailEx) {
			sql += " and"; 
			sql += " email='" + email + "'";
		}
		
		sql += ";";
		// update the SQL_USR_EMAIL to the sql
		CustIDMapper1p1.updateSQL_CUST_ID(sql);
		
	}


}
