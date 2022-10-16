import java.util.Scanner;

public class Q_1008 {

	public static void main(String[] args) {
		new Q_1008().start();
	}
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		double numA = sc.nextInt();
		double numB = sc.nextInt();
		
		double result = numA/numB;
		
		System.out.println(result);
	}
}
