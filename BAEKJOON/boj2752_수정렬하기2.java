import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2752_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		for(int num : list) {
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
	}
}
