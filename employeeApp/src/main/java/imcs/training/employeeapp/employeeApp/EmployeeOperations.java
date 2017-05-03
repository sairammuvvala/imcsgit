package imcs.training.employeeapp.employeeApp;

/**
 * Created by Manohar on 4/21/2017.
 */
public interface EmployeeOperations {

    void createEmployee(Employee employee);

    Employee findEmployee(int empId);

    Employee[] findAll();

    boolean deleteEmployee(int empId);

    boolean updateEmployee(Employee employee);

    double displayHRA(int empId);

    Double calculateGrossSal(int empId);
}
