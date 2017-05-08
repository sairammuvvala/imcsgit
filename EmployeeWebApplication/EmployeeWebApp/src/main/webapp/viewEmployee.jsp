<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/EmployeeWebApp/UpdateEmployee" method=post>
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id"
					value="${requestScope.employee.id}"></td>
			</tr>
			<tr>
				<td>firstname</td>
				<td><input type="text" name="firstName"
					value="${requestScope.employee.firstName}"></td>
			</tr>
			<tr>
				<td>last name</td>
				<td><input type="text" name="lastName"
					value="${requestScope.employee.lastName}"></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><input type="text" name="salary"
					value="${requestScope.employee.salary}"></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><input type="text" name="gender"
					value="${requestScope.employee.gender}"></td>
			</tr>
		</table>
		<input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
	</form>





</body>
</html>




<!-- pw.println("<html><table align='center' border=2>");
				pw.println("<h3 align='center'>Employee Details </h3>");
				 pw.println("<tr><td>id</td><td>"+employee.getId()+"</td></tr>");
				 pw.println("<tr><td>firstname</td><td>"+employee.getFirstName()+"</td></tr>");
				 pw.println("<tr><td>lastname</td><td>"+employee.getLastName()+"</td></tr>");
				 pw.println("<tr><td>gender</td><td>"+employee.getGender()+"</td></tr>");
				 pw.println("<tr><td>salary</td><td>"+employee.getSalary()+"</td></tr>");
				 pw.println("</table></html>");
					 -->