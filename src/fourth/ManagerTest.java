package fourth;

public class ManagerTest {
	public static void main(String[] args) {
		Manager boss=new Manager("Li", 80000, 1987, 12, 15);
		boss.setBonus(10000);
		Employee[] staff=new Employee[3];
		/*������������ÿ���ת���ɳ�����������ã�Ȼ�����ܽ�һ����������ø����������
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
