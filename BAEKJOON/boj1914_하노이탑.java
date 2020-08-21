import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class boj1914_하노이탑 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		BigInteger bi = new BigInteger("2");
		BigInteger K = bi.pow(N).subtract(BigInteger.ONE);
		System.out.println(K);
		if (N <= 20) {
			hanoi(N, 1, 2, 3);
			System.out.println(sb.toString());
		}
	}

	private static void hanoi(int n, int from, int via, int to) {

		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}

		// n개의 원판 from에서 to까지 옮기자 3가지 과정으로!
		// 1번: n-1개 원판을 시작에서 도착을 거쳐 중간막대로!
		hanoi(n - 1, from, to, via);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n - 1, via, from, to);

		return;
	}
}
