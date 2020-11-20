import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11504_돌려돌려돌림판 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int x = 0;
			int y = 0;
			int[] board = new int[N + M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				sb.append(n);
			}
			x = Integer.parseInt(sb.toString());
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				sb.append(n);
			}
			y = Integer.parseInt(sb.toString());
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				board[i] = Integer.parseInt(st.nextToken());
			} // 입력 끝

			// 이어질 부분
			for (int i = 0; i < M - 1; i++) {
				board[N + i] = board[i];
			}

			int answer = 0;
			for (int i = 0; i < board.length - M  ; i++) {
				boolean flag = true;
				for (int j = 0; j < M; j++) {
					sb.append(board[i+j]);
				}
	
				int num = Integer.valueOf(sb.toString());
				if(x <= num && num <= y)
					answer++;
				sb = new StringBuilder();
			}
			System.out.println(answer);
		}

	}

}
