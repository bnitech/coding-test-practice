package com.bnitech.programmers.Q_¿ÏÀüÅ½»ö_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
		String numbers = "13";
		System.out.println(test.solution(numbers));
	}

	public int solution(String numbers) {

		char[] numberArr = numbers.toCharArray();
		int n = numberArr.length;

		List<Integer> numberList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			int r = i;
			char[] combArr = new char[r];
			combination(numberList, combArr, numberArr, n, r, 0, 0);
		}

		boolean isPrime[] = new boolean[(int) Math.pow(10, n)];
		setPrime(isPrime);
		int cntPrime = 0;
		for(int number : numberList) {
			if(isPrime[number]) cntPrime ++;
		}
		int answer = cntPrime;
		return answer;
	}

	public void combination(List<Integer> list, char[] combArr, char[] arr, int n, int r, int index, int target) {
		if (r == 0) {
			// to-do: combArr permutation
			permutation(list, combArr, 0);
			System.out.println("------------------");
		} else if (target == n)
			return;
		else {
			combArr[index] = arr[target];
			combination(list, combArr, arr, n, r - 1, index + 1, target + 1);
			combination(list, combArr, arr, n, r, index, target + 1);
		}
	}

	public void permutation(List<Integer> list, char[] arr, int startIdx) {
		int len = arr.length;
		if (startIdx == len - 1) {
			StringBuilder sb = new StringBuilder();
			for (char c : arr)
				sb.append(c);
			int res = Integer.parseInt(sb.toString());
			if (list.contains(res) == false) {
				list.add(res);
			}

			return;
		}

		for (int i = startIdx; i < len; i++) {
			swap(arr, startIdx, i);
			permutation(list, arr, startIdx + 1);
			swap(arr, startIdx, i);
		}
	}

	public void swap(char[] arr, int idx1, int idx2) {
		char tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	public void setPrime(boolean[] isPrime) {
		int len = isPrime.length;
		boolean removePrime[] = new boolean[len+1];
		
		for (int i = 2; i <= len; i++) {
			if (removePrime[i] == false) {
				isPrime[i] = true;
				for (int j = i * i; j <= len; j += i) {
					removePrime[j] = true;
				}
			}
		}
	}
}
