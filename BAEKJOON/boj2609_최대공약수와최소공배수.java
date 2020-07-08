import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		int gcd = GCD(N1,N2);
		System.out.println(gcd);
		int lcm = (N1*N2) / gcd;
		System.out.println(lcm);
	}
	
	private static int GCD (int N1, int N2) {
		
		if(N2 <= 0)
			return N1;
		
		return GCD(N2, N1%N2);
	}
}
