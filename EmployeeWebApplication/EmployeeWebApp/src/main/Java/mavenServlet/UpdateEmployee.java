package mavenServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.training.employeeapp.employeeApp.Employee;
import imcs.training.employeeapp.employeeApp.JdbcOperations;
import imcs.training.employeeapp.employeeApp.Employee.Gender;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JdbcOperations ops =new JdbcOperations();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		Employee employee = new Employee();
		
		
		//String id=request.getParameter("id");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String id = request.getParameter("id");
		
		
		employee.setId(Integer.parseInt(id));
		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		employee.setGender(Gender.valueOf(gender.toUpperCase()));
		employee.setSalary(Double.parseDouble(salary));
		//employee.setId(Integer.parseInt(id));
		//doGet(request, response);
		
		try {
			ops.update(employee);
			
				pw.println("<html><h3>Employee Successfully updated into database</h3></html>");
				//pw.println("<html><a href='http://localhost:8080/WebApp/read.html'>View Employee</a></html>");
				
			
			/*else
				System.out.println(" Error \n Employee not inserted into database");*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		doGet(request, response);
	}

}
