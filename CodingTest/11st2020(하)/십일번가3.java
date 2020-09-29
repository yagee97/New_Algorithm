
public class 십일번가3 {
	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 4 };
		System.out.println(solution(A));
	}

	static public int solution(int[] A) {
		long maxV = 1000000000;
		
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int n = A.length;
		long total = n * (n + 1)/2;
		if(Math.abs((int)(total - sum)) > maxV)
			return -1;

		return Math.abs((int)(total - sum));
	}
}
