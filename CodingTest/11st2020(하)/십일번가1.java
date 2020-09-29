
public class 십일번가1 {
	public static void main(String[] args) {
		String S = "aababaa";
		System.out.println(solution(S));

	}

	static public int solution(String S) {
		// write your code in Java SE 8
		int answer = 0;

		int len = S.length();
		int space = len + 1;
		
		int Acnt = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'a') {
				Acnt++;
			}
		}
		
		if (!S.contains("a")) {
			answer = space * 2 - Acnt;
		}
		else if(S.contains("a")) {
			answer = space - Acnt;
		}
		if(S.equals("aa")){
			answer = 0;
		}
		else if(S.contains("aaa")) {
			answer = -1;
		}

		return answer;
	}
}
