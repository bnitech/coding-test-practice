import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q_1181{
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_1181().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
	
		MyString[] myString = new MyString[numN];
		
		for (int i = 0; i < numN; i++) {
			myString[i] = new MyString(br.readLine());
		}
		
		Arrays.sort(myString, new Comparator<MyString>() {
			@Override
			public int compare(MyString string1, MyString string2) {
				String char1 = string1.getString().toUpperCase();
				String char2 = string2.getString().toUpperCase();
				return char1.compareTo(char2);
			}
		});
		
		Arrays.sort(myString);
		
		String preString = new String();
		for (MyString chars : myString) {
			if(preString.equals(chars.getString())){
				continue;
			}
			System.out.println(chars.getString());
			preString = chars.getString();
			
		}
	}
}

class MyString implements Comparable{
	int len;
	String chars;
	
	public MyString(String myString) {
		len = myString.length();
		this.chars = myString;
	}
	
	public String getString(){
		return this.chars;
	}
	public void setString(String myString){
		this.chars = myString;
	}
	public int getLen(){
		return this.len;
	}
	public void setLen(int len){
		this.len = len;
	}

	@Override
	public int compareTo(Object compareString){
		int compareLen = ((MyString)compareString).getLen();
				
		return this.len - compareLen;
		//return compareLen - this.len;
	}

	
}
