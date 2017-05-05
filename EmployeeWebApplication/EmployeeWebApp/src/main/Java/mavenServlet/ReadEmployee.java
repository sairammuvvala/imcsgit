package mavenServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.training.employeeapp.employeeApp.Employee;
import imcs.training.employeeapp.employeeApp.JdbcOperations;

/**
 * Servlet implementation class EmployeeRead
 */
public class ReadEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JdbcOperations ips =new JdbcOperations();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadEmployee() {
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
		String id = request.getParameter("id");
		
		try {
			Employee employee= ips.read(Integer.parseInt(id));
			//System.out.println(employee);
			if((employee.getId())!=0){
				pw.println("<html><table align='center' border=2>");
				pw.println("<h3 align='center'>Employee Details </h3>");
				 pw.println("<tr><td>id</td><td>"+employee.getId()+"</td></tr>");
				 pw.println("<tr><td>firstname</td><td>"+employee.getFirstName()+"</td></tr>");
				 pw.println("<tr><td>lastname</td><td>"+employee.getLastName()+"</td></tr>");
				 pw.println("<tr><td>gender</td><td>"+employee.getGender()+"</td></tr>");
				 pw.println("<tr><td>salary</td><td>"+employee.getSalary()+"</td></tr>");
				 pw.println("</table></html>");
					
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
				rd.forward(request, response);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	}
}
