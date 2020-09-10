import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2117_홈방범서비스 {
	static int N, M;
	static int[][] map;
	static int ans = 0, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MIN_VALUE;
			// 맵 나가도 되기 때문에
			for (int k = 1; k <= N + 1; k++) {
				// 마름모 중앙
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						cnt = 0;
						solve(k, i, j);
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());

	}
	
	private static void solve(int k, int x, int y) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 마름모 안에 집!
				if(Math.abs(x-i) + Math.abs(y-j) <= k - 1 && map[i][j] == 1) {
					cnt++;
				}
			}
		}
		// 이익 계산
		int bene = (cnt * M) - (k * k + (k-1) * (k-1));
		if(bene >= 0) {
			ans = Math.max(ans, cnt);
		}
	}
}
