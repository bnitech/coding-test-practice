package com.bnitech.java.programmers.Q_해시_2;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();

		String phone_book[] = { "12232332", "12", "222222" };
		test.solution(phone_book);
	}

	public boolean solution(String[] phone_book) {
		boolean answer = true;
		int lenBook = phone_book.length;
		for (int i = 0; i < lenBook - 1; i++) {
			for (int j = i + 1; j < lenBook; j++) {
				if (phone_book[i].startsWith(phone_book[j])) {
					answer = false;
				}
				if (phone_book[j].startsWith(phone_book[i])) {
					answer = false;
				}
			}
		}
		return answer;
	}
}
