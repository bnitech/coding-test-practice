import java.util.Scanner;

public class Q_9455 {
	public static void main(String[] args) {
		new Q_9455().start();
	}
	
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		int numT = sc.nextInt();
		for (int i = 0; i < numT; i++) {
			int numM = sc.nextInt();
			int numN = sc.nextInt();
			boolean[][] matrix = new boolean[numM][numN];
			
			for (int j = 0; j < numM; j++) {
				for (int j2 = 0; j2 < numN; j2++) {
					if(sc.nextInt()==1)
						matrix[j][j2] = true;
				}
			}
			
			System.out.println(result(matrix, numM, numN));
		}
		
		
	}
	
	int result(boolean[][] matrix, int numM, int numN ){
		int count=0;
		for (int row = 0; row < numM; row++) {
			for (int col = 0; col < numN; col++) {
				
				if(matrix[row][col]){
					for (int i = row; i < numM; i++) {
						if(!matrix[i][col]){
							
							count++;
						}
					}
				}
			}
		}
	
		return count;
	}
}
