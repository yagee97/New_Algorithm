import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1182_부분수열의합 {
	static int N, S, arr[];
	static int sum = 0, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		solve();
		if (S == 0)
			System.out.println(cnt - 1);
		else
			System.out.println(cnt);

	}

	// 부분집합 구하기. 비트마스킹
	private static void solve() {

		for (int i = 0; i < (1 << N); i++) {
			sum = 0;
			for (int j = 0; j <= N; j++) {
				if (((1 << j) & i) > 0) {
					sum += arr[j];
				}
			}
			if (sum == S)
				cnt++;
		}
	}

}
