import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class 카카오2 {
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<String> list = new ArrayList<>();
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		// 새로운 메뉴 제공
		// 손님들이 주문할 때 가장 많이 함께 주문한 단품 메뉴들을 코스요리 메뉴로 구성
		// 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로.
		// 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 메뉴 후보에 포함

		// 코스요리 메뉴 구성을 문자열 형태로 return
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
	
		String[] answer = solution(orders, course);
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));


	}

	static public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		TreeSet<String> set = new TreeSet<>();

		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			for (int c = 0; c < course.length; c++) {
				// 메뉴 개수 만큼 묶어
				pick(orders[i].length(), stack, course[c], ch);
				printPick(stack, ch);
			}
		}
		set = new TreeSet<>(list); // 중복 없앰
		List<String> arrList = new ArrayList<>(set);

		// 묶은 거 가지고 이제,,, 이 조합이 몇명한테 있는지 봐야함
		for (int i = 0; i < arrList.size(); i++) {
			String comb = arrList.get(i);
			for (int j = 0; j < orders.length; j++) {
				int cnt = 0;
				String ord = orders[j];
				// comb를 구성하는 알파벳이 ord에도 모두 있는가?
				for (int k = 0; k < comb.length(); k++) {
					for(int s = 0; s<orders[j].length();s++) {
						if(comb.charAt(k) == orders[j].charAt(s)) {
							cnt++;
						}
					}
				}
				if(cnt == comb.length()) {
					if(map.containsKey(comb)) {
						map.put(comb, map.get(comb) +1);
					}else
						map.put(comb, 1);
				}
			}
		}
		
		Map<String, Integer> result = sortMapByKey(map);
		LinkedHashMap<String, Integer> tmp = sortMapByKey(map);
	
		ArrayList<String> ans = new ArrayList<>();
		// 두개 짜리에서 제일 많은 값 찾기
	
		for (int i = 0; i < course.length; i++) {
			int c = course[i]; // 몇개
			int max = Integer.MIN_VALUE;
			for(String key : tmp.keySet()) {
				int value = tmp.get(key);
				if(key.length() == c) {
					max = Math.max(max, value);
				}
			}
			
			// 길이마다 max 값 찾았으면 그 값에 해당하는 key 뽑아..
			for(String key : tmp.keySet()) {
				int value = tmp.get(key);
				if(value == max && c == key.length()) {
					ans.add(key);
				}
			}
		}
		
		int idx = 0;
		answer = new String[ans.size()];
		for(String str : ans) {
			answer[idx++] = str;
		}
		
		return answer;
	}
	
	static public LinkedHashMap<String, Integer> sortMapByKey(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		Collections.sort(entries, (o1, o2) -> o1.getKey().length() - o2.getKey().length());
		
		LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	static void pick(int n, Stack<Integer> st, int r, char[] chSet) {
		if (r == 0) {
			printPick(st, chSet);
		}
		
		if(r < chSet.length)
			return;

		int smallest = st.isEmpty() ? 0 : st.lastElement() + 1;

		for (int i = smallest; i < n; i++) {
			st.push(i);
			pick(n, st, r - 1, chSet);
			st.pop();
		}
	}

	static void printPick(Stack<Integer> st, char[] chSet) {
		String str = "";
		for (int i : st) {
			str += chSet[i];
		}
		list.add(str);
	}

}
