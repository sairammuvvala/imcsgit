package imcs.training.employeeapp.employeeApp;

public class Employee {

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


	
	public Employee(String firstName, String lastName, int gender,double salary) {
		super();
		//this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		/*this.address = address;
		this.manager = manager;
		this.period = period;
		this.gender = gender;*/
		if( gender== 1){
			this.gender = Gender.MALE;
		}else if(gender == 2){
			this.gender = Gender.FEMALE;
		}
	}

	
	

	public Employee(String firstName, String lastName, int gender, double salary,int id) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		/*this.address = address;
		this.manager = manager;
		this.period = period;
		this.gender = gender;*/
		if( gender== 1){
			this.gender = Gender.MALE;
		}else if(gender == 2){
			this.gender = Gender.FEMALE;
		}
		this.id = id;
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
	public String toString() {
		return "trng.Employee [id=" + id + ", firstName=" + firstName + ", LastName=" + lastName + ", salary=" + salary
				+ ", address=" + address + ", gender=" + gender + "]";
	}
	

	
}
