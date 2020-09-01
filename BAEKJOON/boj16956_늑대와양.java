import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16956_늑대와양 {
	static int R,C;
	static char[][] map;
	// .을 모두 D로 바꾸고 S가 있는 위치의 상하좌우에 늑대 W가 있는지 확인
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				if(ch == '.') {
					map[i][j] = 'D'; // .이 있는 곳에 울타리 세움
				}
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		
		// S의 상하좌우에 늑대가 있는지 확인
		out:for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= R || ny >= C)
							continue;
						if(map[nx][ny] == 'W') {
							flag = false;
							break out;
						}
					}
				}
			}
		}
		if(!flag)
			sb.append("0");
		else {
			sb.append("1").append("\n");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
		
	}
}
