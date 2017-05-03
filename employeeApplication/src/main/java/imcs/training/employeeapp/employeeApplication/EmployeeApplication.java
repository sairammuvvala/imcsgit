package imcs.training.employeeapp.employeeApplication;

import java.util.Scanner;

import imcs.training.employeeapp.employeeApp.Employee;
import imcs.training.employeeapp.employeeApp.EmployeeArrayOperations;
import imcs.training.employeeapp.employeeApp.EmployeeOperations;

import static imcs.training.employeeapp.employeeApp.EmployeeUtil.chooseOperation;
import static imcs.training.employeeapp.employeeApp.EmployeeUtil.readEmployee;

public class EmployeeApplication {

    private EmployeeOperations employeeOperations = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeApplication employeeApplication = new EmployeeApplication();
        System.out.println("************trng.Employee System**********");
        employeeApplication.initme();
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
                case 6:
                    employeeApplication.displayHRA();
                    break;
                case 7:
                    employeeApplication.displayGrossSalary();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 8);

        scanner.close();
    }

    private void displayGrossSalary() {
        System.out.println("Enter the employee id to calculte gross salary of employee");
        int empNo = scanner.nextInt();
        System.out.println("Gross Salary of employee id " + empNo + " is : " + employeeOperations.calculateGrossSal(empNo));
    }

    private void displayHRA() {
        System.out.println("Enter the employee id to calculte hra of employee");
        int number = scanner.nextInt();
        System.out.println("Hra of employee id " + number + " is : " + employeeOperations.displayHRA(number));
    }

    private void delete() {
        System.out.println("Enter the employee id to delete :");
        int empId = scanner.nextInt();
        boolean flag = employeeOperations.deleteEmployee(empId);
        if (flag) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No employee found with given number : " + empId);
        }
    }

    private void update() {
        System.out.println("Enter Employees data for update:");
        Employee employee = readEmployee();
        employeeOperations.updateEmployee(employee);
    }

    private void displayAll() {
        System.out.println("Employees in the system are :");
        Employee[] employees = employeeOperations.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void display() {
        System.out.println("Enter the employee id to view employee info :");
        int empId = scanner.nextInt();
        Employee employee = employeeOperations.findEmployee(empId);
        System.out.println(employee);
    }

    private void add() {
        Employee employee = readEmployee();
        employeeOperations.createEmployee(employee);
    }

    private void initme() {
        System.out.print("How many Employees do you wish to create? ");
        employeeOperations = new EmployeeArrayOperations(2);
    }


}
