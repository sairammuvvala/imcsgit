package mavenServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.training.employeeapp.employeeApp.Employee;
import imcs.training.employeeapp.employeeApp.JdbcOperations;

/**
 * Servlet implementation class ViewAllEmployee
 */
public class ViewAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JdbcOperations ops =new JdbcOperations();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployee() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			List<Employee> employee = ops.displayAl();
			request.setAttribute("displayall", employee ); 
			RequestDispatcher rd = request.getRequestDispatcher("readEmployee.jsp");
			rd.forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
