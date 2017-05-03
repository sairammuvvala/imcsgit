package jdbcApplication;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import imcs.training.employeeapp.employeeApp.Employee;
import imcs.training.employeeapp.employeeApp.JdbcOperations;

import static imcs.training.employeeapp.employeeApp.EmployeeUtil.chooseOperation;
import static imcs.training.employeeapp.employeeApp.EmployeeUtil.readEmployee;
import static imcs.training.employeeapp.employeeApp.EmployeeUtil.updateEmployee;

public class EmployeeApplication {

   // private EmployeeOperations employeeOperations = null;
	JdbcOperations ops=new JdbcOperations(); 
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        EmployeeApplication employeeApplication = new EmployeeApplication();
        System.out.println("************trng.Employee System**********");
       // employeeApplication.initme();
        int choice;
        do {
            choice = chooseOperation();

            switch (choice) {
                case 1:
                    employeeApplication.add();
                    break;
                case 2:
                    employeeApplication.display();
                    break;
                case 3:
                    employeeApplication.displayAll();
                    break;
                case 4:
                    employeeApplication.update();
                    break;
                case 5:
                    employeeApplication.delete();
                    break;
               /* case 6:
                    employeeApplication.displayHRA();
                    break;
                case 7:
                    employeeApplication.displayGrossSalary();
                    break;*/
                case 8:
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 8);

        scanner.close();
    }

    

/*	private void displayGrossSalary() {
        System.out.println("Enter the employee id to calculte gross salary of employee");
        int empNo = scanner.nextInt();
        System.out.println("Gross Salary of employee id " + empNo + " is : " + employeeOperations.calculateGrossSal(empNo));
    }

    private void displayHRA() {
        System.out.println("Enter the employee id to calculte hra of employee");
        int number = scanner.nextInt();
        System.out.println("Hra of employee id " + number + " is : " + employeeOperations.displayHRA(number));
    }*/

    private void delete() throws SQLException {
        System.out.println("Enter the employee id to delete :");
        int empId = scanner.nextInt();
        boolean flag = ops.delete(empId);
        if (flag) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No employee found with given number : " + empId);
        }
    }

    private void update() throws SQLException {
        System.out.println("Enter Employees data for update:");
        Employee employee = updateEmployee();
        ops.update(employee);
    }

    private void displayAll() throws SQLException {
        System.out.println("Employees in the system are :");
        List<Employee> employees = ops.displayAl();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void display() throws SQLException {
        System.out.println("Enter the employee id to view employee info :");
        int empId = scanner.nextInt();
        Employee employee = ops.read(empId);
        System.out.println(employee);
    }

    private void add() throws SQLException {
        Employee employee = readEmployee();
        ops.create(employee);
    }

    /*private void initme() {
        System.out.print("How many Employees do you wish to create? ");
        employeeOperations = new EmployeeArrayOperations(2);
    }*/


}
