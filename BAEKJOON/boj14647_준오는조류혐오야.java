import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14647_준오는조류혐오야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = 0;
		int count = 0;
		int maxV = Integer.MIN_VALUE;
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				int tmp = map[i][j];
				while (tmp > 0) {
					if (tmp % 10 == 9) {
						k++;
						count++; // 전체 9의 개수
					}
					tmp /= 10;
				}
			}
			if (k > maxV)
				maxV = k;
			k = 0;
		}

		// 구현
		// 9한개씩 각각 세야함
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				int tmp = map[j][i];
				while (tmp > 0) {
					if (tmp % 10 == 9) {
						k++;
					}
					tmp /= 10;
				}
			}
			if (k > maxV)
				maxV = k;
			k = 0;
		}
		int ans = count - maxV;
		System.out.println(ans);

	}
}
