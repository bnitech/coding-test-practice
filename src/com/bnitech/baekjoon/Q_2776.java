import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Q_2776 {

	public static void main(String[] args) {
		new Q_2776().start();
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		int numT = sc.nextInt();

		for (int i = 0; i < numT; i++) {

			int numN = sc.nextInt();
			int[] note1 = new int[numN];
			for (int j = 0; j < numN; j++) {
				note1[j] = sc.nextInt();
			}
			Arrays.sort(note1);
			int numM = sc.nextInt();

			for (int idx = 0; idx < numM; idx++) {
				Boolean find = false;
				int note2 = sc.nextInt();
				find = search(note1,note2);
				
				if (find)
					System.out.println("1");
				else
					System.out.println("0");

			}

		}

	}

	boolean search(int[] note1, int target) {

		int first = 0;
		int last = note1.length-1;
		int mid;

		while (first <= last) {
			
			mid = (first + last) / 2;
			if (target == note1[mid]) {
				return true;
			}else {
				if (target < note1[mid])
					last = mid - 1;
				else
					first = mid + 1;
			}
		}

		return false;
	}

}
