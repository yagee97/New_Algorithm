import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686_치킨배달 {
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int map[][];
	static ArrayList<Pos> home;
	static ArrayList<Pos> chicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) { // 집
					home.add(new Pos(i,j));
				}else if(map[i][j] == 2) { // 치킨
					chicken.add(new Pos(i,j));
				}
			}
		}
		sel = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(ans);
		
	}

	static boolean sel[];
	static int ans = Integer.MAX_VALUE;
	private static void dfs(int idx, int cnt) {
		if(cnt == M) { // 치킨집 다 뽑았으면
			// 도시의 치킨거리 최소
			ans = Math.min(ans, calDis(sel));
			return;
		}
		
		for (int i = idx; i < chicken.size(); i++) {
			if(!sel[i]) {
				sel[i] = true;
				dfs(i, cnt+1);
				sel[i] = false;
			}
		}
	}
	
	private static int calDis(boolean[] sel) {
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int hx = home.get(i).x;
			int hy = home.get(i).y;
			int minDis = Integer.MAX_VALUE;
			for (int j = 0; j < sel.length; j++) {
				if(sel[j]) {
					int cx = chicken.get(j).x;
					int cy = chicken.get(j).y;
					int diff = Math.abs(hx - cx) + Math.abs(hy - cy);
					minDis = Math.min(minDis, diff);
				}
			}
			sum += minDis; // 한집마다의 치킨거리를 다 더해서 도시의 치킨거리 구하자
		}
		return sum;
	}
}
