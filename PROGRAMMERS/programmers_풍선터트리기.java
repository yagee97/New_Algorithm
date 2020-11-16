
public class programmers_풍선터트리기 {
	public static void main(String[] args) {
		int[] a= {9,-1,5};
		System.out.println(solution(a));
	}

	static    public int solution(int[] a) {
		int answer = 0;

		// 맨 처음 풍선은 무조건 남길수 있음
		// 맨 처음 풍선만 무조건인줄 알았는데 맨 마지막꺼도 가능.
		
		int left = a[0];
		int right = a[a.length-1];
		// 맨 앞, 맨 뒤를 기준으로  나머지 부분의 맨 앞 맨뒤 비교 좁혀가면서
		for (int i = 1; i < a.length-1; i++) {
			if(left > a[i]) {
				left = a[i];
				answer++;
			}
			if(right > a[a.length-1-i]) {
				right = a[a.length-1-i];
				answer++;
			}
		}
		answer += 2;
		
       if(right == left)
           return answer - 1;
       else
		return answer;
	}
}
