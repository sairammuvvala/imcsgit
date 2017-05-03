package arrayOperations;

import java.util.List;

public interface EmployeeOperations {

    void createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException;

    Employee findEmployee(int empId);

    List<Employee> findAll();

    boolean deleteEmployee(int empId);

    boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException;

    double displayHRA(int empId);

    Double calculateGrossSal(int empId);

	List<Employee> SortByName();

	List<Employee> sortBySalary();



	
}
