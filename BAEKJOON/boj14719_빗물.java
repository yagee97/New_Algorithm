import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		
		st = new  StringTokenizer(br.readLine());
		int maxV = Integer.MIN_VALUE;
		int maxIdx = 0;
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(maxV < arr[i]) {
				maxV = arr[i];
				maxIdx = i;
			}
		}
		
		int mid = maxIdx;
		int left = 0;
		int right = W-1;
		
		int ans = 0;
		for (int i = 0; i < mid; i++) {
			if(arr[left] > arr[i]) { // 지금꺼보다 다음꺼가 더 작아야 빗물 고임
				ans += arr[left] - arr[i];
			}else {
				left = i;
			}
		}
		
		for (int i = W-1; i > mid; i--) {
			if(arr[right] > arr[i])
				ans += arr[right] - arr[i];
			else
				right = i;
		}
		
		System.out.println(ans);
	}
}
