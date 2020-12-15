/*
정렬-정렬-나이순 정렬
 */

package com.bnitech.acmicpc.Q_10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
            arr_people[i].age = Integer.parseInt(st.nextToken());
            arr_people[i].name = st.nextToken();
        }

        Arrays.sort(arr_people,(People people1, People people2 )->{
            if(people1.age == people2.age) return 0;
            else return Integer.compare(people1.age,people2.age);
        });

        for (int i = 0; i < num_N ; i++) {
            System.out.println(arr_people[i].age+" "+arr_people[i].name);
        }
    }
}
class People{
    int age;
    String name;
}
