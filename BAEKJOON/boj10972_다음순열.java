import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10972_다음순열 {
	static int N;
	static int[] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 넥퍼뮤
		if(next_permutation(input)) {
			for (int i = 0; i < N; i++) {
				System.out.print(input[i] + " ");
			}
		}
		else
			System.out.println("-1");

		
	}
	
	private static boolean next_permutation(int[] list) {
		// 리스트의 맨 뒤부터 시작
		int i = list.length -1;
		int j = list.length -1;
		
		
		// 1. 꼭대기 찾기
		while(i > 0 && list[i-1] >= list[i]) {
			--i;
		}
		if(i <= 0) return false;
		
		// 2. j값 찾기 (i-1은 교환할 자리. 이것보다 큰 값중에 가장 작은 숫자 고르기)
		while(list[i-1] >= list[j]) {
			--j;
		}
		swap(list, i-1, j);
		
		// 3. i부터 맨 끝까지 오름차순 정렬
		int k = list.length -1;
		while(i<k) {
			swap(list, i, k);
			++i; --k;
		}
		
		return true;
	}

	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
