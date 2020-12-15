package com.bnitech.programmers.Q_ÇØ½Ã_1;

import java.util.HashMap;

class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();

		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		System.out.println(test.solution(participant, completion));
	}

	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
