import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안랩5 {
   static int[] cards;
   static int num;
   public static void main(String[] args) throws IOException {

      cards = new int[] {1,4,6};
      num = 8;
      System.out.println(solution(num, cards));
   }

   // cards에서 카드 사용해서 num 만들기.
   // 카드 제일 적게 쓰는 법

   public static int solution(int num, int[] cards) {
      int answer = 0;

      int n = cards.length;
      int[] dp = new int[num + 1];
      
      // w는 num
      for (int i = 1; i <= num; i++) {
         dp[i] =  10001;
      }
      dp[0] = 0;
      
      for (int i = 1; i <= num; i++) {
         for (int j = 0; j < n; j++) {
            
            if(i >= cards[j]) {
               dp[i] = Math.min(dp[i], dp[i-cards[j]] + 1);
            }
         }
      }      
      if(dp[num] == 10001)
         answer = -1;
      else 
         answer = dp[num];
      
      return answer;
   }
   
   
   
}