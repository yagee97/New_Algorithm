import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178_미로탐색 {

	static class Info {
		int x, y;
		int dist;

		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int N, M;
	static int map[][];
	static boolean chk[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		chk = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int num = str.charAt(j) - '0';
				map[i][j] = num;

			}
		}
		// bfs 최소 칸 수 구하기
		bfs(0,0);
		System.out.println(ret);
	}

	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int ret = 0;
	private static void bfs(int x, int y) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(x,y,1));
		chk[x][y] = true;
		
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			x = info.x;
			y = info.y;
			int dist = info.dist;
			
			if(x == N-1 && y == M-1) {
				ret = dist;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;
				if(!chk[nx][ny] && map[nx][ny] == 1) {
					queue.add(new Info(nx,ny, dist+1));
					chk[nx][ny] = true;
				}
			}
			
		}
	}
}
