package com.bnitech.java.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SkillCheck2 {

    public static int n = 59;

    public static Long Solution(int n) {
        HashMap<Integer, String> mapper = new HashMap<>();
        mapper.put(1, "1");
        mapper.put(2, "2");
        mapper.put(3, "4");
        mapper.put(4, "11");
        mapper.put(5, "12");
        mapper.put(6, "14.kt");
        mapper.put(7, "21");
        mapper.put(8, "22");
        mapper.put(9, "24");
        mapper.put(0, "41");

        String strN = String.valueOf(n);
        StringBuilder sbResult = new StringBuilder();

        for (int i = 0; i < strN.length(); i++) {
            int key = n % 10;
            sbResult.insert(0, mapper.get(key));
            n /= 10;

            if (n == 1 && key == 0) {
                break;
            }
        }

        return Long.valueOf(sbResult.toString());
    }

    public static String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

    public static int[] solution(String s) {
        s = s.replace("}", "");
        s = s.replace("{", "");
        String[] arrS = s.split(",");

        HashSet<Integer> hashSetS = new HashSet<>();
        for (String str : arrS) {
            hashSetS.add(Integer.valueOf(str));
        }

        return null;
    }

    public static String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

    public static String[] solution3(String[] files) {

        List<FileName> fileNameList = new ArrayList<>();

        for (String file : files) {
            int step = 0;
            FileName fileName = new FileName();
            for (int i = 0; i < file.length(); i++) {

                if (file.charAt(i) >= '0' && file.charAt(i) <= '9') {
                    step = 1;
                } else {
                    if (step == 1) {
                        step = 2;
                    }
                }

                if (step == 0) {
                    fileName.head += file.charAt(i);
                } else if (step == 1) {
                    fileName.number += file.charAt(i);
                } else {
                    fileName.tail += file.charAt(i);
                }
            }
            fileNameList.add(fileName);
        }

        fileNameList.sort((o1, o2) -> {
            if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) == 0) {
                if (Integer.valueOf(o1.number).compareTo(Integer.valueOf(o2.number)) == 0) {
                    return 0;
                } else {
                    return Integer.valueOf(o1.number).compareTo(Integer.valueOf(o2.number));
                }
            } else {
                return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
            }
        });

        int idx = 0;
        String[] answer = new String[fileNameList.size()];
        for (FileName fileName : fileNameList) {
            answer[idx++] = fileName.getFullName();
        }
        return answer;
    }


    static class FileName {

        String head = "";
        String number = "";
        String tail = "";

        public String getFullName() {
            return head + number + tail;
        }
    }
}
