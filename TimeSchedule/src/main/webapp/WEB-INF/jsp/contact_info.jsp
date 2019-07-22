<!-- project : Time Schedule, author : Ingrid Farkas, 2019 -->
<!-- included in contact_form.jsp -->
<!-- Contact section -->
<div class="w3-content">
	<div class="w3-row w3-margin">
	   	<div class="w3-third">
	        &nbsp; &nbsp; &nbsp; &nbsp;
	        <br />
	        &nbsp; &nbsp; &nbsp; &nbsp;
	        <!-- first image on the left hand side from the form -->
	        <img src="../../images/woman_on_phone.jpg" style="width:100%">
	        &nbsp; &nbsp; &nbsp; &nbsp;
	        <!-- second image on the left hand side from the form -->
	        <img src="../../images/woman_with_laptop.jpg" style="width:100%"> 
	        <br />
	        <br />
	    </div>
	        
	    <!-- "w3-third" class uses 66% of the parent container -->
	    <div class="w3-twothird w3-container">
	        <br/>
	        <br/>
	        <!--  w3-text-theme-m1 CSS rule which sets the color of the text ( file styles1.css ) -->
	        <div class="w3-container form_background w3-padding-32 w3-padding-large" id="show_sched_info"> <!-- w3-light-grey  -->
	            <div class="w3-content w3-text" style="max-width:600px">
	            	<!--  w3-center centers the text -->
			    	<h4 class="w3-center"><b>Contact Us</b></h4>
			    	<i class="fa fa-map-marker" style="width:30px"></i> Chicago, US<br>
    <i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515<br>
    <i class="fa fa-envelope" style="width:30px"> </i> Email: mail@mail.com<br>
    <p>Questions? Go ahead, ask them:</p>
    <%  
    	// did the user already login ( as administrator or employee )
		String is_already_login = (String)(request.getAttribute("already_login"));
        if (is_already_login.equals("true")) {
    %>    
    		<form action="http://localhost:8080/emp_message" method="post"> <!-- when submitted the localhost:8080/emp_message is shown -->
    <%
        } else {
    %>	
    		<form action="http://localhost:8080/cust_message" method="post"> <!-- if the customer didn't log in already -->
    <%
        }
    		if (is_already_login.equals("true")) {
    %>
		    	<div class="w3-section">
				    <label>Employee ID</label>
				    <!--  ??????????????????????????????  -->
				    <!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true 
						  for the employee_id -->
						<input class="w3-input w3-border" type="text" name="emp_id"> <!-- input field for entering the employee id -->
			    </div>
	    <%
    		}
	    %>
		<div class="w3-section">
			<label>First Name</label>  
			<input class="w3-input w3-border" type="text" name="first_name" required=true> <!-- input field for entering the first_name -->
		</div>
	    <div class="w3-section">
			<label>Last Name</label> 
			<!--  ??????????????????????????????  -->
			<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true
			      for the last-name -->
			<input class="w3-input w3-border" type="text" name="last_name" required=true> <!-- input field for entering the last_name -->
		</div> 
		<div class="w3-section">
			<label>Email</label> 
			<!--  ??????????????????????????????  -->
			<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true
			      for the last-name -->
			<input class="w3-input w3-border" type="text" name="email"> <!-- input field for entering the email -->
		</div> 
		<div class="w3-section">
			<label>Message</label> 
			<!--  ??????????????????????????????  -->
			<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true
			      for the last-name -->
			<input class="w3-input w3-border" type="text" name="message" required=true> <!-- input field for entering the message -->
		</div> 
	  <!--  	
      <p><input class="w3-input w3-border" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-border" type="text" placeholder="Email" required name="Email"></p>
      <p><input class="w3-input w3-border" type="text" placeholder="Message" required name="Message"></p>
      -->
    <button type="submit" class="w3-btn w3-camo-grey w3-third">Send a Message</button>
    </form>
				</div>
			</div>
		</div>
	</div>
</div>