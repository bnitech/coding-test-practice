import java.util.Scanner;

public class Q_3028 {

	public static void main(String[] args) {
		Q_3028 q_3028 = new Q_3028();
		q_3028.start();
	}
	
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		char[] input = sc.nextLine().toCharArray();
		
		System.out.println(result(input));
	}
		
	int result(char[] input){
		int[] cup = new int[3];
		cup[0] = 1;
		
		for (int i = 0; i < input.length; i++) {
		
			if(input[i] == 'A'){
				int temp = cup[0];
				cup[0] = cup[1];
				cup[1] = temp; 
			}else if(input[i] == 'B'){
				int temp = cup[1];
				cup[1] = cup[2];
				cup[2] = temp; 
			}else if(input[i] == 'C'){
				int temp = cup[0];
				cup[0] = cup[2];
				cup[2] = temp; 
			}
		}
		
		for (int i = 0; i < cup.length; i++) {
			if(cup[i]==1){
				return i+1;
			}
		}
		
		return -1;
	}
}
