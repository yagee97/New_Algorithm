import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234_인구이동 {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, L, R;
	static int map[][];
	static ArrayList<Pos> union;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		union = new ArrayList<>();
		visit = new boolean[N][N];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = false; // f는 인구이동 x t는 인구이동
		while (true) {
			// 인구수 계산해서 국경선 열고 연합까지
			int tmp = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(i, j);
						// 국경선 열기 끝난 국가 인구 이동
						flag = move();
						if(flag)
							tmp++; // 이번 차례에서 인구이동 된 횟수
						union = new ArrayList<>(); // 연합 와해
//						for (int j2 = 0; j2 < N; j2++) {
//							System.out.println(Arrays.toString(map[j2]));
//						}
//						System.out.println("==============");
					}
				}
			}
			if(tmp == 0)
				break;
			cnt++;
		}

		System.out.println(cnt);

	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static boolean[][] visit;

	private static void bfs(int x, int y) {
		// 인구차이 계산해서 차이가 L이상 R이하면 같은 list에 넣기
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(x, y));
		union.add(new Pos(x, y));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				int diff = Math.abs(map[p.x][p.y] - map[nx][ny]);
				// 이어진 국가들의 인구차이가 L이상 R이하면
				if (!visit[nx][ny] && diff >= L && diff <= R) {
					queue.add(new Pos(nx, ny));
					visit[nx][ny] = true;
					// 연합에 넣기
					union.add(new Pos(nx, ny));
				}
			}
		}

	}

	private static boolean move() {
		int sum = 0;
		if(union.size()== 1)
			return false;

		for (int i = 0; i < union.size(); i++) {
			int x = union.get(i).x;
			int y = union.get(i).y;
			sum += map[x][y];
		}
		int total = sum / (int) union.size();

		for (int i = 0; i < union.size(); i++) {
			int x = union.get(i).x;
			int y = union.get(i).y;
			map[x][y] = total;
		}
		return true;
	}

}
