import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17822_원판돌리기 {
	static int N, M, T;
	static int[][] pan;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 원판은 각각 회전
		// 원판을 회전시킬때는 수의 위치를 기준으로, 회전시킨 후의 위치는 회전시키기전과 일치해야한다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		pan = new int[N + 1][M];

		// 원판 번호 1부터 시작, 숫자는 0번째부터
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// T번 회전
		for (int step = 0; step < T; step++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			rotatePan(x, d, k);

		}
		// T번 회전후 원판에 적힌 수의 합 구하기
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				ans += pan[i][j];
			}
		}
		System.out.println(ans);
	}

	private static void rotatePan(int x, int d, int k) {

		// i는 판 번호
		for (int i = 1; i <= N; i++) {
			// 판 번호가 x의 배수면 돌려
			if (i % x == 0) {
				if (d == 1)
					isCw(i, k); // 왜 이게 반시계가 됐지
				else if (d == 0)
					isCCw(i, k);
			}
		}

		// 2. 원판에 수가 남아있으면 인접하면서 수가 같은 것을 모두 찾아
		// 이런 수가 있으면 지워
		// 한 원판내에 인접한 같은 숫자
		int[][] copyPan = new int[N + 1][M];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				copyPan[i][j] = pan[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (pan[i][0] != 0 && pan[i][0] == pan[i][1])
					copyPan[i][0] = copyPan[i][1] = 0;
				if (pan[i][0] != 0 && pan[i][0] == pan[i][M - 1])
					copyPan[i][0] = copyPan[i][M - 1] = 0;
				if (pan[i][M - 1] != 0 && pan[i][M - 1] == pan[i][M - 2])
					copyPan[i][M - 1] = copyPan[i][M - 2] = 0;
				if (pan[i][M - 1] != 0 && pan[i][M - 1] == pan[i][0])
					copyPan[i][M - 1] = copyPan[i][0] = 0;
				if (j >= 2 && j < M - 1) {
					if (pan[i][j] != 0 && pan[i][j] == pan[i][j - 1])
						copyPan[i][j] = copyPan[i][j - 1] = 0;
					if (pan[i][j] != 0 && pan[i][j] == pan[i][j + 1])
						copyPan[i][j] = copyPan[i][j + 1] = 0;
				}
				if (pan[1][j] != 0 && pan[1][j] == pan[2][j])
					copyPan[1][j] = copyPan[2][j] = 0;
				if (pan[N][j] != 0 && pan[N][j] == pan[N - 1][j])
					copyPan[N][j] = copyPan[N - 1][j] = 0;
				if (i >= 2 && i < N) {
					if (pan[i][j] != 0 && pan[i][j] == pan[i - 1][j])
						copyPan[i][j] = copyPan[i - 1][j] = 0;
					if (pan[i][j] != 0 && pan[i][j] == pan[i + 1][j])
						copyPan[i][j] = copyPan[i + 1][j] = 0;
				}
			}
		}

		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (pan[i][j] != copyPan[i][j]) // 값이 다르면 인접해서 지워진게 있는거
					flag = true;
				pan[i][j] = copyPan[i][j];
			}
		}

		// 없으면 원판에 적힌 수의 평균을 구하고 평균보다 큰 수에서 1을 빼고 작은수에는 1을 더해

		if (!flag) {
			double sum = 0;
			double cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (pan[i][j] != 0)
						cnt++;
					sum += pan[i][j];
				}
			}
			double avg = (double) (sum / cnt);
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (pan[i][j] != 0) {
						if (avg < pan[i][j]) {
							pan[i][j] -= 1;
						} else if (avg > pan[i][j])
							pan[i][j] += 1;
					}
				}
			}
		}
	}

	private static void isCw(int panNum, int k) {
		// 카피 배열 하나 만들어서 카피뜨고
		int[] copyPan = new int[M];
		for (int i = 0; i < copyPan.length; i++) {
			copyPan[i] = pan[panNum][i];
		}
		// %N 해서 제자리 찾기?

		for (int i = 0; i < copyPan.length; i++) {
			int tmp = i + k % M;

			if (tmp >= M)
				tmp -= M;
			else if (tmp < 0)
				tmp += M;
			pan[panNum][i] = copyPan[tmp];
		}
	}

	private static void isCCw(int panNum, int k) {
		// 카피 배열 하나 만들어서 카피뜨고
		int[] copyPan = new int[M];
		for (int i = 0; i < copyPan.length; i++) {
			copyPan[i] = pan[panNum][i];
		}
		// %N 해서 제자리 찾기?
		for (int i = 0; i < copyPan.length; i++) {
			int tmp = i - k % M;

			if (tmp >= M)
				tmp -= M;
			else if (tmp < 0)
				tmp += M;
			pan[panNum][i] = copyPan[tmp];
		}
	}

}
