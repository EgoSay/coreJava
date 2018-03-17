package fourth;

import java.time.LocalDate;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Li", 75000, 1987, 4, 12);
		staff[1]=new Employee("chen", 99999, 1991, 8, 1);
		staff[2]=new Employee("sun", 85000, 1986, 8, 15);
		for(Employee e:staff){
			e.raiseSalary(5);
			e.setId();
		}
		for(Employee e:staff){
			e.getId();
			System.out.println("name:"+e.getName()+"\nid="+e.getId()+"\tsalary:"+
					e.getSalary()+"\thireDay:"+e.getHirDay());
		}
		int n=Employee.getNextId();
		System.out.println("Next id="+n);
	}

}
class Employee
{
	private String name;
	private double salary;
	private LocalDate hirDay;
	private int id;
	private static int nextId=1;    //静态变量
	public Employee(String n, double s, int year,int month,int day) {
		name=n;
		salary=s;
		hirDay=LocalDate.of(year, month, day);
		id=0;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public LocalDate getHirDay() {
		return hirDay;
	}
	public void raiseSalary(double byPercent) 
	{
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = nextId;
		nextId++;
	}
	public static int getNextId() {
		return nextId;
	}
}