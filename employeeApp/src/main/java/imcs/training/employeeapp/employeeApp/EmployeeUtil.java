package imcs.training.employeeapp.employeeApp;

import java.util.Scanner;

public class EmployeeUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static int chooseOperation() {
        System.out.println();
        System.out.println("   ||| MENU |||   ");
        System.out.println("1. Create trng.Employee");
        System.out.println("2. Read(View) trng.Employee");
        System.out.println("3. View all Employees");
        System.out.println("4. Update trng.Employee");
        System.out.println("5. Delete trng.Employee");
    /*    System.out.println("6. Calculate HRA");
        System.out.println("7. Calculate Gross Salary");
        System.out.println("8. Exit");*/


        System.out.print("Select a choice :");
        return scanner.nextInt();
    }

    public static Employee readEmployee() {
       /* System.out.print("Enter trng.Employee id:");
        int id = scanner.nextInt();*/

        System.out.print("Enter trng.Employee firstname:");
        String firstName = scanner.next();

        System.out.print("Enter trng.Employee lastname:");
        String lastName = scanner.next();
        
        System.out.println("Select the gender");
        System.out.println("	1.Male");
        System.out.println("	2.Female");

        int gender = scanner.nextInt();

        System.out.print("Enter trng.Employee Salary:");
        double salary = scanner.nextDouble();

        
        return new Employee( firstName, lastName, gender,salary);
    }
    
    public static Employee updateEmployee() {
         /*System.out.print("Enter trng.Employee id:");
         int id = scanner.nextInt();*/

         System.out.print("Enter trng.Employee firstname:");
         String firstName = scanner.next();

         System.out.print("Enter trng.Employee lastname:");
         String lastName = scanner.next();
         
         System.out.println("Select the gender");
         System.out.println("	1.Male");
         System.out.println("	2.Female");

         int gender = scanner.nextInt();

         System.out.print("Enter trng.Employee Salary:");
         double salary = scanner.nextDouble();
         
         System.out.print("Enter trng.Employee id:");
         int id = scanner.nextInt();

         
         return new Employee(firstName, lastName, gender,salary,id);
     }
}
