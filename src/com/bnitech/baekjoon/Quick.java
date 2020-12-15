
public class Quick {

	public static void main(String[] args) {
		int[] arr = {15, 22, 13, 27, 12, 10, 20, 25};
		
		quickSorting(arr,0,1);
	}

	private static void quickSorting(int[] arr, int front, int rear) {
		if(rear==arr.length){
			return;
		}
		int pivot = arr[0];
		
	}
}
