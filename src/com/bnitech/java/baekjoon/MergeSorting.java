

public class MergeSorting {

	public static void main(String[] args) {

		int[] arr = { 27, 10, 12, 20, 25, 13, 15, 32, 1 };

		mergeSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		
	}

	static public void mergeSort(int[] arr, int front, int rear) {

		int mid = (rear + front) / 2;

		if(rear-front < 1){
			return;
		}
		
		mergeSort(arr, front, mid);
		mergeSort(arr, mid + 1, rear);

		merge(arr, front, mid , rear);
	}

	static public void merge(int[] arr, int front ,int mid, int rear) {
		int idxLeft = front;
		int idxRight = mid+1;
		
		int[] arrTemp = new int[rear+1];
		int idxTemp = 0;

		while (idxTemp < arrTemp.length) {
			if (idxLeft > mid) {
				for (int i = idxRight; i <= rear; i++) {
					arrTemp[idxTemp] = arr[i];
					idxTemp++;
				}
				continue;
			}
			if (idxRight > rear) {
				for (int i = idxLeft; i <= mid; i++) {
					arrTemp[idxTemp] = arr[i];
					idxTemp++;
				}
				continue;
			}
			if (arr[idxLeft] < arr[idxRight]) {
				arrTemp[idxTemp] = arr[idxLeft];
				idxTemp++;
				idxLeft++;
			} else {
				arrTemp[idxTemp] = arr[idxRight];
				idxTemp++;
				idxRight++;
			}
		}
		
		idxTemp = 0;
		for (int i = front; i <= rear; i++) {
			arr[i] = arrTemp[idxTemp++];
		}
	}
}
