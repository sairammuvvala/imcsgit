<html>
<body>
<h2 align="center">Create Employee</h2>

<!-- <form action="EmployeeCreation" method="post">
<table align="center" border=2>
<tr><td>firstname</td><td><input type="text" name="firstname"></input></td></tr>
<tr><td>lastname</td><td><input type="text" name="lastname"></input></td></tr>
<tr><td>gender</td><td><input type="text" name="gender"></input></td></tr>
<tr><td>salary</td><td><input type="number" name="salary"></input></td></tr>
<tr><td></td><td><input type="submit" name="submit"></input></td></tr>
</table>

</form> -->


<form class="form-horizontal" role="form" method="post" action="/EmployeeWebApp/CreateEmployee">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">FirstName</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="firstname" name="firstname" placeholder="FirstName" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">LastName</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="lastname" name="lastname" placeholder="LastName" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="gender" class="col-sm-2 control-label">Gender</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="gender" name="gender" placeholder="Male ot Female" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="salary" class="col-sm-2 control-label">Salary</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="salary" name="salary" placeholder="Enter > 20000" value="">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
		</div>
	</div>
	<!-- <div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<! Will be used to display an alert to the user>
		</div>
	</div> -->
</form>
</body>
</html>