package com.bnitech.programmers.Q_ÇØ½Ã_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution test = new Solution();
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		System.out.println(Arrays.toString(test.solution(genres, plays)));

	}

	public int[] solution(String[] genres, int[] plays) {

		HashMap<String, List<Music>> genresHM = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			List<Music> musicList = new ArrayList<>();
			if (genresHM.containsKey(genres[i])) {
				musicList = genresHM.get(genres[i]);
			}
			musicList.add(new Music(i, plays[i]));
			genresHM.put(genres[i], musicList);
		}

		List<Genre> genreList = new ArrayList<>();
		for (String key : genresHM.keySet()) {
			List<Music> musicList = genresHM.get(key);
			Collections.sort(musicList, (music1, music2) -> {
				if (music1.cnt == music2.cnt) {
					return Integer.compare(music1.idx, music2.idx);
				}
				return Integer.compare(music1.cnt, music2.cnt) * (-1);
			});
			int sum = 0;
			for (Music music : musicList) {
				sum += music.cnt;
			}
			genreList.add(new Genre(key, sum));
		}

		Collections.sort(genreList, (genre1, genre2) -> {
			return Integer.compare(genre1.cnt, genre2.cnt) * (-1);
		});

		List<Integer> answerList = new ArrayList<>();
		for (Genre genre : genreList) {
			List<Music> musicList = genresHM.get(genre.name);

			answerList.add(musicList.get(0).idx);
			answerList.add(musicList.get(1).idx);
		}

		int[] answer = new int[answerList.size()];
		answer = answerList.stream().mapToInt(i -> i).toArray();

		return answer;
	}

	public class Music {
		int idx, cnt;

		public Music(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public class Genre {
		String name;
		int cnt;

		public Genre(String name, int cnt) {
			this.name = name;
			this.cnt = cnt;
		}
	}
}
