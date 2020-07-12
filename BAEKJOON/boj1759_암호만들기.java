import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759_암호만들기 {
	static int L, C;
	static char arr[];
	static boolean chk[];
	static int sel[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 비밀번호 자릿수
		C = Integer.parseInt(st.nextToken()); // 알파벳 후보

		arr = new char[C];
		chk = new boolean[C];
		sel = new int[C];
		for (int i = 0; i < sel.length; i++) {
			sel[i] = Integer.MAX_VALUE;
		}
		
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			String str = st.nextToken();
			char ch = str.charAt(0);

			arr[i] = ch;
		}
		Arrays.sort(arr);

		// 조합
		dfs(0, 0);
		System.out.println(sb.toString());

	}

	private static void dfs(int idx, int cnt) {

		if (idx >= C)
			return;

		if (cnt == L) {
			// 모음 최소 1개, 자음 최소 2개인지 확인 필요
			if (check()) {
				// 맞으면 StringBuilder에 저장
				String tmp = "";
				for (int i = 0; i < sel.length; i++) {
					if (sel[i] != Integer.MAX_VALUE)
						tmp += arr[sel[i]];
				}

				sb.append(tmp).append("\n");
			}
			return;
		}

		for (int i = idx; i < C; i++) {
			if (!chk[i]) {
				chk[i] = true;
				sel[i] = i; // 자리번호 저장
				dfs(i, cnt + 1);
				chk[i] = false;
				sel[i] = Integer.MAX_VALUE;
			}
		}
	}

	private static boolean check() {

		int cnt1 = 0, cnt2 = 0; // 자음 모음 개수
		for (int i = 0; i < sel.length; i++) {
			if (sel[i] != Integer.MAX_VALUE) {
				char ch = arr[sel[i]];
				switch (ch) {
				case 'a':
					cnt1++;
					break;
				case 'e':
					cnt1++;
					break;
				case 'i':
					cnt1++;
					break;
				case 'o':
					cnt1++;
					break;
				case 'u':
					cnt1++;
					break;
				default:
					cnt2++;
					break;
				}
			}
			if (cnt1 >= 1 && cnt2 >= 2)
				return true;
		}
		return false;
	}
}
