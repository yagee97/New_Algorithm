import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class boj2309_일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = new int[9];
		int[] answer = new int[7];
		int cnt = 0;
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i]; // 합을 먼저 받고
		}

		// 합에서 두개를 빼서 100이 나오는 거 찾기
		out: for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((sum - arr[i] - arr[j]) == 100) {
					for (int k = 0; k < arr.length; k++) {
						if (k != i && k != j) {
							answer[cnt] = arr[k];
							cnt++;
						}
					}
					break out;
				}
			}
		}
		Arrays.sort(answer);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
