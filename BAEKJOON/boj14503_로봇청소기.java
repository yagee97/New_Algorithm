import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503_로봇청소기 {
	static int N, M;
	static int map[][];
	static int Rx, Ry, Rd;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		// 청소하는 영역의 개수 구해라
		// n x m
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// (로봇청소기 위치) 방향 존재. 동서남북
		st = new StringTokenizer(br.readLine());
		Rx = Integer.parseInt(st.nextToken());
		Ry = Integer.parseInt(st.nextToken());
		Rd = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve(Rx, Ry, Rd));
	}

	private static int solve(int Rx, int Ry, int Rd) {
		int cnt = 0;
		int clean = 0;
		int nx = 0, ny = 0;

		boolean flag = true;
		// 1이 벽. 빈칸은 0
		while (flag) {
			// 현재 위치 청소
			if (map[Rx][Ry] == 0) {
				map[Rx][Ry] = 2;
				clean++;
			}

			// 탐색
			while (true) {
				// 사방이 벽이거나 청소되어있으면
				if (cnt == 4) {
					nx = Rx - dx[Rd];
					ny = Ry - dy[Rd];
					
					// 후진했는데 벽이면
					if(map[nx][ny] == 1) {
						flag = false;
						break;
					}else {
						Rx = nx;
						Ry = ny;
						cnt = 0;
					}
				}

				// 회전
				Rd = (Rd + 3) % 4;
				nx = Rx + dx[Rd];
				ny = Ry + dy[Rd];

				if (map[nx][ny] == 0) {
					// 연속되는 벽 카운트 초기화
					cnt = 0;
					Rx = nx;
					Ry = ny;
					break;
				} else {
					cnt++;
					continue;
				}
			}

		}
		return clean;
	}
}
