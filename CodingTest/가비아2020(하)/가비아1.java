
public class 가비아1 {
	public static void main(String[] args) {

		System.out.println(solution(3, 4, 20));

	}

	static public int solution(int mod1, int mod2, int max_range) {
		int answer = 0;

		int check = mod1 * mod2 / gcd(mod1, mod2);
		answer = max_range / mod1 - max_range / check;

		return answer;
	}

	static private int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
