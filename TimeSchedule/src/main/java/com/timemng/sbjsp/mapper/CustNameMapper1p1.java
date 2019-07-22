//project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

// CustNameInfo - model class ( the class which contains the customer id, first and last name from the customer table )
import com.timemng.sbjsp.model.CustNameInfo1p1; 


// CustNameMapper - a mapper class (used for mapping corresponding to 1-1 between relationship between 1 column in the result of the query statement and 1 field in 
// the model class CustNameInfo.java )
public class CustNameMapper1p1 implements RowMapper<CustNameInfo1p1> {
        /*
		// SQL_CUST_NAME is a SQL query used to select the first and last name of the customer with customerID
		public static String SQL_CUST_NAME // 
		= "select cust_id, first_name, last_name from customer"; 
		*/
	    
		// SQL_CUST_ID is a SQL query used to select the customer ID of the customer with the given first and last name
		public static String SQL_CUST_ID // 
		= "select cust_id, first_name, last_name from customer";  
		
	
		@Override
		public CustNameInfo1p1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			// mapping 1 column in the result of the query statement and 1 field in the model class CustNameInfo.java 
			String cust_id = rs.getString("cust_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
				        
			// create and return an object of the class CustNameInfo ( which is the model )
			return new CustNameInfo1p1( cust_id, first_name, last_name );
		}
		
		/*
		// resetSQL_CUST_NAME sets the string SQL_CUST_NAME to its original value
		public static void resetSQL_CUST_NAME() {
			SQL_CUST_NAME = "select cust_id, first_name, last_name from customer";
		}
		*/
		
		// resetSQL_CUST_ID sets the string SQL_CUST_ID to its original value
		public static void resetSQL_CUST_ID() {
			SQL_CUST_ID = "select cust_id, first_name, last_name from customer";
		}
		
		/*
		// updating the query string to the new query string formed in the class CustNameDAO, method addToQueryStr
		public static void updateSQL_NAME(String sql) {
			SQL_CUST_NAME = sql; // sql - new query string
		}
		*/
		
		// updating the query string to the new query string formed in the class CustNameDAO, method addToQueryStr
		public static void updateSQL_CUST_ID(String sql) {
			SQL_CUST_ID = sql; // sql - new query string
		}
}





