import java.util.Deque;
import java.util.LinkedList;

public class Q_2631 {

	public static void main(String[] args) {
		Q_2631 q_2631 = new Q_2631();
		q_2631.start();
	}
	
	
	public void start(){
		Scan sc = new Scan();

		LinkedList<Integer> child = new LinkedList<Integer>();
		int numN = sc.nextInt();
		int[] dp = new int[numN];
		
		for (int i = 0; i < numN; i++) {
			child.add(sc.nextInt());
		}
		
		line(child, dp);
	}


	private void line(LinkedList<Integer> child, int[] dp) {
		for (int i = 0; i < child.size(); i++) {
			int start = child.get(i);
		}
		
	}
}
