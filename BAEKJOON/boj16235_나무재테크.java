import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj16235_나무재테크 {
	static class Info implements Comparable<Info> {
		int x;
		int y;
		int age;

		public Info(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Info o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", age=" + age + "]";
		}
	}

	static int N, M, K;
	static int map[][], a[][];
	static ArrayList<Info> tree;// 각 칸마다의 나무

	public static void main(String[] args) throws IOException {
		// n x n
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		a = new int[N][N];
		// 제일 처음 양분은 모든 칸에 5만큼 들어있다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}

		// 각 칸에 A[r][c]만큼 양분 추가 (겨울에)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tree = new ArrayList<>();
		// M개의 나무를 구매해 땅에 심었다. 1x1 크기 칸에 여러개의 나무가 심어져 있을 수 있다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Info(x, y, age));
		}

		for (int t = 0; t < K; t++) {
			spring();
			summer();
			dead = new ArrayList<>();
			autumn();
			winter();
		}

		System.out.println(tree.size());
	}

	static ArrayList<Info> dead = new ArrayList<>();

	private static void spring() {
		// 봄=> 나무가 자신의 나이만큼 양분 냠냠 : 나이 +1/ 각각의 나무는 자기 칸에 있는 양분을 먹을 수 있다
		// 하나의 칸에 여러 나무가 있으면 나이가 어린 나무부터 양분 냠. 만약 자신의 나이만큼 양분 못먹는 나무는 죽음
		// 이 때 죽은 나무를 여름에 양분으로 써야하니까 저장해놔야함

		Collections.sort(tree);

		ArrayList<Info> tmp = new ArrayList<>();
		for (int k = 0; k < tree.size(); k++) {
			int x = tree.get(k).x;
			int y = tree.get(k).y;
			int age = tree.get(k).age;
			if (map[x][y] >= age) { // 나이만큼 양분 먹음
				map[x][y] -= age;
				// 나이 한살 추가
				tmp.add(new Info(x, y, age + 1));
			} else {
				// 나무 죽음
				dead.add(new Info(x, y, age));
			}
		}

		tree = new ArrayList<>();
		for (Info info : tmp) {
			tree.add(info);
		}
	}

	private static void summer() {
		// 여름 => 봄에 죽은 나무가 양분이 된다.
		// 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
		for (int i = 0; i < dead.size(); i++) {
			int x = dead.get(i).x;
			int y = dead.get(i).y;
			int age = dead.get(i).age;

			map[x][y] += age / 2;
		}
	}

	static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	private static void autumn() {
		// 가을 => 나무 번식. 번식하는 나무는 나이가 5배수. 인접한 8칸의 나이가 1인 나무가 생김
		// 땅 벗어나면 나무 안생김
		for (int i = 0; i < tree.size(); i++) {
			int x = tree.get(i).x;
			int y = tree.get(i).y;
			int age = tree.get(i).age;
			if (age % 5 == 0) {
				// 번식시작
				for (int j = 0; j < 8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (nx >= N || nx < 0 || ny >= N || ny < 0)
						continue;
					tree.add(new Info(nx, ny, 1)); // 8방향에 나이 1인 나무 추가
				}
			}
		}

	}

	private static void winter() {
		// 겨울 => A만큼 양분 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += a[i][j];
			}
		}
	}

}
