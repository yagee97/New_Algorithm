import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10819_차이를최대로 {
	static int N;
	static int arr[];
	static boolean chk[];
	static int sel[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		chk = new boolean[N];
		sel = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 순열
		perm(0);
		System.out.println(max);
		
	}
	static int max = Integer.MIN_VALUE;
	private static void perm(int idx) {
		// 순서 다 골랐으면
		if(idx == sel.length) {
			// 차이 더하기 계산!
			int diff = cal();
			if(diff > max)
				max = diff;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!chk[i]) {
				sel[idx] = arr[i];
				chk[i] = true;
				perm(idx+1);
				chk[i] = false;
			}
			
		}
	}
	private static int cal() {
		int ret = 0;
		for (int i = 0; i < sel.length -1; i++) {
			int diff = Math.abs(sel[i] - sel[i+1]);
			ret += diff;
		}
		return ret;
	}
	
	
}
