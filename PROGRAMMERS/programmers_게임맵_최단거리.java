import java.util.LinkedList;
import java.util.Queue;

public class programmers_게임맵최단거리 {
	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		System.out.println(solution(maps));
	}

	static class Pos {
		int x;
		int y;
		int d;

		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static boolean[][] chk;

	static public int solution(int[][] maps) {
		int answer = 0;
		chk = new boolean[maps.length][maps[0].length];
		// bfs로 사방탐색
		
		answer = bfs(0, 0, maps);

		return answer;
	}


	static public int bfs(int x, int y, int[][] maps) {
		int[] dx = { -1,0,1,0}, dy = {0,-1,0,1 };

		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(x, y, 1));
		chk[x][y] = true;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			if (p.x == maps.length - 1 && p.y == maps[0].length - 1) {
				return p.d;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
	
				if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
					if (!chk[nx][ny] && maps[nx][ny] == 1) {
						chk[nx][ny] = true;
						queue.add(new Pos(nx, ny, p.d+1));
					}
				}
			}
		}
		return -1;

	}
}
