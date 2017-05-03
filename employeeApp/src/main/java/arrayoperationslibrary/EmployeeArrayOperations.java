package arrayoperationslibrary;

import java.util.Arrays;

public class EmployeeArrayOperations implements EmployeeOperations{

    private Employee[] employees;
    private int size;

    public EmployeeArrayOperations(int size) {
        employees = new Employee[size];
    }

    public void createEmployee(Employee employee) {
        if (size == employees.length) {
            resizeEmployees();
        }

        employees[size++] = employee;
    }

    private void resizeEmployees() {
        employees = Arrays.copyOf(employees, size * 2);
    }

    public Employee findEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == empId) {
                return employees[i];
            }
        }
        return null;
    }

    public Employee[] findAll() {
        return Arrays.copyOfRange(employees, 0, size);
    }

    public boolean deleteEmployee(int empId) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {

            if (employees[i].getId() == empId) {
                employees[i] = null;                                    //delete by making it null
                for (int j = i; j < size-1; j++) {
                    employees[j] = employees[j + 1];                       // shift
                }
                flag = true;
                employees[size--] = null;
            }
        }
        return flag;
    }

    public boolean updateEmployee(Employee employee) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employee.getId()) {
                employees[i] = employee;
                flag = true;
            }
        }
        return flag;
    }


    public double displayHRA(int empId) {
        double hra = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == empId) {
                hra = employees[i].calculateHRA();
                break;
            }
        }

        return hra;
    }

    public Double calculateGrossSal(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == empId) {
                return employees[i].calculateGrossSal();
            }
        }
        return null;
    }
}
