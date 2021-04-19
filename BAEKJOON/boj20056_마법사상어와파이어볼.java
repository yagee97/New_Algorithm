import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj20056_마법사상어와파이어볼 {
	static class FireBall {
		int r, c, m, s, d;

		public FireBall(int r, int c, int m, int s, int d) {
			this.c = c;
			this.r = r;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}

	static int N, M, K;
	static List<FireBall> map[][];
	static List<FireBall> ball;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N X N 격자에 M 개의 파이어볼ㄹ
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ball = new ArrayList<>();
		map = new List[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		// 파이어볼
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ball.add(new FireBall(r, c, m, s, d));
		}

		// 가장 처음 파이어볼 => 각자 위치에서 이동 대기
		// 질량 m 방향 d 속력 s
		int ans = 0;
		for (int step = 0; step < K; step++) {
			// 명령
			moveFireBall();
			ans = AfterMove();
		}

		// 이동을 k번 명령한 후 남아있는 파이어볼 질량의 합을 구해보자.
		System.out.println(ans);
	}

	// 1. 모든 파이어볼 => 자신의 d 방향 대로 s만큼 이동
	private static void moveFireBall() {

		for (FireBall cur : ball) {
			// 현재 속력으로 움직이게 되면, 속력 / N번 만큼 자기 자리에 위치하게 될 것이고
			// 속력 % N번칸 만큼 더 움직이면 된다.

			int nr = cur.r + (dr[cur.d] * (cur.s % N));
			int nc = cur.c + (dc[cur.d] * (cur.s % N));

			if (nr < 0) {
				nr += N;
			} else if (nr >= N) {
				nr -= N;
			}
			if (nc < 0) {
				nc += N;
			} else if (nc >= N) {
				nc -= N;
			}

			// 이동해야하는 건 무조건 현재 위치 갱신해주기 (새로운 위치로 저장)
			cur.r = nr;
			cur.c = nc;

			map[nr][nc].add(cur); // 파이어볼 map으로 이동 (여러개 가능)
		}
	}

	private static int AfterMove() {
		int answer = 0;
		// 2. 이동이 끝난뒤 2개 이상의 파이어볼이 있는 곳에서는
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() == 1)
					map[i][j].clear();
				if (map[i][j].size() < 2)
					continue;

				int massSum = 0; // 질량합
				int speedSum = 0; // 속도합

				boolean even = true;
				boolean odd = true;

				for (int k = 0; k < map[i][j].size(); k++) {
					massSum += map[i][j].get(k).m; // 질량 다 더하기
					speedSum += map[i][j].get(k).s; // 속력 다 더하기
					if (map[i][j].get(k).d % 2 == 0) // 지금 볼 방향이 짝수면 홀수 false
						odd = false;
					else
						even = false;
					// 합쳐질거니까 파이어볼 리스트에서는 제거
					ball.remove(map[i][j].get(k));
				}

				int retMass = massSum / 5;
				int cnt = map[i][j].size();
				int retSpeed = speedSum / cnt;
				map[i][j].clear(); // 합쳐졌으니까 싹지우기
				// 질량 0인 파이어볼은 소멸
				if (retMass == 0)
					continue;
				if (even | odd) {
					// 0 2 4 6
					for (int k = 0; k < 8; k += 2) {
						ball.add(new FireBall(i, j, retMass, retSpeed, k));
					}
				}else{
					for (int k = 1; k < 8; k += 2) {
						ball.add(new FireBall(i, j, retMass, retSpeed, k));
					}
				}

			}
		}
		for(FireBall cur : ball) {
			answer += cur.m;
		}
		return answer;
	}

}
