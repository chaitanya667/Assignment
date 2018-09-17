   
    
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
            
            <script>
function validateForm() {	
	
	var x = document.getElementById("pwd").value;
	if (x == "")
	{
        alert("Invalid Password");
	return false;
	}
	else
		{
		return true;
		}
		
    }
</script>
        </head>
        <body>
        <form action = "editUser" method ="post">
         <table>
       	<tr>
       		<td>Username: </td>
       		<td>${user.username} </td>
       </tr>
       <tr>
       		<td>Password: </td>
       		<td><input type="text" name="password" id="pwd"> </td>
       </tr>
       <tr align="left">
       <td><input type="hidden" id="userId" name="userId" value='${user.userId}'> </td>
       	<td><input type ="submit" value = "Update Password" onclick="return validateForm()"/></td>
		 </tr>
       
       </table>
        
       <%-- <form action = "editUser" method ="post">
       UserName : ${user.username}<br/>
       Password : <input type="text" name="password" id="pwd"/> 
        <input type="hidden" id="userId" name="userId" value='${user.userId}'> <br/>
	<input type ="submit" value = "Update Password" onclick="return validateForm()"/>
	<input type ="submit" value = "Cancel" /> --%>
	</form> 
   ${message}  <br/>
   
   <a href = "/back">Click here to go to Main Page</a>

        </body>
        </html>