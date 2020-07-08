import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1934_최소공배수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());

			int gcd = GCD(N1, N2);
			int lcm = (N1*N2) / gcd;
			sb.append(lcm).append('\n');
		}
		System.out.println(sb.toString());
	}

	private static int GCD(int N1, int N2) {

		if (N2 <= 0)
			return N1;

		return GCD(N2, N1 % N2);
	}
}
