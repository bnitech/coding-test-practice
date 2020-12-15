/*
정렬-정렬-국영수
 */


package com.bnitech.acmicpc.Q_10825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        People [] arr_people = new People[num_N];
        StringTokenizer st;
        for (int i = 0; i < num_N; i++) {
            st = new StringTokenizer(br.readLine());
            arr_people[i] = new People();
            arr_people[i].name = st.nextToken();
            arr_people[i].kr = Integer.parseInt(st.nextToken());
            arr_people[i].en = Integer.parseInt(st.nextToken());
            arr_people[i].math = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_people,(People people1, People people2)->{
           if(people1.kr == people2.kr){
               if(people1.en == people2.en) {
                   if(people1.math == people2.math) return people1.name.compareTo(people2.name);
                   else return Integer.compare(people1.math, people2.math) * (-1);
               }
               else return Integer.compare(people1.en,people2.en);
           }
           else return Integer.compare(people1.kr,people2.kr)*(-1);
        });

        for (int i = 0; i <num_N ; i++) {
            System.out.println(arr_people[i].name);
        }
    }
}
class People{
    String name;
    int kr;
    int en;
    int math;
}