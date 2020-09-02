import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] origin = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			origin[i] = num;
		}
		// 누적합 배열
		int[] count = new int[10001];
		
		// 빈도수를 누적합 배열에 작성
		for (int i = 0; i < N; i++) {
			count[origin[i]]++;
		}
		
		// 누적합 만들기
		for (int i = 1; i < 10001; i++) {
			count[i] += count[i-1];
		}
		
		int[] res = new int[N+1];
		// origin 배열을 뒤부터 순회하며 정렬된 배열에 인덱스 찾아서 넣기
		// count -1
		for (int i = N-1; i >= 0; i--) {
			count[origin[i]]-=1;
			int idx = count[origin[i]];
			res[idx] = origin[i];
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb.toString());

	}
}
