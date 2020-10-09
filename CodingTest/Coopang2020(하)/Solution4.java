package coopang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {
	static long hubAns, destAns;
	public static void main(String[] args) {
		String depar = "SEOUL";
		String hub = "DAEGU";
		String dest = "YEOSU";
		String[][] roads = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
				{ "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
				{ "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
				{ "BUSAN", "YEOSU" } };
		int s = solution(depar, hub, dest, roads);
		System.out.println(s);
	}

	public static int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = -1;
		Map<String, Integer> map = new HashMap<>();

		int cnt = 0;
		for (int i = 0; i < roads.length; i++) {
			String tmp1 = roads[i][0];
			String tmp2 = roads[i][1];

			if (!map.containsKey(tmp1))
				map.put(tmp1, cnt++);
			if (!map.containsKey(tmp2))
				map.put(tmp2, cnt++);
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < cnt; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < roads.length; i++)
			list.get(map.get(roads[i][0])).add(map.get(roads[i][1]));

		boolean[] chk = new boolean[cnt];

		dfs(chk, map.get(depar), map.get(hub), false, list);
		if (hubAns == 0)
			return 0;

		chk = new boolean[cnt];
		
		dfs(chk, map.get(hub), map.get(dest), true, list);
		answer = (int) ((hubAns * destAns) % 10007);
		return answer;
	}

	static void dfs(boolean[] chk, int start, int end, boolean isDest, ArrayList<ArrayList<Integer>> list) {
		chk[start] = true;
		if (start == end) {
			if (isDest)
				destAns++;
			else
				hubAns++;
			return;
		}
		for (int i = 0; i < list.get(start).size(); i++) {
			int next = list.get(start).get(i);
			if (chk[next])
				continue;
			dfs(chk, next, end, isDest, list);
			chk[next] = false;
		}
	}
}