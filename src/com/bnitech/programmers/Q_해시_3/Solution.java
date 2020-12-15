package Q_해시_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(test.solution(clothes));
	}

	public int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, List<String>> clothHM = new HashMap<>();
		for (String[] cloth : clothes) {
			String name = cloth[0];
			String kind = cloth[1];
			List<String> list = new ArrayList<>();
			if (clothHM.containsKey(kind)) {
				list = clothHM.get(kind);
			}
			list.add(name);
			clothHM.put(kind, list);
		}
		// +1 : 착용하지 않은 경우,  -1 : 모든 입지 않은 경우.
		for (String key : clothHM.keySet()) {
			int lenList = clothHM.get(key).size();
			answer *= lenList + 1;
		}
		return answer -1 ;
	}
}
