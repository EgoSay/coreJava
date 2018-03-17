package fourth;

public class Manager extends Employee {
	private double bonus;
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bonus=0;
		// TODO 自动生成的构造函数存根
	}
	@Override
	public double getSalary() {
		// TODO 自动生成的方法存根
		double baseSalary= super.getSalary();
		return baseSalary+bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
