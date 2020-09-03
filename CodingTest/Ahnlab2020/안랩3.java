import java.util.Arrays;

public class 안랩3 {
	public static void main(String[] args) {

		String[] bishops = { "C6"};
		int ans = solution(bishops);
		System.out.println(ans);

	}

	public static int solution(String[] bishops) {
		int answer = 0;
		int[][] map = new int[8][8];

		for (String b : bishops) {
			// 알파벳부분
			int x = b.charAt(0) - 65;
			int y = b.charAt(1) - '0';
			map[x][y - 1] = 1; // 비숍 있는 곳
		}

		// 비숍 이동
		int res = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 1) {
					res += move(map, i, j);
					res++; // 비숍개수
				}
			}
		}
		// 남은 칸
		answer = 64 - res;

		return answer;
	}

	public static int move(int[][] map, int x, int y) {
		int[] dx = { -1, -1, 1, 1 };
		int[] dy = { -1, 1, -1, 1 };
		int cnt = 0;
		// 대각선 방향 정하고
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			
			// 범위 초과할 때까지 계속 이동
			while (true) {
				nx += dx[i];
				ny += dy[i];
				// 범위 초과
				if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8)
					break;
				// 빈칸이면
				if (map[nx][ny] == 0) {
					cnt++;
					map[nx][ny] = 2; // 비숍 방문
				}
			}

		}
		return cnt;
	}
}