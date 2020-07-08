import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1978_소수찾기 {
	static int prime[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		prime = new int[1001];

		// 에라토스 !
		Prime();
		int ret = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(prime[num] != 0){
				ret++;
			}
		}
		System.out.println(ret);
	}

	private static void Prime() {
		// 초기화
		for (int i = 2; i < prime.length; i++) {
			prime[i] = i;
		}

		// 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
		// 자기자신은 지우지 않고 이미 지워진 수는 건너뛴다.
		for (int i = 2; i < prime.length; i++) {
			// 이미 지워진거
			if (prime[i] == 0)
				continue;

			for (int j = 2 * i; j < prime.length; j+=i) {
				prime[j] = 0; // 소수 아니니까 지움
			}
		}
	}

}
