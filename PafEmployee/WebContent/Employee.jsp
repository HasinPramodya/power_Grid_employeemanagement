<%@ page import="com.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.4.1.min.js"></script> 
<script src="Components/validation.js"></script> 
</head>
<body>
<div class="container"> 
	<div class="row">  
		<div class="col-6"> 
			<h1>Employees</h1>
				<form id="formEmployee" name="formEmployee" method="post" action="Employee.jsp">  
					Name:  
 	 				<input id="Name" name="Name" type="text"  class="form-control form-control-sm">
					<br>Address:   
  					<input id="Address" name="Address" type="text" class="form-control form-control-sm">   
  					<br>NIC:   
  					<input id="Nic" name="Nic" type="text"  class="form-control form-control-sm">
  					<br>Phone No.:   
  					<input id="PhoneNo" name="PhoneNo" type="text"  class="form-control form-control-sm">
					<br>  
					<input id="btnSave" name="btnSave" type="button" value="SAVE" class="btn btn-primary">  
					<input type="hidden" id="hidEmployeeIDSave" name="hidEmployeeIDSave" value=""> 
				</form>
				
				<div id="alertSuccess" class="alert alert-success"> </div>
				
			   <div id="alertError" class="alert alert-danger"></div>
				
			   <br>
				<div id="divEmployeeGrid">
					<%
					    Employee employeeObj = new Employee();
						out.print(employeeObj.readEmployee());
					%>
				</div>
				
				 
			</div>
		</div>
</div>
 
</body>
</html>