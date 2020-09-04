import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj10974_모든순열 {
	static int N;
	static int[] arr, res;
	static boolean[] sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		res = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		sel = new boolean[N + 1];
		// perm
		perm(0);
	}

	private static void perm(int idx) {

		if (idx == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!sel[i]) {
				res[idx] = arr[i];
				
				sel[i] = true;
				perm(idx + 1);
				sel[i] = false;
			}
		}
	}
}
