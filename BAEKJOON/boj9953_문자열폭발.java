import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 메모리 초과 나는 코드. 다시 풀기
public class boj9953_문자열폭발 {
	public static void main(String[] args) throws IOException {

		// input:
//		mirkovC4nizCC44
//		C4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String tmp = br.readLine();
		StringBuilder sb = new StringBuilder();

		while (input.indexOf(tmp) != -1) {
			if (input.contains(tmp)) {
				input = input.replaceAll(tmp, "");
			}
		}
		if(input.length()!= 0)
			sb.append(input);
		else
			sb.append("FRULA");
		System.out.println(sb.toString());

	}
}
