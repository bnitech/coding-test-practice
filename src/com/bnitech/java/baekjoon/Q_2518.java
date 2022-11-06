
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Familys{
	
	Queue<Integer> foodList = new LinkedList<Integer>();
	boolean dir;
	int numN, minDis, idx; 
	float half, mid;
	
	public Familys(int numN, int idx){
		this.numN = numN;
		this.idx = idx;
		
		half = numN/2;
		
		if(idx<half) mid = idx+half;
		else mid = idx-half;
	}
	
	int getFood(){
		if(foodList.isEmpty())
			return -1;
		else
			return foodList.peek();
	}
	
	void moveFamily(boolean Dir){
		if(Dir){
			this.idx++;
			if(idx>numN) idx=1;
		}else{
			this.idx--;
			if(idx<1) idx=numN;
		}
		
		if(idx<half) mid = idx+half;
		else mid = idx-half;
	}

	void findDir_fidMidDis(){
		if(foodList.isEmpty()){
			return;
		}
		
		// idx가 half 보다 작으면 , idx 보다 큰 타겟 중  mid 보다  크면 오른쪽으로
		// idx가 half 보다 크면, idx 보다 작은 타겟 중  mid 보다 작으면 왼쪽으로  		  
		if(idx<half){
			if(foodList.peek() > idx){
				if(foodList.peek() > mid){
					minDis = idx + numN - foodList.peek();
					dir=false;
				}else{
					minDis = foodList.peek() - idx;
					dir=true;
				}
			}else{
				minDis = idx - foodList.peek();
				dir=false;
			}
		}else{
			if(foodList.peek() < idx){
				if(foodList.peek() < mid){
					minDis = idx + numN - foodList.peek();
					dir=true;
				}else{
					minDis = idx - foodList.peek();
					dir=false;
				}
			}else{
				minDis = foodList.peek() - idx;
				dir=true;
			}
		}
	
	}
}

public class Q_2518 {


	public static void main(String[] args) {
		Q_2518 q_2518 = new Q_2518();
		q_2518.start();
	}
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		int numN = sc.nextInt();
		Familys family[] = new Familys[3];

		int numEat=0;
		for (int i = 0; i < family.length; i++) {
			int numPI = sc.nextInt();
			family[i] = new Familys(numN,((numN/3)*i)+1);
			
			for (int j = 0; j < numPI ; j++) {
				family[i].foodList.offer(sc.nextInt());
				numEat++;
			}
			
			family[i].findDir_fidMidDis();
		}
		
		System.out.println(result(family,numEat));
	
	}

	private int result(Familys[] family,int numEat) {
		
		int count=1, cntMove=0;
		while(count < numEat){
			
			for (int i = 0; i < family.length; i++) {
				if(family[i].idx == family[i].getFood()){
					family[i].foodList.poll();
					family[i].findDir_fidMidDis();
					count++;
				}
				
				System.out.println(i+" , "+family[i].idx+" , "+family[i].getFood() +" , "+family[i].dir );
				
			}
			
			cntMove += tableMove(family,family[compareDis(family)].dir);
		}
		
		return cntMove;
	}

	private int compareDis(Familys[] family) {

		int who = 0;
		int min = family[who].numN;
		
		for (int i = 0; i < family.length; i++) {
			if(min > family[i].minDis){
				min = family[i].minDis;
				who = i;
			}
		}
		System.out.println("[ "+who+" ]");
		return who;
	}
	

	private int tableMove(Familys[] family, boolean dir) {
		for (int i = 0; i < family.length; i++) {
			family[i].moveFamily(dir);
			family[i].findDir_fidMidDis();
		}
		if(dir)
			System.out.print("R");
		else
			System.out.print("L");
		return 1;
	}
	

}
