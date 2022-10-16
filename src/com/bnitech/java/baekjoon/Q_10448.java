
public class Q_10448 {

	public static void main(String[] args) {
		Q_10448 q_10448 = new Q_10448();
		q_10448.start();
	}
	
	
	public void start(){
		Scan sc = new Scan();
		
		int numCase = sc.nextInt();
		
		int[] numK = new int[numCase];
		
		int max=0;
		for (int i = 0; i < numCase; i++) {
			numK[i] = sc.nextInt();
			if(max < numK[i]){
				max = numK[i]; 
			}
		}
		
		int[] T = new int[max];
		for (int i = 1; i < T.length; i++) {
			T[i] = i*(i+1)/2;
		}
		
		for (int i = 0; i < numCase; i++) {
			search3(numK[i], T);
		}
		
	}
	
	public void search3(int numK, int[] T){
		
		
		int maxT = numK;
		for (int i = 1; i < T.length; i++) {
			int count = 0;
			for (int j = i; j < T.length; j++) {
				while(count < 4){
					maxT = maxT - T[i];
					count++;
				}
			}
		}
		
	}
}
