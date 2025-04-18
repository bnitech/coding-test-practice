package com.bnitech.java.baekjoon.old.etc.johabhusunyul;

// ���� �� ����
public class Permutation2 {
    public static void main(String[] ar){
        Permutation2 ex = new Permutation2();
        int[] arr = { 1, 3, 5, 7, 9 };
        // nPr ���ϱ�
        int n = arr.length;
        int r = 3;
        int[] combArr = new int[r];
        ex.doCombination(combArr, arr, n, r, 0, 0);
    }

    public void doCombination(int[] combArr, int[] arr, int n, int r, int index, int target){
        if(r == 0){
            //to-do: combArr permutation
            doPermutation(combArr, 0);
            System.out.println("------------------");
        }else if(target == n) return;
        else{
            combArr[index] = arr[target];
            doCombination(combArr, arr, n, r-1, index+1, target+1);
            doCombination(combArr, arr, n, r, index, target+1);
        }
    }

    public void doPermutation(int[] arr, int startIdx){
        int length = arr.length;
        if(startIdx == length-1){
            for(int item: arr) System.out.print(item + " ");
            System.out.println();
            return;
        }
        for(int i=startIdx; i<length; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1);
            swap(arr, startIdx, i);
        }
    }

    public void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
