package com.bnitech.programmers;

public class SkillCheck {

  public static int a = 2;
  public static int b = 6;

  public static long solution1(int a, int b) {
    int front = 0, rear = 0;
    if (a <= b) {
      front = a;
      rear = b;
    } else {
      front = b;
      rear = a;
    }

    long sum = 0;
    for (int i = front; i <= rear; i++) {
      sum += i;
    }

    return sum;
  }

  public static long n = 1183721119;

  public static long solution2(long n) {
    String strN = String.valueOf(n);
    StringBuilder sbN = new StringBuilder(strN);
    StringBuilder sbResult = new StringBuilder();

    for (int i = 0; i < strN.length(); i++) {
      // {value, index}
      int[] max = {strN.charAt(0) - '0', 0};
      for (int j = 1; j < sbN.length(); j++) {
        if (max[0] < sbN.charAt(j) - '0') {
          max[0] = sbN.charAt(j) - '0';
          max[1] = j;
        }
      }

      sbResult.append(max[0]);
      sbN.deleteCharAt(max[1]);
    }

    return Long.parseLong(sbResult.toString());
  }

  public static String phone_number = "22895230525021234";

  public static String solution3(String phone_number) {
    StringBuilder sbPN = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      sbPN.insert(0, phone_number.charAt(phone_number.length() - i - 1) - '0');
    }
    for (int i = 0; i < phone_number.length() - 4; i++) {
      sbPN.insert(0, '*');
    }

    return sbPN.toString();
  }

  public static int N = 5;
  public static int M = 3;
  public static void solution4(int N , int M) {
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print('*');
      }
      System.out.println();
    }
  }
}
