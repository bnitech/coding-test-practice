import java.util.Scanner;

public class Q_2294 {
	static int dp[][];
	public static void main(String[] args) {
		Q_2294 q_2294 = new Q_2294();
		q_2294.start();
	}
	
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		int numN  = sc.nextInt();
		int sum = sc.nextInt();
		
		dp = new int[sum][numN];
		
		int arr[] = new int[numN];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		coins(arr, sum);
	}
	
	void coins(int arr[], int sum){
		int tmpSum = sum;
		int min=100000000;
		int count=0;
		
		
		for (int st = arr.length-1; st > -1; st--) {
			
			for (int i = arr.length-1; i > -1; i--) {
				if(tmpSum>arr[i]){
					if(tmpSum%arr[i]==0){
						count += tmpSum/arr[i];
						break;
					}else{
						if(tmpSum - arr[i] > 0){
							tmpSum -= arr[i];
							count++;
						}
					}
				}
			}
			
			
			
			System.out.println(count);
		
			if(min > count){
					min = count;
			}
			
			count = 0;
			sum -= arr[st];
			tmpSum = sum;
			
			
			
		}
		System.out.println(min);
	}
	
}

