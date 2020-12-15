package com.bnitech.kakao;

import java.util.Arrays;
import sun.security.util.ArrayUtil;

public class Solution3 {

  public static String[] info = {"java backend junior pizza 150",
      "python frontend senior chicken 210", "python frontend senior chicken 150",
      "cpp backend senior pizza 260", "java backend junior chicken 80",
      "python backend senior chicken 50"};
  public static String[] query = {"java and backend and junior and pizza 100",
      "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
      "- and backend and senior and - 150", "- and - and - and chicken 100",
      "- and - and - and - 150"};

  public static int[] solution(String[] info, String[] query) {

    // 0: 언어, 1: 직군, 2: 경력, 3: 소울푸드, 4: 점수
    String[][] infoData = new String[info.length][5];
    for (int i = 0; i < info.length; i++) {
      infoData[i] = info[i].split(" ");
    }

    int[] result = new int[query.length];
    for (int i = 0; i < query.length; i++) {
      String[] queryData = query[i].replaceAll(" and","").split(" ");

      int countNum = 0;
      // 0: 언어, 1: 직군, 2: 경력, 3: 소울푸드, 4: 점수
      for (int j = 0; j < info.length; j++) {
        for (int kind = 0; kind < 5; kind++) {
          // 점수
          if (kind == 4) {
            if (Integer.parseInt(queryData[kind]) <= Integer.parseInt(infoData[j][kind])) {
              countNum++;
            }
          } else {
            if (queryData[kind].equals("-")) {
              continue;
            }
            if (!queryData[kind].equals(infoData[j][kind])) {
              break;
            }
          }
        }
      }
      result[i] = countNum;
    }

    return result;
  }
}
