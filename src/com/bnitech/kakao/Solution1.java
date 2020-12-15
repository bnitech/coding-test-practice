package com.bnitech.kakao;

public class Solution1 {

  public static String nuew_id = "abcdefghijklmn.p";

  public static String solution(String new_id) {
    new_id = new_id.toLowerCase();
    new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
    new_id = new_id.replaceAll("(\\.)+", ".");
    new_id = new_id.replaceAll("^\\.+|\\.+$", "");

    if(new_id.isEmpty()) new_id = "a";

    StringBuilder sbResult = new StringBuilder(new_id);
    if (sbResult.length() > 15) {
      sbResult = new StringBuilder(sbResult.substring(0, 15));
      if (sbResult.charAt(14) == '.') {
        sbResult = new StringBuilder(sbResult.substring(0, 14));
      }
    }

    if (sbResult.length() <= 2 && sbResult.length() >= 1 ) {
      int len = sbResult.length();
      char addChar = sbResult.charAt(len - 1);
      for (int i = 0; i < 3 - len; i++) {
        sbResult.append(addChar);
      }
    }
    return sbResult.toString();
  }
}

