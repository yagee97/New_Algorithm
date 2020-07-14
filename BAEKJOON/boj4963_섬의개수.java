import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4963_섬의개수 {
	static int w, h;
	static int map[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
				}
			}

			// bfs
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	private static void bfs(int x, int y) {
		
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			x = p.x;
			y = p.y;
			
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= h || ny >= w || nx < 0 || ny < 0)
					continue;
				if(visited[nx][ny])
					continue;
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					queue.add(new Pos(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	static class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x= x;
			this.y =y;
		}
	}
}
