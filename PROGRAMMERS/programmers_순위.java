import java.util.Arrays;

public class programmers_순위 {
	public static void main(String[] args) {
		int n = 5;
		int[][] result = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
	}

	static public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] scores = new int[n + 1][n + 1];
		int win, lose;
		
		int INF = 987654321;
		for (int[] score : scores) {
			Arrays.fill(score, INF);
		}

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				if (i == j)
					scores[i][j] = 0;
			}
		}
		
		for (int[] result : results) {
			win = result[0];
			lose = result[1];
			scores[win][lose] = 1;
		}
		
		// 플로이드 와샬
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (scores[i][j] > scores[i][k] + scores[k][j]) {
						scores[i][j] = scores[i][k] + scores[k][j];
					}
				}
			}
		}

		boolean[] flag = new boolean[n + 1];
		Arrays.fill(flag, true);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (scores[i][j] == INF && scores[j][i] == INF) {
					flag[i] = false;
					break;
				}
			}
		}
		
		
		for (int i = 1; i < flag.length; i++) {
			if (flag[i])
				answer++;
		}
		return answer;
	}
}
