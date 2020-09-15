import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10971_외판원순회2 {
	static int N, minV = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1 ~ N 까지 도시. 도시 사이에는 길
		// 어느 한 도시에서 출발해 N 개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로
		// 한번 갔던 도시로는 다시 갈 수 없다.
		// 가장 적은 비용을 들이는 여행 계획
		// W[j][i]는 W[i][j]와 다를 수 있다.
		// 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구하는 프로그램을 작성하자
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		chk = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dfs(i,i,0,0);
		}
		System.out.println(minV);
		
	}
	
	private static void dfs(int start,int i, int cnt, int sum) {
		
		if(cnt == N && start == i) {
			// 다 돌았으면! 최소값 갱신
			minV = Math.min(minV, sum);
			return;
		}
		
		for (int idx = 0; idx < N; idx++) {
			if(map[i][idx] == 0) // 가는 길이 없으면
				continue;
			if(!chk[i] && map[i][idx]>0) {
				chk[i] = true;
				sum += map[i][idx];
				dfs(start, idx, cnt+1, sum);
				chk[i] = false;
				sum -= map[i][idx];
			}
		}
	}
}
