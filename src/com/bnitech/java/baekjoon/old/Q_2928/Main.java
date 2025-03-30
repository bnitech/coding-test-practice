package com.bnitech.java.baekjoon.old.Q_2928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int coordLen = Integer.parseInt(br.readLine());
        int coordArr[][] = new int[coordLen][4];
        StringTokenizer st = new StringTokenizer("");
        for (int i = 0; i < coordLen; i++) {
            st = new StringTokenizer(br.readLine());
            coordArr[i][0] = Integer.parseInt(st.nextToken());
            coordArr[i][1] = Integer.parseInt(st.nextToken());
            coordArr[i][2] = Integer.parseInt(st.nextToken());
            coordArr[i][3] = Integer.parseInt(st.nextToken());
        }
        int timeLen = Integer.parseInt(br.readLine());
        int timeArr[] = new int[timeLen];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < timeLen; i++) {
            timeArr[i] = Integer.parseInt(st.nextToken());
        }


        new Main().solution(coordArr, timeArr);
    }

    public void solution(int[][] coordArr, int[] timeArr) {
        List<Point> pointList = new ArrayList<>();
        int sumOilArr[] = new int[timeArr.length];


    }

    public List<Point> checkPoint(List<Point> pointList, int x1, int y1, int x2, int y2) {
        int startX, startY, dx, dy = 0;
        if (x1 < x2) {
            dx = x2 - x1;
            startX = x1;
        } else {
            dx = x1 - x2;
            startX = x2;
        }
        if (y1 < y2) {
            dx = y2 - y1;
            startY = y1;
        } else {
            dx = y1 - y2;
            startY = y2;
        }

        for (int i = 0; i < dy; i++) {
            for (int j = 0; j < dx; j++) {
//				pointList.add(e)
            }
        }

        return null;
    }

    public class Point {
        int X, Y;
    }
}
