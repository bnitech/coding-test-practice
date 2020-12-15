import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q_10814{
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_10814().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
	
		AgeName[] ageName = new AgeName[numN];
		
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			ageName[i] = new AgeName(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		
		
		Arrays.sort(ageName);
		
		for (AgeName temp : ageName) {
			System.out.print(temp.age+" ");
			System.out.println(temp.name);
		}
			
	}
}

class AgeName implements Comparable<AgeName>{
	int age;
	String name;
	
	public AgeName(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}

	@Override
	public int compareTo(AgeName ageName) {
		int compareAge = ageName.age;
		return this.age - compareAge;
	}

	
}
