import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206_���μ����̵��ϱ� {
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

		// 0�� �̵����� 1�� ��
		// �� �Ѱ��� �μ��� ����
		// �ִ� ��� ������.
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
			// �����ϸ� �׶������� �Ÿ� �����ϰ� ��
			if (x == N - 1 && y == M - 1) {
				ans = d;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;
				// ���� �Ѽ��� �������� �ȿ�����,,?
				if (chk[nx][ny][wall])
					continue;

				// ���̸�
				if (map[nx][ny] == 1) {
					// �̹� �ѽ��� ������
					if (wall == 1) {
						continue;
					}
					// �� �ѽ��� ������ �ѽð� ��������
					else if (wall == 0) {
						chk[nx][ny][wall] = true;
						queue.add(new Info(nx, ny, wall + 1, d + 1));
					}
				}
				// �� �ƴϸ�
				else if (map[nx][ny] == 0) {
					chk[nx][ny][wall] = true;
					queue.add(new Info(nx, ny, wall, d + 1));
				}
			}

		}

	}

	static class Info {
		int x, y;
		int wall; // �� � �Ѽ̳�
		int d; // �� ĭ °��

		public Info(int x, int y, int wall, int d) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.d = d;
		}

	}
}
