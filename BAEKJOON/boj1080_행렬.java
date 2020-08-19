import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj1080_행렬 {
	static int N, M;
	static int[][] original, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		original = new int[N][M];
		result = new int[N][M];

		// original
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				original[i][j] = str.charAt(j) - '0';
			}
		}

		// result
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				result[i][j] = str.charAt(j) - '0';
			}
		}
		boolean flag = true;
		int ans = 0;
		// 3*3 뒤집고 check
		if (N >= 3 && M >= 3) {
			for (int i = 0; i <= N - 3; i++) {
				for (int j = 0; j <= M - 3; j++) {
					if (original[i][j] != result[i][j]) {
						ans++;
						for (int x = i; x < i + 3; x++) {
							for (int y = j; y < j + 3; y++) {
								original[x][y] ^= 1;
							}
						}
					}
				}
				if (Objects.deepEquals(original, result)) {
					flag = false;
					break;
				}
			}
		} else if (N < 3 || M < 3) {
			if (Objects.deepEquals(original, result)) {
				flag = false;
				ans = 0;
			} else
				ans = -1;
		}
		if (flag)
			ans = -1;
		System.out.println(ans);

	}

}
