import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10430_나머지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int ret1 = (A+B)%C;
		int ret2 = ((A%C) + (B%C))%C;
		int ret3 = (A * B) %C;
		int ret4 = ((A%C) * (B%C))%C;
		
		StringBuilder sb = new StringBuilder();
		sb.append(ret1).append("\n");
		sb.append(ret2).append("\n");
		sb.append(ret3).append("\n");
		sb.append(ret4);
		
		System.out.println(sb.toString());
		
	}
}
