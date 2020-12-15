import java.util.Scanner;

public class Q_6359 {
	public static void main(String[] args) {
		Q_6359 q_6359 = new Q_6359();
		q_6359.start();
	}

	private void start() {

		Scanner sc = new Scanner(System.in);
		
		int numT = sc.nextInt();
		int numN[] = new int[numT];
		int result[] = new int[numT];
		boolean[] roomClose = new boolean[numT]; 
		
		for (int i = 0; i < numT; i++) {

			roomClose = new boolean[sc.nextInt()+1];
			
			
			result[i] = escape(roomClose); 
		}
		
		for (int i = 0; i < numT; i++) {
			System.out.println(result[i]);
		}
		
		
		
	}
	int escape(boolean[] roomClose){
		for (int i = 2; i < roomClose.length; i++) {
			for (int j = 1; j < roomClose.length; j++) {
				if(j%i==0){
					if(roomClose[j]) roomClose[j] = false;
					else roomClose[j] = true;
				}
			}
		}
		
		return check(roomClose);
	}
	
	int check(boolean[] roomClose){
		int count =0;
		for (int i = 1; i < roomClose.length; i++) {
			if(!roomClose[i]){
				count++;
			}
		}
		return count;
	}
}
