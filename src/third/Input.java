package third;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("What is your name?");
		String name=in.nextLine();
		System.out.println("How old are you?");
		int age=in.nextInt();
		System.out.println("Hello,"+name+"  Next year,you'll be"+(age+1));
		/*Scnner�಻�����ڴӿ���̨��ȡ���룬java SE6�ر�������Console��ʵ�����Ŀ��
		Console cons=System.console();
		if(cons!=null){
			PrintWriter out=cons.writer();
			cons.flush();
			String username=cons.readLine("User name:");
			char[] password=cons.readPassword("Password:");
		}*/
		//�ļ����������
		Scanner inFile1 = null;
		try {
			inFile1 = new Scanner(Paths.get("myfile.txt"), "UTF-8");
			System.out.println("��һ��û����������ǰ��"+inFile1.nextLine());
			PrintWriter out=new PrintWriter("myfile.txt","UTF-8");
			out.print(name+age);
			out.close();
			Scanner inFile2 = null;
			inFile2 = new Scanner(Paths.get("myfile.txt"), "UTF-8");
			System.out.println("�ڶ����������ݺ�"+inFile2.nextLine());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.toString();
		}
		in.close();
	}

}
