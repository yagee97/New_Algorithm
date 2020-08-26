import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11724_연결요소의개수 {
	static int N, M;
	static ArrayList<Integer> list[];
	static boolean chk[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		chk = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			// 연결
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		int ans = 0;
		// bfs 모든 정점에서 해보기
		for (int i = 1; i <= N; i++) {
			if (!chk[i]) {
				bfs(i);
				ans++;
			}
		}
		System.out.println(ans);

	}

	private static void bfs(int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		chk[start] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < list[x].size(); i++) {
				int next = list[x].get(i);

				if (next < 1 || next > N)
					continue;
				if (!chk[next]) {
					queue.add(next);
					chk[next] = true;
				}
			}
		}
	}
}
