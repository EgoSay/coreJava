package third;
import java.math.*;
import java.util.Scanner;
//模拟彩票抽奖
public class BigIntegerTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		boolean flag = true;
		while(flag){
		System.out.println("How many numbers do you need to draw?");
		int k=in.nextInt();
		System.out.println("what is the highest numbers you can draw?");
		int n=in.nextInt();
		BigInteger lotteryodds=BigInteger.valueOf(1);
		for(int i=1;i<=k;i++)
		{
			lotteryodds=lotteryodds.multiply(BigInteger.valueOf(n-i+1)).
					divide(BigInteger.valueOf(i));
		}
		System.out.println("Yourodds are 1 in"+lotteryodds+".Good luck!");
		int[] nums=new int[n];
		for(int i=0;i<nums.length;i++) {
            nums[i] = i + 1;
        }
		int[] result=new int[k];
		for(int i=0;i<result.length;i++)
		{
			int r=(int)(Math.random()*n);
			result[i]=nums[r];
			nums[r]=nums[n-1];
			n--;
		}
		System.out.println("中奖号码为：");
		for(int k1:result) {
            System.out.println(k1);
        }
		System.out.println("是否继续？");
		String str=in.next();
		if(!("yes".equalsIgnoreCase(str) | "y".equalsIgnoreCase(str)))
		{
			flag=false;
			System.out.println("程序执行完毕退出");
		}
		}
		/*int lotteryodds=1;
		for(int i=1;i<=k;i++)lotteryodds=lotteryodds*(n-i+1)/i;
		System.out.println("Yourodds are 1 in"+lotteryodds+".Good luck!");*/
	}
}
