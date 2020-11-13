package Cospro_6차;

class Solution3 {
	public int solution(int[] arr, int K) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;

		sel = new int[K];
		chk = new boolean[arr.length];

		dfs(0, 0, arr, K);
		answer = ans;
		ans = 0;
		return answer;
	}

	static int[] sel;
	static int ans = Integer.MAX_VALUE;
	static boolean[] chk;

	private static void dfs(int idx, int cnt, int[] arr, int K) {
		if (cnt == K) {
			// 다 선택했으면 최대 최소 비교
			int maxV = Integer.MIN_VALUE;
			int minV = Integer.MAX_VALUE;
			for (int i = 0; i < chk.length; i++) {
				if (chk[i]) {
					maxV = Math.max(maxV, arr[i]);
					minV = Math.min(minV, arr[i]);
				}
			}
			ans = Math.min(ans, (maxV - minV));
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			if (!chk[i]) {
				chk[i] = true;
				dfs(i + 1, cnt + 1, arr, K);
				chk[i] = false;
			}
		}

	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int[] arr = { 9, 11, 9, 6, 4, 19 };
		int K = 4;
		int ret = sol.solution(arr, K);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + "입니다.");
	}
}