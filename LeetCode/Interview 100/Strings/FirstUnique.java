package Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique {
	public static void main(String[] args) {

		int ans = firstUniqChar("leetcode");
		System.out.println(ans);
	}

	static public int firstUniqChar(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
			
			// map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}
}
