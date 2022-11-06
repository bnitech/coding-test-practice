package com.bnitech.java.programmers;

import java.util.HashMap;

public class SkillCheck3 {

    public static int cacheSize = 0;
    public static String[] cities_1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
            "Seoul", "NewYork", "LA"};
    public static String[] cities_2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju",
            "Pangyo", "Seoul"};
    public static String[] cities_3 = {"Jeju", "Pangyo", "NewYork", "newyork"};

    public static int solution(int cacheSize, String[] cities) {

        int totalTime = 0;
        HashMap<String, Integer> cacheMap = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            String targetCity = cities[i].toLowerCase();
            if (cacheMap.containsKey(targetCity)) {
                totalTime++;
                cacheMap.put(targetCity, i);
            } else {
                totalTime += 5;

                if (cacheSize == 0) continue;

                if (cacheMap.size() < cacheSize) {
                    cacheMap.put(targetCity, i);
                } else {
                    int minTime = Integer.MAX_VALUE;
                    String minTimeCity = "";
                    for (String city : cacheMap.keySet()) {
                        if (minTime >= cacheMap.get(city)) {
                            minTime = cacheMap.get(city);
                            minTimeCity = city;
                        }
                    }
                    cacheMap.remove(minTimeCity);
                    cacheMap.put(targetCity, i);
                }
            }
        }

        return totalTime;
    }
}
