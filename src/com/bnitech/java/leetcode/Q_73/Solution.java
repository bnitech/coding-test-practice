package com.bnitech.java.leetcode.Q_73;

import java.util.LinkedList;
import java.util.Queue;

// 73. Set Matrix Zeroes
public class Solution {
    public static void setZeroes(final int[][] matrix) {
        final int TOP = 0, RIGHT = matrix[0].length - 1, BOTTOM = matrix.length - 1, LEFT = 0;
        final int EAST = 0, SOUTH = 1, WEST = 2, NORTH = 3;


        final Queue<Point> pointQueue = new LinkedList<>();
        for (int i = TOP; i <= BOTTOM; i++) {
            for (int j = LEFT; j <= RIGHT; j++) {
                if (matrix[i][j] == 0) pointQueue.offer(new Point(j, i));
            }
        }

        while (!pointQueue.isEmpty()) {
            final Point point = pointQueue.poll();

            // 동, 남, 서, 북
            for (int dir = EAST; dir <= NORTH; dir++) {
                int row = point.getY(), column = point.getX();
                if (dir == EAST) {
                    while (++column <= RIGHT) {
                        if (matrix[row][column] != 0) matrix[row][column] = 0;
                    }
                } else if (dir == SOUTH) {
                    while (++row <= BOTTOM) {
                        if (matrix[row][column] != 0) matrix[row][column] = 0;
                    }
                } else if (dir == WEST) {
                    while (--column >= LEFT) {
                        if (matrix[row][column] != 0) matrix[row][column] = 0;
                    }
                } else if (dir == NORTH) {
                    while (--row >= TOP) {
                        if (matrix[row][column] != 0) matrix[row][column] = 0;
                    }
                }
            }
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
