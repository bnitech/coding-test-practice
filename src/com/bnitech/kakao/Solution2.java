package com.bnitech.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution2 {

  public static String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
  public static int[] course = {2, 3, 4};
  public static String[] orders_1 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
  public static int[] course_1 = {2, 3, 5};

  public static String[] solution(String[] orders, int[] course) {
    HashMap<Character, Integer> countOrder = new HashMap<>();
    for (String order : orders) {
      for (int i = 0; i < order.length(); i++) {
        char menu = order.charAt(i);
        if (countOrder.containsKey(menu)) {
          countOrder.put(menu, countOrder.get(menu) + 1);
        } else {
          countOrder.put(menu, 1);
        }
      }
    }

    List<String> enableOrderList = new ArrayList<>();
    for (String order : orders) {
      for (int num : course) {
        if (num == order.length()) {
          enableOrderList.add(order);
        }
      }
    }

    List<String> resultList = new ArrayList<>();
    for (String order : enableOrderList) {
      if(resultList.contains(order)) continue;
      boolean isOk = true;
      for (int j = 0; j < order.length(); j++) {
        if (countOrder.get(order.charAt(j)) < 2) {
          isOk = false;
          break;
        }
      }
      if (isOk) {
        resultList.add(order);
      }
    }

    Collections.sort(resultList);

    String[] answer = new String[resultList.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = resultList.get(i);
    }
    return answer;
  }
}
