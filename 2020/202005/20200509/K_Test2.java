package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static Pair makePair(int x, int y) {
		return new Pair(x, y);
	}
}

class Solution {
	public String solution(int[] numbers, String hand) {
		Map<Integer, Pair> map = new HashMap<>();

		for (int i = 1; i <= 9; i++) {
			map.put(i, new Pair((i - 1) / 3, (i - 1) % 3));
		}
		map.put(0, new Pair(3, 1));

		Pair left = new Pair(3, 0);
		Pair right = new Pair(3, 2);

		int N = numbers.length;
		String answer = "";

		for (int i = 0; i < N; i++) {
			if (map.get(numbers[i]).y == 0) {
				answer += 'L';
				left = map.get(numbers[i]);
			} else if (map.get(numbers[i]).y == 2) {
				answer += 'R';
				right = map.get(numbers[i]);
			} else {
				int left_dist = Math.abs(left.x - map.get(numbers[i]).x) + Math.abs(left.y - map.get(numbers[i]).y);
				int right_dist = Math.abs(right.x - map.get(numbers[i]).x) + Math.abs(right.y - map.get(numbers[i]).y);

				if (left_dist == right_dist) {
					if (hand == "right") {
						answer += 'R';
						right = map.get(numbers[i]);
					} else {
						answer += 'L';
						left = map.get(numbers[i]);
					}
				} else if (left_dist < right_dist) {
					answer += 'L';
					left = map.get(numbers[i]);
				} else {
					answer += 'R';
					right = map.get(numbers[i]);
				}
			}
		}
		return answer;
	}
}
////1번
//string solution(vector<int> numbers, string hand) {
//  map<int, pair<int, int> > mp;
//  for (int i = 1; i <= 9; i++) mp[i] = {(i - 1) / 3, (i - 1) % 3};
//  mp[0] = {3, 1};
//  pair<int, int> left_pos = {3,0}, right_pos = {3,2};
//  int N = numbers.size();
//  string answer = "";
//  for (int i = 0; i < N; i++) {
//      if (mp[numbers[i]].second == 0) answer += 'L', left_pos = mp[numbers[i]];
//      else if (mp[numbers[i]].second == 2) answer += 'R', right_pos = mp[numbers[i]];
//      else {
//          int left_dist = abs(left_pos.first - mp[numbers[i]].first) + abs(left_pos.second - mp[numbers[i]].second);
//          int right_dist = abs(right_pos.first - mp[numbers[i]].first) + abs(right_pos.second - mp[numbers[i]].second);
//          if (left_dist == right_dist) {
//              if (hand == "right") answer += 'R', right_pos = mp[numbers[i]];
//              else answer += 'L', left_pos = mp[numbers[i]];
//          } else if (left_dist < right_dist) {
//              answer += 'L', left_pos = mp[numbers[i]];
//          } else {
//              answer += 'R', right_pos = mp[numbers[i]];
//          }
//      }
//  }
//  return answer;
//}