package 파수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) {
		String[] nums = { "4514--234495-1", "305-44-291501", "1-2-34-495-8623", "492134545151", "623-421523-67-341",
				"-5439-59639921", "6235-7X3+47-7456", "98-76-543-210", "512-73-634901", "000-999999-22-555",
				"064-82-792561" };
		System.out.println(Arrays.toString(solution(nums)));
	}

	static public int[] solution(String[] nums) {

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			String str = nums[i];
			if (check1(str) && check2(str) && check4(str)) {
				list.add(str);
			}
		}

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			map.put(str, 1);
			// 문자열의 길이가 같고, -의 개수와 -의 위치가 같으면 같은애
			ArrayList<String> tmp = new ArrayList<>();
			for(String t : list)
				tmp.add(t);
			
			for (int j = i+1; j < list.size(); j++) {
				String str2 = list.get(j);
				if (str.length() == str2.length()) {
					if (cntLetter(str) == cntLetter(str2)) {
						if(checkPos(str, str2)) {
							System.out.println(str +" " + str2);
							if(map.containsKey(str)) {
								map.put(str, map.get(str)+1);
								int idx = str.indexOf(str);
								tmp.remove(idx);
							}else 
								map.put(str2, 1);
						}
					}

				}
			}
		}
		int[] answer = new int[map.size()];
		int tmp = 0;
		List<String> ans = new ArrayList<>(map.keySet());
		Collections.sort(ans, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		for (String key : ans) {
			answer[tmp] = map.get(key);
			tmp++;
		}
		return answer;

	}
	
	// 같은 자리에 -있는지
	static boolean checkPos(String str, String str2) {
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '-') {
				if(str2.charAt(i)!= '-')
					return false;
			}
		}
		return true;
	}

	// - 몇개
	static int cntLetter(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				sum++;
			}
		}
		return sum;
	}

	// 0-9와 특수문자 -만 있는지
	static boolean check1(String str) {

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isAlphabetic(ch))
				return false;
			else if (Character.isLetter(ch) && ch != '-')
				return false;
		}
		return true;
	}

	// 숫자 개수 11개 이상 14개 이하
	static boolean check2(String str) {

		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch))
				cnt++;
			if (ch == '-')
				cnt2++;
		}
		if (cnt < 11)
			return false;
		if (cnt > 14)
			return false;
		if (cnt2 > 3)
			return false;

		return true;
	}

	static boolean check4(String str) {
		if (str.contains("--"))
			return false;
		if (str.charAt(0) == '-' || str.charAt(str.length() - 1) == '-')
			return false;

		return true;

	}
}