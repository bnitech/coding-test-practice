import java.util.Scanner;

public class Q_1521_2 {

	
	public static void main(String[] args) {
		Q_1521_2 q_1520 = new Q_1521_2();
		q_1520.start();
	}
	public void start(){
		Scanner sc = new Scanner(System.in);
		int numM = sc.nextInt();
		int numN = sc.nextInt();
		
		int[][] arr = new int[numM+2][numN+2];
		int[][] dp = new int[numM+2][numN+2];
		
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr[0].length-1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				
				if(i==0 || j==0){
					dp[i][j]=-1;
				}
				
				if(i==arr.length-1 || j==arr[0].length-1){
					dp[i][j]=-1;
				}
			}
		}
		init(arr,dp);
		
		System.out.println(moveMan(dp));

		
	}
	private void init(int[][] arr, int[][] dp) {
		
		// 나에게 오는 선 갯수
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr[0].length-1; j++) {
				if(i==1 && j==1){
					if(arr[i][j+1] < arr[i][j]){
						dp[i][j]++;
					}
					if(arr[i+1][j] < arr[i][j]){
						dp[i][j]++;
					}
					continue;
				}
				
				if(arr[i-1][j] > arr[i][j]){
					dp[i][j]++;
				}
				if(arr[i][j-1] > arr[i][j]){
					dp[i][j]++;
				}
				if(arr[i][j+1] > arr[i][j]){
					dp[i][j]++;
				}
				
			}
		}
		
		checkBlock(arr,dp);
	}
	
	private void checkBlock(int[][] arr, int[][] dp){
		
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr[0].length-1; j++) {
				if(i==1 && j==1){
					continue;
				}
				if(arr[i-1][j] > arr[i][j] && dp[i-1][j]==0){
					dp[i][j]--;
				}
				if(arr[i][j-1] > arr[i][j] && dp[i][j-1]==0){
					dp[i][j]--;
				}
				if(arr[i][j+1] > arr[i][j] && dp[i][j+1]==0){
					dp[i][j]--;
				}
				
			}
		}
		
	}

	private int moveMan(int[][] dp){
		int count=0;
		for (int i = dp.length-2; i > 0; i--) {
			for (int j = dp[0].length-2; j > 0; j--) {
				if(dp[i][j]>1){
					count+=dp[i][j]-1;
				}
			}
		}
		return count;
	}

}
