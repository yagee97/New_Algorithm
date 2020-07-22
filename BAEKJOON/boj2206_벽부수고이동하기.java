import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206_벽부수고이동하기 {
	static int N, M;
	static int map[][];
	static boolean chk[][][];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		chk = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 0은 이동가능 1은 벽
		// 벽 한개만 부수기 가능
		// 최단 경로 구하자.
		// bfs
		bfs(0, 0);
		if (ans == 0)
			System.out.println("-1");
		else
			System.out.println(ans);

	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	private static void bfs(int x, int y) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(x, y, 0, 1));
		chk[x][y][0] = true;

		while (!queue.isEmpty()) {
			Info info = queue.poll();
			x = info.x;
			y = info.y;
			int wall = info.wall;
			int d = info.d;
			// 도착하면 그때까지의 거리 저장하고 끝
			if (x == N - 1 && y == M - 1) {
				ans = d;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;
				// 벽을 뿌수고 왔을때와 안왔을때,,?
				if (chk[nx][ny][wall])
					continue;

				// 벽이면
				if (map[nx][ny] == 1) {
					// 이미 뿌신적 있으면
					if (wall == 1) {
						continue;
					}
					// 벽 뿌신적 없으면 뿌시고 다음으로
					else if (wall == 0) {
						chk[nx][ny][wall] = true;
						queue.add(new Info(nx, ny, wall + 1, d + 1));
					}
				}
				// 벽 아니면
				else if (map[nx][ny] == 0) {
					chk[nx][ny][wall] = true;
					queue.add(new Info(nx, ny, wall, d + 1));
				}
			}

		}

	}

	static class Info {
		int x, y;
		int wall; // 벽 몇개 뿌셨냐
		int d; // 몇 칸 째냐

		public Info(int x, int y, int wall, int d) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.d = d;
		}

	}
}
