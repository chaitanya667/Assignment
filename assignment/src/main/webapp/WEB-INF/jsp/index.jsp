    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>
        <body>        
       
       <form action = "register" method = "post">
       <table>
       	<tr>
       		<td>Username </td>
       		<td><input type="text" name="username"> </td>
       </tr>
       <tr>
       		<td>Password </td>
       		<td><input type="text" name="password"> </td>
       </tr>
       <tr align="left">
       <td></td>
       	<td><input type ="submit" value = "Register"/></td>
       	<td><a href = "/getUserList">Show User Data</a></td>
       </tr>
       
       </table>
 	

<c:set var = "userlst"  value = "${users}"/>
<c:set var = "userlstlen"  value = "${fn:length(userlst)}"/>
      <c:if test = "${userlstlen != 0}">
      	
      
 <table border ="1" cellpadding="10">
 <tr>
 <th>User ID</th>
 <th>User Name</th>
 <th>User Status</th>
 <th  colspan='3'>Edit/Update</th>
 
 </tr>
         <c:forEach items="${users}" var="user">
        
        <tr>
        	<td>
                <c:out value="${user.userId}"/> 
            </td>
            <td>
                <c:out value="${user.username}"/> 
            </td>
            <%-- <td>
                <c:out value="${user.password}"/> 
            </td> --%>
            <td>
                <c:out value="${user.status}"/> 
            </td>
            
           
            <c:choose>
			    <c:when test="${user.status == 'Active'}">
			      <td>
	                <a href="<c:url value='/changePwd/${user.userId}'/>" >Change Password</a>
	            </td>
	             <td>
			        <a  href="<c:url value='/deActivate/${user.userId}'/>">Deactivate User</a>
			         </td>
			    </c:when>
			    <c:otherwise>
			    	 <td>
		               <%--  <a href="<c:url value='/changePwd/${user.userId}'/>" >Change Password</a> --%>
		               <a href="javascript:void(0)" onclick="alertFunction(${user.userId})">Change Password</a>
		               
		             </td>
		              <td>
			        <a href="<c:url value='/activate/${user.userId}'/>">Activate User</a>
			         </td>
			    </c:otherwise>
			</c:choose>                
             <td>
               <a href="<c:url value='/deleteUser/${user.userId}'/>">Delete</a> 
            </td>
        </tr>
       
    </c:forEach> 
    
     </table>
     </c:if>
	</form> 
 

         
${message}  <br/>
        </body>
        
        <script type="text/javascript">
        function alertFunction(val){
        	alert("!!! Cant Change Password !!! User Id: "+val+" is Deactivated");
        } 
        </script>
        </html>