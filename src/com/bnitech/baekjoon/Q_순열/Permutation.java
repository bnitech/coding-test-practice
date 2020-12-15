package com.bnitech.baekjoon.Q_순열;

public class Permutation {
    public static void main(String[] ar){
        Permutation ex = new Permutation();
        int[] arr = { 1, 3, 5 };
        ex.doPermutation(arr, 0);
    }

    public void doPermutation(int[] arr, int startIdx){
        int length = arr.length;
        if(startIdx == length-1){
            for(int n: arr) System.out.print(n + " ");
            System.out.println();
            return;
        }

        for(int i=startIdx; i<length; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1);
			// 원소 중복은 아래 줄을 제거하면 됨
            swap(arr, startIdx, i);
        }
    }

    public void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
