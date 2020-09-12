import java.util.*;

class 카카오4 {
    static int INF = 987654321;
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
              { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
        System.out.println(solution(n, s, a, b, fares));
     }
   static public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j= 0; j <= n; j++){
                if( i == j ) 
                    continue;
                dp[i][j] = INF;
            }
        }
        for(int[] tmp : fares){
         dp[tmp[0]][tmp[1]] = tmp[2];
            dp[tmp[1]][tmp[0]] = tmp[2];
      }
        // 플로이드 와샬
        for(int k = 1; k <= n; k++) {
         for(int i= 1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
               dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
            }
         }
      }
        int answer = dp[s][a] + dp[s][b];
        for(int k=1; k<=n; k++){
            if(dp[s][k] == INF)
                continue;
            if(answer > dp[s][k] + dp[k][a] + dp[k][b]){
                answer = dp[s][k] + dp[k][a] + dp[k][b];
            }
        }

        return answer;
    }
}