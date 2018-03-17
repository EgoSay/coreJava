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
		/*Scnner类不适用于从控制台读取密码，java SE6特别引入了Console类实现这个目的
		Console cons=System.console();
		if(cons!=null){
			PrintWriter out=cons.writer();
			cons.flush();
			String username=cons.readLine("User name:");
			char[] password=cons.readPassword("Password:");
		}*/
		//文件输入与输出
		Scanner inFile1 = null;
		try {
			inFile1 = new Scanner(Paths.get("myfile.txt"), "UTF-8");
			System.out.println("第一次没有输入数据前："+inFile1.nextLine());
			PrintWriter out=new PrintWriter("myfile.txt","UTF-8");
			out.print(name+age);
			out.close();
			Scanner inFile2 = null;
			inFile2 = new Scanner(Paths.get("myfile.txt"), "UTF-8");
			System.out.println("第二次输入数据后："+inFile2.nextLine());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.toString();
		}
		in.close();
	}

}
