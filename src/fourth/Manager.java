package fourth;

public class Manager extends Employee {
	private double bonus;
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bonus=0;
		// TODO �Զ����ɵĹ��캯�����
	}
	@Override
	public double getSalary() {
		// TODO �Զ����ɵķ������
		double baseSalary= super.getSalary();
		return baseSalary+bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
