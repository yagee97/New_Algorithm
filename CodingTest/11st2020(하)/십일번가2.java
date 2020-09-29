import java.util.Arrays;

public class 십일번가2 {
	public static void main(String[] args) {
		String[] s = { "abc", "bca", "dbe" };
		System.out.println(Arrays.toString(solution(s)));

	}

	static public int[] solution(String[] S) {
		// write your code in Java SE 8
	    int[] ans = {};

		out: for (int i = 0; i < S.length; i++) {
			for (int j = i + 1; j < S.length; j++) {
				for (int k = 0; k < S[i].length(); k++) {
					if (S[j].charAt(k) == S[i].charAt(k)) {
						ans = new int[3];
						ans[0] = i;
						ans[1] = j;
						ans[2] = k;
						break out;
					}
				}
			}
		}

		return ans;
	}
}
