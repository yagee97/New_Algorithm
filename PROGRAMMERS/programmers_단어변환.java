
public class programmers_단어변환 {
	public static void main(String[] args) {

		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution("hit", "cog", words));
	}

	static boolean[] chk;

	static public int solution(String begin, String target, String[] words) {
		int answer = 0;

		chk = new boolean[words.length];

		// dfs로 시작단어에서 한글자 바뀐 단어가 words 에 있는지 체크
		// 재귀로 또 체크
		// 해서 target 단어와 같아지면
		// 최솟값인지 비교

		dfs(begin, 0, target, words);

		if (minV == Integer.MAX_VALUE)
			return 0;
		else
			return minV;
	}

	static int minV = Integer.MAX_VALUE;

	static void dfs(String now, int cnt, String target, String[] words) {
		// 기저조건
		if (now.equals(target)) {
			minV = Math.min(minV, cnt);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (!chk[i] && check(now, words[i])) {
				chk[i] = true;
				dfs(words[i], cnt + 1, target, words);
				chk[i] = false;
			}
		}
	}

	// 한글자 다른지 체크
	static boolean check(String str1, String str2) {

		int count = 0;

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				count++;
			if (count > 1)
				return false;
		}

		return true;
	}
}
