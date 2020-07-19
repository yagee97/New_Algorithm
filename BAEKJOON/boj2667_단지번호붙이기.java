import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667_단지번호붙이기 {
	static int N, cnt = 0;
	static int map[][];
	static boolean chk[][];
	static int apt[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		chk = new boolean[N][N];
		apt = new int[N * N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// dfs
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!chk[i][j] && map[i][j] != 0) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		// 단지 개수
		System.out.println(cnt);
		// 오름차순
		Arrays.sort(apt);
		for (int i = 0; i < apt.length; i++) {
			if (apt[i] != 0)
				System.out.println(apt[i]);
		}

	}

	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	private static void dfs(int x, int y) {

		chk[x][y] = true;
		apt[cnt]++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= N || ny >= N || nx < 0 || ny < 0)
				continue;
			if (!chk[nx][ny] && map[nx][ny] != 0) {
				chk[nx][ny] = true;
				dfs(nx, ny);
			}
		}

	}

}
