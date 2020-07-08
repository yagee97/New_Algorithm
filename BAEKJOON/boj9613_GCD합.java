import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj9613_GCD합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			int n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			long sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int n1 = list.get(i), n2 = list.get(j);
					if (list.get(i) <= list.get(j)) {
						n2 = list.get(i);
						n1 = list.get(j);
					}
					int tmp = GCD(n1,n2);
					sum += tmp;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int GCD(int n1, int n2) {

		if (n2 <= 0)
			return n1;

		return GCD(n2, n1 % n2);

	}
}
