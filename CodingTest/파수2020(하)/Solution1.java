package 파수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution1 {

	public static void main(String[] args) {
		String s = "{cpp{java}}{python}";
		int[] idx = {0, 4, 9, 10, 11, 18};
		int[] ret = solution(s, idx);
		System.out.println(Arrays.toString(ret));
	}
	static class Info{
		int key;
		int value;
		public Info(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	static public int[] solution(String s, int[] idx) {
		int[] answer = new int[idx.length];
		
		ArrayList<Info> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[s.length() + 1];
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch == '{') { // 열림괄호면 스택에 넣어
				stack.add(i);
			}else if(ch == '}') { // 닫힘괄호면 스택에서 하나 꺼내
				int iddx = stack.pop();
				ans[iddx] = i;
				ans[i]= iddx;
			}
		}
		
		int tmp = 0;
		for (int i = 0; i < idx.length; i++) {
			answer[tmp++] = ans[idx[i]];
		}
		
		
		return answer;
	}
}