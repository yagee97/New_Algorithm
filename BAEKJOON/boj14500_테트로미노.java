import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14500_테트로미노 {
	static int N, M, maxV;
	static int[][] map;
	static boolean[][] chk;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		chk = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 전체 칸 N *M에서 각 칸의 좌표 구해서 DFS
		for (int i = 0; i < N * M; i++) {
			int x = i / M;
			int y = i % M;
			chk[x][y] = true;
			// dfs
			dfs(x, y, 1, map[x][y]);
			// ㅗ 자 따로 구하기
			cal(x, y);
			chk[x][y] = false;
		}
		System.out.println(maxV);

	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	private static void dfs(int x, int y, int cnt, int sum) {

		// 정사각형 4개의 합을 봐야하는 거니까 cnt 4
		if (cnt == 4) {
			// 합 최대 구하기
			maxV = Math.max(maxV, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			// 이쪽으로 뻗어서 'ㅡ' 만들고, 저쪽으로 뻗어서 'ㄱ'만들고 해야하니까 백트래킹
			if (!chk[nx][ny]) {
				chk[nx][ny] = true;
				dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
				chk[nx][ny] = false;
			}

		}
	}

	private static void cal(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int total = map[x][y];
			boolean flag = true;

			for (int j = 0; j < 3; j++) {
				int nx = x + dx[(i + j) % 4];
				int ny = y + dy[(i + j) % 4];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					total += map[nx][ny];
				} else {
					flag = false;
					break;
				}
			}
			if (flag)
				maxV = Math.max(maxV, total);
		}

	}
}
