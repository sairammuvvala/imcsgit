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
 * Servlet implementation class EmployeeCreation
 */
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JdbcOperations ops =new JdbcOperations();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//String id=request.getParameter("id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lasttname");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		
		Employee employee = new Employee();
		//employee.setId(Integer.parseInt(id));
		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		employee.setGender(Gender.valueOf(gender.toUpperCase()));
		employee.setSalary(Double.parseDouble(salary));
		//doGet(request, response);
		
		try {
			ops.create(employee);
			
				pw.println("<html><h3>Employee Successfully inserted into database</h3></html>");
				//pw.println("<html><a href='http://localhost:8080/WebApp/read.html'>View Employee</a></html>");
				
			
			/*else
				System.out.println(" Error \n Employee not inserted into database");*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
