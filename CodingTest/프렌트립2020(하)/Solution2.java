package 프렌트립;

public class Solution2 {
	  public static void main(String[] args) {
	      System.out.println(solution(5, 3, 2));
	   }

	   public static long solution(int n, int r, int c) {
	      long answer = 0;
	      long level = r + c - 1;
	      if (level <= n) {
	         long first_num = (level * level - level) / 2 + 1;
	         answer = first_num + c;
	      } else {
	         long new_level = n - (level - n);
	         long first_num = (n * n - n) / 2 + 1;
	         long cross_last_num = first_num + n - 1;

	      }
	      return answer;
	   }

}
