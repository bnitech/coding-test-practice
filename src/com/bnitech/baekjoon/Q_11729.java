import java.util.Stack;

public class Q_11729 {

	public static void main(String[] args) {
		Q_11729 q_11729 = new Q_11729();
		q_11729.start();
	}
	
	
	public void start(){
		Scan sc = new Scan();
		
		int numN = sc.nextInt();
		

		Stack<Integer> pan1 = new Stack<Integer>();
		Stack<Integer> pan2 = new Stack<Integer>();
		Stack<Integer> pan3 = new Stack<Integer>();	
		
		for (int i = 1; i <= numN; i++) {
			pan1.push(i);
		}
		
		
		
		move(numN, pan1, pan2, pan3);
	}
	
	public void move(int numN, Stack<Integer> pan1, Stack<Integer> pan2, Stack<Integer> pan3){
		
		int temp =0;
		if(numN%2==0){
			temp = pan1.pop();
			pan2.push(temp);
		}else{
			temp = pan1.pop();
			pan3.push(temp);
		}
		
		
	}
}
