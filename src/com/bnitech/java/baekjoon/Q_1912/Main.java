package com.bnitech.acmicpc.Q_1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws Exception{
        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int maxNum[] =  new int[len];
        st = new StringTokenizer(br.readLine());
        int idx = 0, max = 0;
        max = Integer.parseInt(st.nextToken());
        maxNum[idx++] = max;
        while (idx < len){
            int num = Integer.parseInt(st.nextToken());
            if(maxNum[idx-1]+num < num){
                maxNum[idx] = num;
            }else{
                maxNum[idx] = maxNum[idx-1] + num;
            }
            if(max < maxNum[idx]){
                max = maxNum[idx];
            }
            idx++;
        }
        System.out.println(max);
    }
}
