package fourth;

public class ManagerTest {
	public static void main(String[] args) {
		Manager boss=new Manager("Li", 80000, 1987, 12, 15);
		boss.setBonus(10000);
		Employee[] staff=new Employee[3];
		/*子类数组的引用可以转换成超类数组的引用，然而不能将一个超类的引用赋给子类变量
		Manager[] managers=new Manager[3];
		Employee[] sta=managers;
		sta[0]=new Employee("wang", 99999, 1991, 8, 1);
		managers[0].setBonus(9000);
		*/
		staff[0]=boss;
		staff[1]=new Employee("chen", 99999, 1991, 8, 1);
		staff[2]=new Employee("sun", 85000, 1986, 8, 15);
		for(Employee e:staff){
			e.setId();
			System.out.println("name:"+e.getName()+"\nid="+e.getId()+"\tsalary:"+
					e.getSalary()+"\thireDay:"+e.getHirDay());
		}
	}
}
