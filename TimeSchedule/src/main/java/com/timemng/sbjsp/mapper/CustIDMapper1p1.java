//project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

// CustIDInfo - model class ( the class which contains the cust_id from the customer table )
import com.timemng.sbjsp.model.CustIDInfo1p1;;

// CustIDMapper - a mapper class (used for mapping corresponding to 1-1 between relationship between 1 column in the result of the query statement and 1 field in 
// the class CustIDMapper.java )
public class CustIDMapper1p1 implements RowMapper<CustIDInfo1p1> {
		
		// SQL_CUST_ID is a SQL query used to select cust_id
		public static String SQL_CUST_ID // 
		= "select cust_id from customer ";   

		@Override
		public CustIDInfo1p1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			// mapping 1 column in the result of the query statement and 1 field in the model class CustEmailInfo.java 
			String cust_id = rs.getString("cust_id");
			//String first_name = rs.getString("first_name");
			//String last_name = rs.getString("last_name");
			//String email = rs.getString("email");
				        
			// create and return an object of the class CustEmailInfo ( which is the model )
			return new CustIDInfo1p1( cust_id );
		}
		
		// resetSQL_EMP_NAME sets the string SQL_EMP_NAME to its original value
		//public static void resetSQL_EMP_NAME() {
			//SQL_EMP_NAME = "select emp_id, first_name, last_name, email from employee"; // @@@@@@@@@@@@ REMOVE email
		//}
		
		// resetSQL_EMP_ID sets the string SQL_EMP_ID to its original value
		//public static void resetSQL_EMP_ID() {
			//SQL_EMP_ID = "select emp_id, first_name, last_name, email from employee"; // @@@@@@@@@@@@ REMOVE email
		//}
		
		// resetSQL_CUST_ID sets the string SQL_CUST_ID to its original value
		public static void resetSQL_CUST_ID() {
			SQL_CUST_ID = "select cust_id from customer ";  
		}
		
		// resetSQL_ADD_CUST sets the string SQL_ADD_CUST to its original value
		//public static void resetSQL_ADD_CUST() {
			//SQL_ADD_CUST = "INSERT INTO customer (first_name, last_name, email) VALUES (";  
		//}
				
		// resetSQL_UPD_EMAIL sets the string SQL_UPD_EMAIL to its original value
		//public static void resetSQL_UPD_EMAIL() {
			//SQL_UPD_EMAIL = "update customer set email=";  
		//}
							
		// updating the query string to the new query string formed in the class EmpNameDAO, method addToQueryStrName
		//public static void updateSQL_NAME(String sql) {
			//SQL_EMP_NAME = sql; // sql - new query string
		//}
		
		// updating the query string to the new query string formed in the class EmpNameDAO, method addToQueryStrID
		//public static void updateSQL_EMP_ID(String sql) {
			//SQL_EMP_ID = sql; // sql - new query string
		//}
		
		// updating the query string to the new query string formed in the class CustEmailDAO, method addToQueryStrEmail
		public static void updateSQL_CUST_ID(String sql) {
			SQL_CUST_ID = sql; // sql - new query string
		}
		
		// updating the query string to the new query string formed in the class CustEmailDAO, method addToQueryAddCust
		//public static void updateSQL_ADD_CUST(String sql) {
			//SQL_ADD_CUST = sql; // sql - new query string
		//}
				
		// updating the query string to the new query string formed in the class CustEmailDAO, method addToQueryUpdEmail
		//public static void updateSQL_UPD_EMAIL(String sql) {
			//SQL_UPD_EMAIL = sql; // sql - new query string
		//}
		
}



