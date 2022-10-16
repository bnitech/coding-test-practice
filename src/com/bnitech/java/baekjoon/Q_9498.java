import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_9498 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		new Q_9498().start(br);
	}
	
	void start(BufferedReader br) throws Exception {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numN = Integer.parseInt(st.nextToken());
		
		if(numN <= 100 && numN >= 90){
			System.out.println("A");
		}else if(numN <= 90 && numN >= 80){
			System.out.println("B");
		}else if(numN < 80 && numN >= 70){
			System.out.println("C");
		}else if(numN < 70 && numN >= 60){
			System.out.println("D");
		}else{
			System.out.println("F");
		}
	}

}
