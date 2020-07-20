import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1261_알고스팟 {
	static int N, M;
	static int map[][];
	static int d[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		d = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				d[i][j] = Integer.MAX_VALUE;
			}
		}
		// BFS로 다익스트라.
		bfs(0, 0);
		System.out.println(d[N - 1][M - 1]);

	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int ret = 0;

	private static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		d[x][y] = 0;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			x = p.x;
			y = p.y;

			if (x == N && y == M) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;

				if (d[nx][ny] > d[x][y] + map[nx][ny]) {
					d[nx][ny] = d[x][y] + map[nx][ny];
					q.add(new Pos(nx, ny));
				}

			}

		}
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
