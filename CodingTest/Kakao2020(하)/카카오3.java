import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카카오3 {
	static class Info {
		String lang;
		String type;
		String old;
		String food;
		int score;

		public Info(String lang, String type, String old, String food, int score) {
			this.lang = lang;
			this.type = type;
			this.old = old;
			this.food = food;
			this.score = score;
		}
	}

	public static void main(String[] args) {

		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		int[] answer = solution(info, query);
		System.out.println(Arrays.toString(answer));
	}

	static public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		Info[] input = new Info[info.length];
		Info[] quer = new Info[query.length];

		StringTokenizer st = null;
		for (int i = 0; i < info.length; i++) {
			st = new StringTokenizer(info[i], " ");

			String lang = st.nextToken();
			String type = st.nextToken();
			String old = st.nextToken();
			String food = st.nextToken();
			int score = Integer.parseInt(st.nextToken());

			Info tmp = new Info(lang, type, old, food, score);
			input[i] = tmp;
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replace(" and ", " ");
			st = new StringTokenizer(query[i], " ");

			String lang = st.nextToken();
			String type = st.nextToken();
			String old = st.nextToken();
			String food = st.nextToken();
			int score = Integer.parseInt(st.nextToken());

			Info tmp = new Info(lang, type, old, food, score);
			quer[i] = tmp;
		}

		// 확인
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < quer.length; i++) {
			Info q = quer[i];
			cnt = 0;
			for (int j = 0; j < input.length; j++) {
				if (!q.lang.equals("-") && !q.type.equals("-") && q.old.equals("-") && !q.food.equals("-")) {
					if (!info[j].contains(q.lang) || !info[j].contains(q.type) || !info[j].contains(q.old)
							|| !info[j].contains(q.food))
						continue;
				}

				Info k = input[j];
				if (q.lang.equals(k.lang) || q.lang.equals("-")) {
					if (q.type.equals(k.type) || q.type.equals("-")) {
						if (q.old.equals(k.old) || q.old.equals("-")) {
							if (q.food.equals(k.food) || q.food.equals("-")) {
								if (q.score <= k.score) {
									cnt++;
								}
							}
						}
					}
				}
			}
			answer[idx++] = cnt;
		}

		return answer;
	}
}
