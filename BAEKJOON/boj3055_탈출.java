import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3055_탈출 {
	static int R,C;
	static char map[][];
	static int dX = 0, dY = 0;
	static int sX = 0, sY = 0;
	static Queue<Pos> water;
	static Queue<Info> queue;
	static boolean chk[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// R행 C열
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map= new char[R][C];
		chk = new boolean[R][C];
		water = new LinkedList<>();
		queue = new LinkedList<>();
		
		// 고슴도치 위치랑 비버 굴 위치 저장
		// 물 queue에 넣기
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				// 비버 굴 위치
				if(map[i][j] == 'D') {
					dX = i;
					dY = j;
				}else if(map[i][j] == 'S') {
					sX = i;
					sY =j;
				}else if(map[i][j] == '*') {
					water.add(new Pos(i,j));
				}
			}
 		}
		
		// bfs 하는데, 고슴도치 위치부터 고슴도치 큐에 저장. 
		bfs(sX, sY);
		if(!flag)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);
		
	}
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static boolean flag = false;
	static int ans = 0;
	private static void bfs(int x, int y) {
		queue.add(new Info(x,y,0));
		chk[x][y] = true;
		
		while(!queue.isEmpty()) {
			if(flag)
				break;
			int ws = water.size();
			for (int w = 0; w < ws; w++) {
				Pos p = water.poll();
				x = p.x;
				y = p.y;
				for (int i = 0; i < 4; i++) {
					int nx = x+ dx[i];
					int ny = y + dy[i];
					if(nx >= R || ny >= C || nx < 0 || ny < 0)
						continue;
					// 돌이면 패스
					if(map[nx][ny] == 'X')
						continue;
					// 비버 굴 패스
					if(map[nx][ny] == 'D') 
						continue;
					if(map[nx][ny] == '*')
						continue;
					if(map[nx][ny] == '.') {
						water.add(new Pos(nx,ny));
						// 물로 변신시키기
						map[nx][ny] = '*';
					}
				}
			}
			
			int gs = queue.size();
			for (int g = 0; g < gs; g++) {
				Info info = queue.poll();
				x = info.x;
				y = info.y;
				int time = info.time;
				if(x == dX && y == dY) {
					flag = true;
					ans = time;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y+dy[i];
					if(nx >= R || ny >= C || nx < 0 || ny < 0)
						continue;
					if(map[nx][ny] == 'X' || map[nx][ny] == '*')
						continue;
					if(!chk[nx][ny] && map[nx][ny] == '.' || map[nx][ny] == 'D') {
						queue.add(new Info(nx,ny,time+1));
						chk[nx][ny] = true;
					}
				}
			}
		}
	}
	
	static class Pos{
		int x, y;
		public Pos(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Info{
		int x,y,time;
		public Info(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
