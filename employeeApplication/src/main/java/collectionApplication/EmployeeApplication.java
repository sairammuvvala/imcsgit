package collectionApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import arrayOperations.EmployeeCollectionOperations;
import arrayOperations.EmployeeCreationException;
import arrayOperations.InvalidSalaryException;
import arrayOperations.Employee;
import arrayOperations.Employee.Gender;
import arrayOperations.EmployeeOperations;
import arrayOperations.EmployeeUtil;



public class EmployeeApplication {

    private EmployeeOperations employeeOperations;
    public EmployeeApplication(){
    	employeeOperations=new EmployeeCollectionOperations();
    }
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        EmployeeApplication employeeApplication = new EmployeeApplication();
        
        System.out.println("************trng.Employee System**********");
        
        String sourceFile="G://Manoj//Software Engineering//IMCS//ClassTraining//PractiseTopics//bin//Book1.csv";
       employeeApplication.loadData(sourceFile);
        int choice = 0;
        int operations=0;
        boolean flag=true;
        while(flag==true){
        	try{
        		choice = EmployeeUtil.chooseOperation();
        		
        	}
        	catch(InputMismatchException exception){
        		System.out.println(exception + " Please enter the valid choice");
        		continue;
        		
        	}
            switch (choice) {
                case 1:
                	
                	try{
                		employeeApplication.add();
                		operations=1;
                	}
                	catch(EmployeeCreationException e){
                		System.out.println(e + "  Problem in adding the employee,Please check the data given");
                	}
                	catch(InvalidSalaryException e){
                		System.out.println(e + "  Problem in adding the employee,Please check the data given");
                	}
                    break;
                case 2:
                	operations=1;
                    employeeApplication.display();
                    break;
                case 3:
                	operations=1;
                    employeeApplication.displayAll();
                    break;
                case 4:
                	
                	try{
                		employeeApplication.update();operations=1;
                	}
                	catch(EmployeeCreationException e){
                		System.out.println(e + " problem updating the data");
                	}
                	catch(InvalidSalaryException e){
                		System.out.println(e + " problem updating the data");
                	}
                    break;
                case 5:
                	operations=1;
                    employeeApplication.delete();
                    break;
                case 6:
                	operations=1;
                    employeeApplication.displayHRA();
                    break;
                case 7:
                	operations=1;
                    employeeApplication.displayGrossSalary();
                    break;
                case 8:
                	operations = 1;
                	employeeApplication.sortData();
                	break;
               
                case 9:
                	operations = 1;
                	employeeApplication.getUniqueEmployees();
                	break;
                case 10:
                	operations = 1;
                	employeeApplication.getSalaryCount();
                	break;
                case 11:
                	if(operations==1){
                		employeeApplication.saveData(sourceFile);
                	}
                	flag=false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } 

        scanner.close();
    }
    
    

	











	private void loadData(String sourceFile) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("Loading data from file");
    	@SuppressWarnings("unused")
		String destination="G://Manoj//Software Engineering//IMCS//ClassTraining//PractiseTopics//bin//Error.csv";
    	
    	try(BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
    			FileWriter fw =new FileWriter("destination",true);){
			
			String line;
			while((line=bufferedReader.readLine())!=null){
				String data[] = line.split(",");
				
				
					try{
						
						int id = Integer.parseInt(data[0]);
						String firstName = data[1];
						String lastName = data[2];
						double salary = Double.parseDouble(data[3]);
						int gender = Integer.parseInt(data[4]);
						
						
						Employee emp = new Employee(id,firstName,lastName,salary,gender);
						
							employeeOperations.createEmployee(emp);
						
						
					}
					catch(EmployeeCreationException e){
						System.out.println(e +" Error in creating Employee, Please enter the valid data");
					}
					catch(InvalidSalaryException e){
						System.out.println(e + " Error in creating Employee, Please enter the valid data");
					}
					catch(InputMismatchException e){						
						fw.append(line);	
					}
					
				
			}
			
		}
	}
	
	
	 private  void saveData(String sourceFile) throws IOException {
			// TODO Auto-generated method stub
	    	List<Employee> employees = employeeOperations.findAll();
	    	try(FileWriter fw = new FileWriter(sourceFile,false);){
	    		for(Employee employee : employees){
	    			int gender = 0;
	    			if(employee.getGender() == Gender.valueOf("MALE")){
	    				gender=1;
	    			}
	    			else{
	    				gender=2;
	    			}
	    			String data = employee.getId() + "," +employee.getFirstName() + ","+employee.getLastName() + ","+employee.getSalary()+","+gender+"\n";
	    			fw.write(data);
	    		}
	    	}
	    	
			
		}



   
	

	private void displayGrossSalary() {
        System.out.println("Enter the employee id to calculte gross salary of employee");
        try{
        	int empNo = Integer.parseInt(scanner.next());
        	System.out.println("Gross Salary of employee id " + empNo + " is : " + employeeOperations.calculateGrossSal(empNo));
        }
        catch(InputMismatchException e){
        	System.out.println( e + " Please enter the valid id");
        }
        
        
    }

    private void displayHRA() {
        System.out.println("Enter the employee id to calculte hra of employee");
        try{
        	int number = Integer.parseInt(scanner.next());
        	System.out.println("Hra of employee id " + number + " is : " + employeeOperations.displayHRA(number));
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter the valid id");
        }
        
        
    }

    private void delete() {
        System.out.println("Enter the employee id to delete :");
        try{
        	int empId = scanner.nextInt();
        
        boolean flag = employeeOperations.deleteEmployee(empId);
        if (flag) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No employee found with given number : " + empId);
        }
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter the valid id");
        }
    }

    private void update() throws EmployeeCreationException, InvalidSalaryException {
        System.out.println("Enter Employees data for update:");
        Employee employee = EmployeeUtil.readEmployee();
        employeeOperations.updateEmployee(employee);
    }

    private void displayAll() {
        System.out.println("Employees in the system are :");
        List<Employee> employees = employeeOperations.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void display() {
        System.out.println("Enter the employee id to view employee info :");
        try{
        	int empId = scanner.nextInt();
        	Employee employee = employeeOperations.findEmployee(empId);
        	System.out.println(employee);
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter valid data");
        }
    }

    private void add() throws EmployeeCreationException, InvalidSalaryException {
        Employee employee = EmployeeUtil.readEmployee();
        employeeOperations.createEmployee(employee);
    }

    private void sortData() {
		// TODO Auto-generated method stub
    	boolean flag=true;
    	while(flag==true){
    		int sort=EmployeeUtil.sortDataUtil();
    	if(sort ==1 || sort ==2){
    		flag=false;
    		if(sort == 1){
    			displayList(employeeOperations.SortByName());
    		}
    	
    		else{
    			displayList(employeeOperations.sortBySalary());
    		}
    	}
    }
    	
		
	}



	private void displayList(List<Employee> sortByName) {
		// TODO Auto-generated method stub
		for(Employee e : sortByName){
			System.out.println(e.getId() +"  "+e.getFirstName()+"  "+e.getSalary());
		}
		
	}
	
	private void getUniqueEmployees() {
		// TODO Auto-generated method stub
		Set<Employee> unique=((EmployeeCollectionOperations) employeeOperations).uniqueEmployees();
		unique.forEach(System.out::println);
		
	}
	
	private void getSalaryCount() {
		// TODO Auto-generated method stub
		Map<Double,Integer> count = ((EmployeeCollectionOperations) employeeOperations).salaryCount();
		
		count.forEach((k,v)->System.out.println("Salary : " + k + " Count : " + v));
		
	}
	
	


}
