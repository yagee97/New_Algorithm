import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Queue<Document> queue = new LinkedList<>();
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				queue.add(new Document(j, priority)); 
			} 

			int result = 1;

			while (!queue.isEmpty()) {
				Document cur = queue.poll();
				boolean flag = true; 

				Iterator<Document> it = queue.iterator();
				while (it.hasNext()) {
					Document value = (Document) it.next();
					if (cur.priority < value.priority) { 
						flag = false;
						break; 

					}
				}

				if (!flag) { 
					queue.add(cur); 
				}

				else {
					if (cur.number == number) { 
						System.out.println(result);
					} else {
						result++;
					}

				}

			}

		}

	}
}

class Document {
	int number; // 문서의 문서번호
	int priority; // 우선순위

	public Document(int number, int priority) {
		this.number = number;
		this.priority = priority;
	}
}