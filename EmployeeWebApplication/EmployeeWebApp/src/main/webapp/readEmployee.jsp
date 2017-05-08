<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
 <%@taglib uri="coretag" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
 <head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
</head>
<body>
<!-- <h2 align="center">Enter Employee-id to find Employee in the database</h2>
<form action="/EmployeeWebApp/ReadEmployee" method="post">
<table align="center">
<tr><td>id</td><td><input type="number" name="id"></input></td></tr>
<tr><td></td><td><input type="submit" value="submit"></input></td></tr>
</table>
</form>
<form action="/EmployeeWebApp/UpdateEmployee" method="post">
<table align="center">
<tr><td>id</td><td><input type="number" name="id"></input></td></tr>
<tr><td></td><td><input type="submit" value="submit"></input></td></tr>
</table>
</form> -->
<form class="form-horizontal" role="form" method="post" action="/EmployeeWebApp/ReadEmployee">
<div class="form-group">
		<label for="id" class="col-sm-2 control-label">Enter Id to view</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter employee id" value="">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary"/>
		</div>
	</div>
</form>
<form class="form-horizontal" role="form" method="post" action="/EmployeeWebApp/UpdateEmployee">
<div class="form-group">
		<label for="id" class="col-sm-2 control-label">Enter Id to update</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter employee id" value="">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
		</div>
	</div>
</form>
<form class="form-horizontal" role="form" method="post" action="/EmployeeWebApp/DeleteEmployee">
	<div class="form-group">
		<label for="id" class="col-sm-2 control-label">Enter Id</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter id to delete" value="">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="submit" type="submit" value="Delete Id" class="btn btn-primary">
		</div>
	</div>

</form>
//<c:if test="${requestScope.employee ne null}">
<form class="form-horizontal" role="form" method="post" action="/EmployeeWebApp/ViewAllEmployee">
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="View All" type="submit" value="Delete Id" class="btn btn-primary">
		</div>
	</div>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Gender</th>
                <th>Salary</th>
            </tr>
            <c:forEach var="user" items="${displayall}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastname}" /></td>
                    <td><c:out value="${user.Gender}" /></td>
                    <td><c:out value="${user.salary}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </form>
   // </c:if>

</body>
</html>