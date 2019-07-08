<!-- author: Ingrid Farkas; project: Time Management -->
<!-- contact_form is shown when the URL is contact_us -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- the link to the external style sheet -->	  
	<%@ include file="header.jsp"%>
</head>

<body>   
    <div class="content"> 
   		<!-- Top menu -->
      	<header class="w3-container w3-white w3-xlarge w3-padding-16"> 
        	<span class="w3-left">Time Management</span> 
      	</header> <!-- end of header -->
      	
      	<!-- including the navigation -->
      	<%@ include file="nav1.jsp"%>
      	
      	<!-- including the content ( of the web page ) -->
      	<%@ include file="contact_info.jsp"%> <!-- shows the contact information and the form for entering the name, email, message -->
      	<br />
      	
      	<!-- including the footer -->
      	<%@ include file="footer.jsp"%> 
    </div>
</body> 