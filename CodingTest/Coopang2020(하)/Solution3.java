package coopang;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3 {
	public static void main(String[] args) {
		int k = 3;
		int[] score = { 24,22,20,10,5,3,2,1};
		System.out.println(solution(k, score));
	}

	static public int solution(int k, int[] score) {
		int answer = 0;
		ArrayList<Integer> diff = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		diff.add(0); // 1등의 점수차

		for (int i = 0; i < score.length - 1; i++) {
			int tmp = score[i] - score[i + 1];
			diff.add(tmp);// 점수차 저장 (list의 1번에 있는 요소는 1등과 2등의 점수차)
			if (map.containsKey(tmp)) { // 이미 이 점수차가 있으면 +1
				map.put(tmp, map.get(tmp) + 1);
			} else
				map.put(tmp, 1); // 이 점수차 처음 등장이면 1
		}
		
		// map에서 value가 k 이상인거 찾아서 지우기
		for(Integer key : map.keySet()) {
			int value = map.get(key);
			if(value >= k){
				removeScore(diff, score, key);
			}
		}

		for (int i = 0; i < score.length; i++) {
			if(score[i]!= -1) {
				answer++;
			}
		}

		return answer;
	}

	private static void removeScore(ArrayList<Integer> diff,int[] score, int diffScore) {
		
		for (int i = 0; i < diff.size(); i++) {
			int num = diff.get(i);
			if(num == diffScore) {
				score[i]=-1;
				score[i+1]=-1;
			}
		}
		
	}
}
