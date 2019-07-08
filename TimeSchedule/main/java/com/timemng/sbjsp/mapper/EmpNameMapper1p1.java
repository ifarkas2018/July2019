// project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

// EmpNameInfo - model class ( the class which contains the employee id, first and last name from the employee table )
import com.timemng.sbjsp.model.EmpNameInfo1p1; 


// EmpNameMapper - a mapper class (used for mapping corresponding to 1-1 between relationship between 1 column in the result of the query statement and 1 field in 
// the model class EmpNameInfo.java )
public class EmpNameMapper1p1 implements RowMapper<EmpNameInfo1p1> {

		// SQL_EMP_NAME is a SQL query used to select the first and last name of the employee with employeeID
		public static String SQL_EMP_NAME // 
		= "select emp_id, first_name, last_name,email from employee"; // @@@@@@@@@@@ REMOVE email
		
		// SQL_EMP_ID is a SQL query used to select the employee ID of the employee with the given first and last name
		public static String SQL_EMP_ID // 
		= "select emp_id, first_name, last_name, email from employee";  // @@@@@@@@@@@ REMOVE email
		
		// SQL_USR_EMAIL is a SQL query used to select the employee ID, first name, last name and email
		public static String SQL_USR_EMAIL // 
		= "select emp_id, first_name, last_name, email from employee ";  
		
		// ADD_EMP_SQL is a SQL query to which I will add the first name, last name, department depending on the data the user entered in the Contact Us form
		//public static String ADD_EMP_SQL //
		//= "INSERT INTO employee (emp_id, email) VALUES (";
		
		// SQL_ADD_EMAIL is a SQL query to which I will add the email and the condition for the emp_id 
		public static String SQL_UPD_EMAIL //
		= "UPDATE employee SET email=";

		@Override
		public EmpNameInfo1p1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			// mapping 1 column in the result of the query statement and 1 field in the model class EmpNameInfo.java 
			String emp_id = rs.getString("emp_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String email = rs.getString("email");
				        
			// create and return an object of the class EmpNameInfo ( which is the model )
			return new EmpNameInfo1p1( emp_id, first_name, last_name, email );
		}
		
		// resetSQL_EMP_NAME sets the string SQL_EMP_NAME to its original value
		public static void resetSQL_EMP_NAME() {
			SQL_EMP_NAME = "select emp_id, first_name, last_name, email from employee"; // @@@@@@@@@@@@ REMOVE email
		}
		
		// resetSQL_EMP_ID sets the string SQL_EMP_ID to its original value
		public static void resetSQL_EMP_ID() {
			SQL_EMP_ID = "select emp_id, first_name, last_name, email from employee"; // @@@@@@@@@@@@ REMOVE email
		}
		
		// resetSQL_USR_EMAIL sets the string SQL_EMP_ID to its original value
		public static void resetSQL_USR_EMAIL() {
			SQL_USR_EMAIL = "select emp_id, first_name, last_name, email from employee ";  
		}
					
		// resetSQL_ADD_EMAIL sets the string SQL_ADD_EMAIL to its original value
		public static void resetSQL_UPD_EMAIL() {
			SQL_UPD_EMAIL = "update employee set email=";  
		}
							
		// updating the query string to the new query string formed in the class EmpNameDAO, method addToQueryStrName
		public static void updateSQL_NAME(String sql) {
			SQL_EMP_NAME = sql; // sql - new query string
		}
		
		// updating the query string to the new query string formed in the class EmpNameDAO, method addToQueryStrID
		public static void updateSQL_EMP_ID(String sql) {
			SQL_EMP_ID = sql; // sql - new query string
		}
		
		// updating the query string to the new query string formed in the class EmpNameDAO, method addToQueryStrEmail
		public static void updateSQL_USR_EMAIL(String sql) {
			SQL_USR_EMAIL = sql; // sql - new query string
		}
		
		// updating the query string to the new query string formed in the class EmpNameDAO, method addToQueryUpdEmail
		public static void updateSQL_UPD_EMAIL(String sql) {
			SQL_UPD_EMAIL = sql; // sql - new query string
		}
		
}

