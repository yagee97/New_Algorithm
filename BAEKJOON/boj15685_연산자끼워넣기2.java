import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15685_연산자끼워넣기2 {
	static int N;
	static int number[];
	static int oper[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		number = new int[N];
		oper = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			number[i] = num;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < oper.length; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			oper[i] = tmp;
		}

		// 백트래킹
		solve(1, number[0]);
		System.out.println(max);
		System.out.println(min);

	}

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	private static void solve(int idx, int sum) {
		if (idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		if (oper[0] > 0) {
			oper[0]--;
			solve(idx + 1, sum + number[idx]);
			oper[0]++;
		}
		if (oper[1] > 0) {
			oper[1]--;
			solve(idx + 1, sum - number[idx]);
			oper[1]++;
		}
		if (oper[2] > 0) {
			oper[2]--;
			solve(idx + 1, sum * number[idx]);
			oper[2]++;
		}
		if (oper[3] > 0) {
			oper[3]--;
			if (sum < 0 && number[idx] > 0)
				solve(idx + 1, ((sum * -1) / number[idx]) * -1);
			else
				solve(idx + 1, sum / number[idx]);
			oper[3]++;
		}
	}
}
