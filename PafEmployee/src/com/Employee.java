package com;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/electricityborad?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertEmployee(String Name, String Address, String Nic, String PhoneNo) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into employeeservice(`eID`,`Name`,`Address`,`Nic`,`PhoneNo`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Name);
			preparedStmt.setString(3, Address);
			preparedStmt.setString(4, Nic);
			preparedStmt.setString(5, PhoneNo);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newEmployee = readEmployee(); 
			output =  "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}";    
		} catch (Exception e) {
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the employee.\"}";  
			System.err.println(e.getMessage());   
		}
		return output;
	}

	public String readEmployee() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Employee Name</th><th>Address</th><th>NIC</th><th>Phone No</th></tr>";
			String query = "select * from employeeservice";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String eID = Integer.toString(rs.getInt("eID"));
				String Name = rs.getString("Name");
				String Address = rs.getString("Address");
				String Nic = rs.getString("Nic");
				String PhoneNo = rs.getString("PhoneNo");

				// Add into the html table
				output += "<tr><td><input id=\'hidEmployeeIDUpdate\' name=\'hidEmployeeIDUpdate\' type=\'hidden\' value=\'" + eID + "'>" 
						+ Name + "</td>"; 
				output += "<td>" + Address + "</td>";
				output += "<td>" + Nic + "</td>";
				output += "<td>" + PhoneNo + "</td>";
				
				output +="<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-warning'></td>"      
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-eID='" + eID + "'>" + "</td></tr>"; 
			
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the employee.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateEmployee(String eID, String Name, String Address, String Nic, String PhoneNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE employeeservice SET Name=?,Address=?,Nic=?,PhoneNo=?" + "WHERE eID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, Name);
			preparedStmt.setString(2, Address);
			preparedStmt.setString(3, Nic);
			preparedStmt.setString(4, PhoneNo);
			preparedStmt.setInt(5, Integer.parseInt(eID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newEmployee = readEmployee();    
			output = "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}";  
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Employee.\"}"; 
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteEmployee(String eID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from employeeservice where eID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(eID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newEmployee = readEmployee();    
			output = "{\"status\":\"success\", \"data\": \"" +  newEmployee + "\"}"; 
		}
		catch (Exception e)   
		{    
			output = "Error while deleting the employee.";    
			System.err.println(e.getMessage());   
		} 
		return output;
	}

}
