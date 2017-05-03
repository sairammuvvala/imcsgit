package arrayOperations;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	public enum Gender{
		FEMALE,MALE;
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private Address address;
	Employee manager;
	EmploymentPeriod period;
	Gender gender;
	
	

	public Employee() {
		super();
	}



	public Employee(int id) {
		super();
		this.id = id;
	}


	
	public Employee(int id, String firstName, String lastName, double salary,int gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		/*this.address = address;
		this.manager = manager;
		this.period = period;
		this.gender = gender;*/
		if(gender == 1){
			this.gender = Gender.MALE;
		}else if(gender == 2){
			this.gender = Gender.FEMALE;
		}
	}

	
	

	public double calculateHRA(){
		//System.out.println(salary);
		double hra = (salary)*(20.00/100.00);
		//System.out.println(hra);
		return hra;	
		
	}
	
	public double calculateGrossSal(){
		
		double grossSal = this.salary + calculateHRA();
		return grossSal;
		
		
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Employee getManager() {
		return manager;
	}



	public void setManager(Employee manager) {
		this.manager = manager;
	}



	public EmploymentPeriod getPeriod() {
		return period;
	}



	public void setPeriod(EmploymentPeriod period) {
		this.period = period;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	
	public static Comparator<Employee> EmployeeNameComparator
    = new Comparator<Employee>() {

		public int compare(Employee employee1, Employee employee2) {

			String e1 = employee1.getFirstName().toUpperCase();
			String e2 = employee2.getFirstName().toUpperCase();

			//ascending order
			return e1.compareTo(e2);


		}

	};

	public int compareTo(Employee employee) {

		double compareSalary = ((Employee) employee).getSalary();

		//ascending order
		return (int) (this.salary - compareSalary);

		//descending order
		//return compareQuantity - this.quantity;

	}



	@Override
	public String toString() {
		return "trng.Employee [id=" + id + ", firstName=" + firstName + ", LastName=" + lastName + ", salary=" + salary
				+ ", address=" + address + ", gender=" + gender + "]";
	}




	

	
}
