package CosPro_1차;

class Solution2 {
	int dx[] = {0,1,0,-1};
	int dy[] = {1,0,-1,0};
    public int solution(int n) {
        // Write code here.
        int answer = 0;
        
        int[][] map = new int[n][n];
        
        int cx = 0;
        int cy = 0;
        int num = 1;
        while(inRange(cx, cy, n) && map[cx][cy] == 0) {
        	for (int k = 0; k < 4; k++) {
				if(!inRange(cx, cy, n) || map[cx][cy] != 0)
					break;
				while(true) { // 같은 방향으로 쭉 가야함
					map[cx][cy] = num++;
					int nx = cx + dx[k];
					int ny = cy + dy[k];
					if(!inRange(nx, ny, n) || map[nx][ny] != 0) {
						cx += dx[(k+1) % 4];
						cy += dy[(k+1)%4];
						break;
					}
					cx = nx;
					cy = ny;
				}
			}
        }
        for (int i = 0; i < map.length; i++) {
			answer+= map[i][i];
		}
        
        return answer;
    }
    
    boolean inRange(int i, int j, int n) {
    	return 0 <= i && i <n && 0 <= j && j <n;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n1 = 3;
        int ret1 = sol.solution(n1);

        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");
        
        int n2 = 2;
        int ret2 = sol.solution(n2);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}