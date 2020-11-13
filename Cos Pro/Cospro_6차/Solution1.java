package Cospro_6차;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int solution(int n, int[][] garden) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;
		chk = new boolean[n][n];
		
		bfs(n, garden);
		answer = time;
		time = 0;
		return answer;
	}

	static boolean[][] chk;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int time = 0;
	private static void bfs(int n, int[][] garden) {
		
		Queue<Pos> q = new LinkedList<>();
		// 꽃 피어 있는곳 큐에 담기
		for (int i = 0; i < garden.length; i++) {
			for (int j = 0; j < garden.length; j++) {
				if(garden[i][j] == 1) {
					q.add(new Pos(i,j));
					chk[i][j]  = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			if(checkAll(garden)) {
				break;
			}
			time++;
			
			int size = q.size();
			for (int qs = 0; qs < size; qs++) {
				Pos p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if(nx >= n || ny >= n || nx < 0 || ny < 0)
						continue;
					if(!chk[nx][ny] && garden[nx][ny] == 0) {
						garden[nx][ny] = 1;
						q.add(new Pos(nx,ny));
						chk[nx][ny] = true;
					}
				}
				
			}
			
		}
		
	}
	
	private static boolean checkAll(int[][] garden) {
		
		for (int i = 0; i < garden.length; i++) {
			for (int j = 0; j < garden.length; j++) {
				if(garden[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		int n1 = 3;
		int[][] garden1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int ret1 = sol.solution(n1, garden1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		int n2 = 2;
		int[][] garden2 = { { 1, 1 }, { 1, 1 } };
		int ret2 = sol.solution(n2, garden2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

	}
}