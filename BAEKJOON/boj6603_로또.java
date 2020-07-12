import java.io.BufferedReader;
import java.io.InputStreamReader;

class boj6603_로또 {
	static int N;
	static int[] input;
	static int[] ret;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			input = new int[N];
			ret = new int[N];

			if (N == 0) {
				break;
			}
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(str[i + 1]);
			}
			dfs(0, 0);
			System.out.println();
		}

	}

	public static void dfs(int idx, int cnt) {
		if (cnt == 6) {
			print();
		}
		for (int i = idx; i < N; i++) {
			ret[i] = 1;
			dfs(i + 1, cnt + 1);
			ret[i] = 0;
		}

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			if (ret[i] == 1)
				System.out.print(input[i] + " ");
		}
		System.out.println();
	}

}