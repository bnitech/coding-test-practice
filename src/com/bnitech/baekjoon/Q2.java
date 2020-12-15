
public class Q2 {

	public static void main(String[] args) {
		//System.out.println(Sol1(5));
		
		int F[] =new int[5+1];
		System.out.println(Sol2(F,5));
	}
	static int Sol1(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
	
		return Sol1(n-1) + Sol1(n-2); 
	}
	static int Sol2(int F[], int n){
		
		F[0]=0;
		F[1]=1;
		
		int i=2;
		while(i<=n){
			F[i] = F[i-1] + F[i-2];
			i++; 
		}
		
		return F[n];
		
	}
}
