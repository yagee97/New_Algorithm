
public class 가비아2 {
	public static void main(String[] args) {

		System.out.println(solution(3000, 5000, 23000));

	}

	static public int solution(int a, int b, int budget) {
		int answer = 0;

		for (int i = 0; i * a <= budget; i++) {
		      if ((budget - (i * a)) % b == 0)
		         answer++;
		   }
		return answer;
	}

	
}
