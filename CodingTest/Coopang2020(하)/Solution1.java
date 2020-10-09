package coopang;

import java.util.Arrays;

public class Solution1 {
	   public static void main(String[] args) {
	      System.out.println(Arrays.toString(solution(14)));
	   }

	   static public int[] solution(int N) {
	      int[] answer = new int[2];
	      int maxV = Integer.MIN_VALUE;
	      int idx = 0;

	      for (int i = 2; i < 10; i++) {
	         int ans = solve(N, i);
	         if (ans >= maxV) {
	            maxV = ans;
	            idx = i;
	         }
	      }
	      answer[0] = idx;
	      answer[1] = maxV;

	      return answer;
	   }

	   // 변환
	   private static int solve(int N, int b) {
	      String ans = "";
	      while (N > 0) {
	         int mod = N % b;
	         N /= b;
	         ans += mod;
	      }
	      int multi = 1;
	      for (int i = 0; i < ans.length(); i++) {
	         int num = ans.charAt(i) - '0'; // 숫자
	         if (num == 0)
	            continue;
	         multi *= num;
	      }
	      return multi;
	   }
	}