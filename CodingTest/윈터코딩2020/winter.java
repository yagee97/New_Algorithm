import java.util.ArrayList;

public class winter {

	public static void main(String[] args) {

		int n = 6;
		int[][] delivery = { { 1, 3, 1 }, { 3, 5, 0 }, { 5, 4, 0 }, { 2, 5, 0 } };

		System.out.println(solution(n, delivery));

	}

	static public String solution(int n, int[][] delivery) {
		String answer = "";

		int[] freq = new int[n + 1];

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < delivery.length; i++) {
			int num1 = delivery[i][0];
			int num2 = delivery[i][1];
			int d = delivery[i][2];

			// 재고 남음
			if (d == 1) {
				freq[num1] = 1;
				freq[num2] = 1;
			} else if (d == 0) {
				if (freq[num1] == 1)
					freq[num2] = -1;
				else if (freq[num2] == 1)
					freq[num1] = -1;
				else {
					list.add(i);
				}
			}
		}

		for (int i : list) {
			int num1 = delivery[i][0];
			int num2 = delivery[i][1];
			int d = delivery[i][2];

			// 재고 남음
			if (d == 1) {
				freq[num1] = 1;
				freq[num2] = 1;
			} else if (d == 0) {
				if (freq[num1] == 1)
					freq[num2] = -1;
				else if (freq[num2] == 1)
					freq[num1] = -1;
				else {
					list.add(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < freq.length; i++) {
			if (freq[i] == 1)
				sb.append("O");
			else if (freq[i] == -1)
				sb.append("X");
			else
				sb.append("?");
		}

		answer = sb.toString();
		return answer;
	}

}
