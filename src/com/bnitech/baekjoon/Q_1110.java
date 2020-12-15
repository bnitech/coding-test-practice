import java.util.Arrays;
import java.util.Scanner;

public class Q_1110 {
	public static void main(String[] args) {
		new Q_1110().start();
	}
	
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		int numN = sc.nextInt();
		int num[] = {numN/10, numN%10};
		
		System.out.println(countCycle(num));
		
	}
	int countCycle(int[] num){
		int cycle = 1;
		int[] su = num.clone();
		
		while(true){
			
			int sum = su[0] + su[1];
			sum = sum%10;
			
			int newSu[] = {su[1],sum};
			
			if(Arrays.equals(newSu, num)){
				return cycle;
			}else{
				cycle++;
				su = newSu.clone();
			}
		}
	}
}
