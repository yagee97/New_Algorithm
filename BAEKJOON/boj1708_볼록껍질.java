import java.io.*;
import java.util.*;

public class boj1708_볼록껍질 {
	static Pos root = new Pos(40001, 40001);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Pos> list = new ArrayList<Pos>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pos(x, y));
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).y < root.y) {
				root = list.get(i);
			} else if (list.get(i).y == root.y) {
				if (list.get(i).x < root.x) {
					root = list.get(i);
				}
			}
		}
		list.sort(new Comparator<Pos>() {
			@Override
			public int compare(Pos second, Pos third) {
				int ccwR = ccw(root, second, third);
				if (ccwR > 0)
					return -1;
				else if (ccwR < 0)
					return 1;
				else if (ccwR == 0) {
					long distR1 = dist(root, second);
					long distR2 = dist(root, third);
					if (distR1 > distR2)
						return 1;
				}
				return -1;
			}
		});

		Stack<Pos> stack = new Stack<Pos>();
		stack.add(root);
		for (int i = 1; i < list.size(); i++) {
			while (stack.size() > 1
					&& ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), list.get(i)) <= 0) {
				stack.pop();
			}
			stack.add(list.get(i));
		}
		System.out.println(stack.size());
	}
	
	static long dist(Pos a, Pos b) {
		return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
	}

	static int ccw(Pos a, Pos b, Pos c) {
		long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
		if (ccwR < 0)
			return -1;
		if (ccwR > 0)
			return 1;
		return 0;
	}

	static class Pos {
		long x, y;

		public Pos(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
