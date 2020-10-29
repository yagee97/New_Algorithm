import java.util.Arrays;

public class programmers_입국심사 {

	public static void main(String[] args) {

		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(solution(n, times));
	}

	// 이분탐색으로 하자.
	// 타겟은 n, 이분탐색 기준은 심사를 받는데 걸리는 시간
	// n이랑 비교하기 위해 주어진 시간 동안 검사할 수 있는 사람수 구해야한다
	static public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;

		Arrays.sort(times);

		long left, mid, right;
		left = 0;
		right = (long) n * times[times.length - 1]; // 제일 오래걸리는 심사원이 n명 다 처리하면 걸리는 시간이 최대시간
		long sum = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			// 주어진 시간동안 몇명 검사가능?
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];

				if (sum >= n)
					break;
			}
			if (sum < n) { // 시간내에 n명 다 처리 불가
				left = mid + 1;
			} else { // 시간내에 n명 다 처리할 수 있는데 시간을 줄여봐야한다.
				right = mid - 1;
				answer = mid;
			}
		}
		return answer;
	}

}
