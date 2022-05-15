$(document).ready(function() 
{  
		$("#alertSuccess").hide();  
	    $("#alertError").hide(); 
}); 
 
 
// SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 
 
	// Form validation-------------------  
	var status = validateEmployeeForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 
 
	// If valid------------------------  
	var type = ($("#hidEmployeeIDSave").val() == "") ? "POST" : "PUT"; 

	$.ajax( 
	{  
			url : "/EmployeeAPI",   
			type : type,  
			data : $("#formEmployee").serialize(),  
			dataType : "text",  
			complete : function(response, status)  
			{   
				onEmployeeSaveComplete(response.responseText, status);  
			} 
	}); 
}); 


function onEmployeeSaveComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully saved.");    
			$("#alertSuccess").show(); 

			$("#divEmployeeGrid").html(resultSet.data);   
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		} 

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while saving.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while saving..");   
		$("#alertError").show();  
	} 

	$("#hidEmployeeIDSave").val("");  
	$("#formEmployee")[0].reset(); 
} 

 
// UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) 
{     
	$("#hidEmployeeIDSave").val($(this).closest("tr").find('#hidEmployeeIDUpdate').val());     
	$("#Name").val($(this).closest("tr").find('td:eq(0)').text());     
	$("#Address").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#Nic").val($(this).closest("tr").find('td:eq(2)').text());
	$("#PhoneNo").val($(this).closest("tr").find('td:eq(3)').text());     
}); 




//REMOVE===========================================
$(document).on("click", ".btnRemove", function(event) 
{  
	$.ajax(  
	{   
		url : "EmployeeAPI",   
		type : "DELETE",   
		data : "eID=" + $(this).data("eID"),   
		dataType : "text",   
		complete : function(response, status)   
		{    
			onEmployeeDeleteComplete(response.responseText, status);   
		}  
	}); 
}); 

function onEmployeeDeleteComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			
			$("#alertSuccess").text("Successfully deleted.");    
			$("#alertSuccess").show(); 
		
			$("#divEmployeeGrid").html(resultSet.data); 
			
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		}
		

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while deleting.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while deleting..");   
		$("#alertError").show();  
	}
}
 
// CLIENT-MODEL========================================================================= 
function validateEmployeeForm() 
{  

	if ($("#Name").val().trim() == "")  
	{   
		return "Insert Name";  
	}
	

	if ($("#Address").val().trim()== "")
	
	{
	 return "Insert Address";
	} 
	
	
	if ($("#Nic").val().trim() == "")  
	{   
		return "Insert Nic";  
	}
	
	if ($("#PhoneNo").val().trim() == "")  
	{   
		return "Insert PhoneNo";  
	}
	
	
	 

	return true; 
}