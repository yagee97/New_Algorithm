import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17779_게리멘더링2 {

	static int N;
	static int A[][];
	static int map[][];

	public static void main(String[] args) throws IOException {

		// n x n
		// 다섯개의 선거구로 나눠야함
		// 한 선거구에 포함되어 있는 구역은 모두 연결되어야 함
		// A에서 인접한 구역을 통해 B로 갈 수 있을 때 두 구역은 연결
		// 중간에 통하는 인접한 구역은 0개 이상. 모두 같은 선거구에 포함된 구역이여야함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if ((i + d1 + d2) <= N && (j - d1) >= 1 && (i - d1) < j && (j + d2) > j && (j + d2) <= N) {
							map = new int[N + 1][N + 1];
							setBound(i, j, d1, d2);
							fillArea(i, j, d1, d2);
							calAmount();
						}
					}
				}
			}
		}
		System.out.println(ans);

	}
	static int ans = Integer.MAX_VALUE;
	private static void calAmount() {
		int maxV = Integer.MIN_VALUE;
		int minV = Integer.MAX_VALUE;
		for (int k = 1; k <= 5; k++) {
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == k) {
						sum += A[i][j];
					}
				}
			}
			maxV = Math.max(maxV, sum);
			minV = Math.min(minV, sum);
		}
		int diff = maxV - minV;
		ans = Math.min(ans, diff);
	}

	private static void setBound(int x, int y, int d1, int d2) {
		map[x][y] = 5;
		int add1 = 0, add2 = 0;

		// (x,y), (x+1, y-1),...,(x+d1, y-d1)
		while (++add1 <= d1) {
			map[x + add1][y - add1] = 5;
		}

		while (++add2 <= d2) {
			map[x + add2][y + add2] = 5;
		}
		add1 = 0;
		add2 = 0;

		// (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		while (++add2 <= d2) {
			map[x + d1 + add2][y - d1 + add2] = 5;
		}

		while (++add1 <= d1) {
			map[x + d2 + add1][y + d2 - add1] = 5;
		}

		// 나중에 경계선 내 채우기
		for (int r = 1; r <= N; ++r) {
			int left = -1;
			int right = -1;

			int idx = 1;
			while (idx <= N) {
				if (map[r][idx] == 5) {
					left = idx;
					break;
				}
				idx++;
			}

			idx = N;
			while (idx >= 0) {
				if (map[r][idx] == 5) {
					right = idx;
					break;
				}
				idx--;
			}

			if (left != right) {
				for (int i = left; i < right; ++i)
					map[r][i] = 5;
			}
		}
	}

	private static void fillArea(int x, int y, int d1, int d2) {
		/*
		 * 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N 3번 선거구: x+d1
		 * ≤ r ≤ N, 1 ≤ c < y-d1+d2 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		 */
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (map[i][j] != 0)
					continue;
				if (i < (x + d1) && j <= y && i >= 1 && j >= 1)
					map[i][j] = 1;
				else if (i <= (x + d2) && j <= N && j > y && i >= 1)
					map[i][j] = 2;
				else if (i >= (x + d1) && i <= N && j >= 1 && j < (y - d1 + d2))
					map[i][j] = 3;
				else if (i > (x + d2) && i <= N && j >= (y - d1 + d2) && j <= N)
					map[i][j] = 4;

			}
		}

	}

	private static void print() {
		for (int r = 1; r <= N; ++r) {
			for (int c = 1; c <= N; ++c) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
