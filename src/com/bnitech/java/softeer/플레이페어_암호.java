package com.bnitech.java.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 플레이페어_암호 {
    public static void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();
        String key = reader.readLine();

        Map<Character, Integer[]> map = new HashMap<>();
        char[][] arr = new char[5][5];
        setArrAndMap(key, arr, map);
        List<String> pairList = getPairList(message);
        StringBuilder resultSb = new StringBuilder();

        for (String pair : pairList) {
            char front = pair.charAt(0);
            char rear = pair.charAt(1);

            Integer[] frontLoc = map.get(front);
            Integer[] rearLoc = map.get(rear);

            if (Objects.equals(frontLoc[0], rearLoc[0])) {
                resultSb.append(arr[frontLoc[0]][frontLoc[1] + 1 < 5 ? frontLoc[1] + 1 : 0]);
                resultSb.append(arr[rearLoc[0]][rearLoc[1] + 1 < 5 ? rearLoc[1] + 1 : 0]);
                continue;
            }

            if (Objects.equals(frontLoc[1], rearLoc[1])) {
                resultSb.append(arr[frontLoc[0] + 1 < 5 ? frontLoc[0] + 1 : 0][frontLoc[1]]);
                resultSb.append(arr[rearLoc[0] + 1 < 5 ? rearLoc[0] + 1 : 0][rearLoc[1]]);
                continue;
            }

            resultSb.append(arr[frontLoc[0]][rearLoc[1]]);
            resultSb.append(arr[rearLoc[0]][frontLoc[1]]);
        }


        System.out.println(resultSb);
    }

    public static void setArrAndMap(String key, char[][] arr, Map<Character, Integer[]> map) {
        Set<Character> alphaSet = new LinkedHashSet<>();
        for (int i = 0; i < key.length(); i++) {
            alphaSet.add(key.charAt(i));
        }

        for (int i = 0; i < 26; i++) {
            char alpha = (char) ('A' + i);
            if (alpha == 'J') continue;

            alphaSet.add(alpha);
        }

        int i = 0, j = 0;
        for (char alpha : alphaSet) {
            map.put(alpha, new Integer[]{i, j});
            arr[i][j++] = alpha;
            if (j == 5) {
                j = 0;
                i++;
            }
        }
    }

    public static List<String> getPairList(String message) {
        List<String> pairList = new ArrayList<>();
        char front, rear;
        for (int i = 0; i < message.length(); i += 2) {

            front = message.charAt(i);
            if (i + 1 >= message.length()) {
                rear = 'X';
                pairList.add(front + "" + rear);
                continue;
            }

            rear = message.charAt(i + 1);
            if (front == rear) {
                rear = front == 'X' ? 'Q' : 'X';
                i--;
            }

            pairList.add(front + "" + rear);
        }

        return pairList;
    }
}
