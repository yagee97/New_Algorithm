import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class winter3 {
	static int map[][];
	static boolean chk[][];
	static int ret[];
	static int cnt = 0;
	static int N;

	public static void main(String[] args) {

	}

	static public int[] solution(int[][] v) {
		int[] answer = {};
		N = v.length;

		int idx = 0;
		for (int k = 0; k <= 2; k++) {

			for (int i = 0; i < v.length; i++) {
				for (int j = 0; j < v[i].length; j++) {
					if (!chk[i][j] && map[i][j] == k) {
						dfs(i, j);
						ret[k]++;
					}
				}
			}
		}

		System.out.println(Arrays.toString(ret));
		return answer;
	}

	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	private static void dfs(int x, int y) {

		chk[x][y] = true;
		ret[cnt]++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= N || ny >= N || nx < 0 || ny < 0)
				continue;
			if (!chk[nx][ny] && map[nx][ny] == map[x][y]) {
				chk[nx][ny] = true;
				dfs(nx, ny);
			}
		}

	}

}
