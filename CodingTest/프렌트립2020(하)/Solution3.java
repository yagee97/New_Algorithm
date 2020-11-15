package 프렌트립;

public class Solution3 {
	public static void main(String[] args) {
		String s = "abacde";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = 1;
		int len = s.length();
		boolean flag = false;
		out: for (int i = len; i > 1; i--) {
			for (int start = 0; start + i <= s.length(); start++) {
				flag = true;

				for (int j = 0; j < i / 2; j++) {
					if (s.charAt(start + j)!= s.charAt(start + i - j - 1)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer = i;
					break out;
				}
			}
		}

		return answer;
	}
}
