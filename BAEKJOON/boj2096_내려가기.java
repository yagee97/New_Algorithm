import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2096_내려가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] max = new int[3];
		int[] min = new int[3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 첫째줄 값은 그대로 넣어라
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			if (i == 0) {
				max[0] = min[0] = n1;
				max[1] = min[1] = n2;
				max[2] = min[2] = n3;
			} else {
				// 0번째꺼는 둘째줄의 0,1로
				// 1번째꺼는 둘째줄의 0,1,2로
				// 2번째꺼는 둘째줄의 1,2로 이동
				// 큰거 찾으려면 갈수있는애들 중에 최대인 걸로 가면된다.
				int tmp = max[0]; // max[0]이 갱신되기 때문에 미리 값 저장
				int tmp2 = max[1];

				max[0] = Math.max(max[0], max[1]) + n1;
				max[1] = Math.max(Math.max(tmp, max[1]), max[2]) + n2;
				max[2] = Math.max(max[2], tmp2) + n3;

				tmp = min[0];
				tmp2 = min[1];

				min[0] = Math.min(min[0], min[1]) + n1;
				min[1] = Math.min(Math.min(tmp, min[1]), min[2]) + n2;
				min[2] = Math.min(min[2], tmp2) + n3;

			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(max[0], Math.max(max[1], max[2]))).append(" ");

		sb.append(Math.min(min[0], Math.min(min[1], min[2]))).append("\n");
		System.out.println(sb.toString());
	}
}
