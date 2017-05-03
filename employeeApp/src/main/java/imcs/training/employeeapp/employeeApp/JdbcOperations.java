package imcs.training.employeeapp.employeeApp;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import imcs.training.employeeapp.employeeApp.Employee.Gender;

public class JdbcOperations implements Jdbcinterface {
	
	JdbcOperations ops;
	PreparedStatement ps;
	
	Connection con;
	
	public Connection connectionCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false","root","weblogic@93");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	
	
	@Override
	public void create(Employee employee) throws SQLException {
		
		
		ops = new JdbcOperations();
		con = ops.connectionCon();
		
		try {
		    ps = con.prepareStatement("insert into employee (firstname,lastname,gender,salary) values(?,?,?,?)");
		   // ps.setInt(1,employee.getId() );
		    ps.setString(1, employee.getFirstName());
		    ps.setString(2, employee.getLastName());
		    ps.setString(3, employee.getGender().toString());
		    ps.setDouble(4, employee.getSalary());
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("Inserted");
		    } else {
		        System.out.println("not Inserted");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}


	@Override
	public Employee read(int id) throws SQLException {
		
		ops = new JdbcOperations();
		con = ops.connectionCon();
		Employee employee= new Employee();
		try {
		    ps = con.prepareStatement("select * from employee where code=?");
		    ps.setInt(1, id);
		    ResultSet res = ps.executeQuery();
		    if (res.next()) {
		    	employee.setId(res.getInt("id"));
				employee.setFirstName(res.getString("firstname"));
				employee.setFirstName(res.getString("lastname"));
				employee.setGender(Gender.valueOf(res.getString("gender")));
				employee.setSalary(res.getDouble("salary"));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean update(Employee employee) throws SQLException {
		
		ops = new JdbcOperations();
		con = ops.connectionCon();
		try {
		   
			ps = con.prepareStatement("update employee set firstname=?,lastname=?,gender=?,salary=?  where id = ? and flag=1");
			
			ps.setString(1,employee.getFirstName());
		    
		    ps.setString(2,employee.getLastName() );
		    ps.setString(3, employee.gender.toString());
		    ps.setDouble(4, employee.getSalary());
		    ps.setInt(5, employee.getId());
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("updated");
		    } else {
		        System.out.println("not updated");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean delete(int id2) throws SQLException {
		
		ops = new JdbcOperations();
		con = ops.connectionCon();
	
		try {
		    ps = con.prepareStatement("delete from employee where code=?");
		    ps.setInt(1, id2);
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("deleted");
		    } else {
		        System.out.println("not deleted");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return false;
	}


	


	@Override
	public List<Employee> displayAl() throws SQLException {
		
		ops = new JdbcOperations();
		con = ops.connectionCon();
		List<Employee> employee = new ArrayList<Employee>();
		try {
		    Statement st = con.createStatement();
		    ResultSet res = st.executeQuery("select * from employee");
		    while (res.next()) {
		    	Employee emp = new Employee();
				emp.setId(res.getInt("id"));
				emp.setFirstName(res.getString("firstname"));
				emp.setLastName(res.getString("lastname"));
				emp.setGender(Gender.valueOf(res.getString("gender")));
				emp.setSalary(res.getDouble("salary"));
				employee.add(emp);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return employee;
	}



}
