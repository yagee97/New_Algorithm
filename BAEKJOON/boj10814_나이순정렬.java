import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj10814_나이순정렬 {
	static class Info implements Comparable<Info> {
		int no;
		int age;
		String name;

		public Info(int no, int age, String name) {
			this.no = no;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Info info) {
			if (this.age < info.age)
				return -1;
			else if (this.age > info.age)
				return 1;
			else if (this.age == info.age) {
				if (this.no > info.no)
					return 1;
				else if (this.no < info.no)
					return -1;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Info> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Info(i, age, name));
		}
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		System.out.println(sb.toString());
	}

}
