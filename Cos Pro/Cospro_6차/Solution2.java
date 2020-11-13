package Cospro_6차;

class Solution2 {
	public int solution(int K, String[] words) {
		// 여기에 코드를 작성해주세요.
		int answer = 2;

		// 한 줄에 10글자
		// cnt 10글자 해가면서 다음단어 나올때 10-앞단어 >= 다음단어 +1 이어야 함. 아니면 다음줄로 cnt = 0, answer++;
		int cnt = 0;
		boolean first = true;
		for (int i = 0; i < words.length; i++) {
			int len = words[i].length();
			if (first) {
				cnt += len;
				first = false;
				continue;
			}
			else {
				if(10 - (cnt) >= len + 1) {
					cnt += len + 1; // 공백포함
				}
				else {
					cnt = 0;
					first = true;
					answer++;
				}
			}

		}

		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int K = 10;
		String[] words = { new String("nice"), new String("happy"), new String("hello"), new String("world"),
				new String("hi") };
		int ret = sol.solution(K, words);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
	}
}