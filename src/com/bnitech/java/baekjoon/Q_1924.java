import java.util.Scanner;

public class Q_1924 {

	public static void main(String[] args) {
		new Q_1924().start();
	}
	
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		int numX = sc.nextInt();
		int numY = sc.nextInt();
		
		String week[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		int startDay = 0; //SuN ¥Ÿ¿Ω
		
		int month[] = {-1,31,28,31,30,31,30,31,31,30,31,30,31};

		System.out.println(week[result(startDay,numX,numY,month)]);
	}
	
	int result(int startDay,int numX, int numY,int[] month){
		for (int i = 1; i < month.length; i++) {
			if(i==numX){
				startDay += numY;
				break;
			}
			startDay += month[i];
		}
		return startDay%7;
	}
}
