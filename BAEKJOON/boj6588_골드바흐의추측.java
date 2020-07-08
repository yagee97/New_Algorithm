import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj6588_골드바흐의추측 {
	static int dest;
	static int prime[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime = new int[1000001];
		primeNumber();

		while (true) {
			dest = Integer.parseInt(br.readLine());
			// 입력이 0이면 종료
			if (dest == 0)
				break;

			int ret1 = 0, ret2 = 0;
			for(ret1 = 3; ret1 <= dest-1; ret1++) {
				if(prime[ret1] != 0) {
					ret2 = dest - ret1;
					if(prime[ret2] !=0) {
						sb.append(dest).append(" = ").append(ret1).append(" + ").append(ret2).append("\n");
						break;
					}
				}
			}
			if(ret1 == 0 &&  ret2 == 0)
				sb.append("Goldbach's conjecture is wrong.");
		}
	
		System.out.println(sb.toString());
	}

	// 소수 판별
	private static void primeNumber() {

		// 초기화
		for (int i = 2; i <= 1000000; i++) {
			prime[i] = i;
		}

		for (int i = 2; i <= 1000000; i++) {
			if (prime[i] == 0)
				continue;

			for (int j = i * 2; j <= 1000000; j += i) {
				prime[j] = 0;
			}
		}
	}
}
