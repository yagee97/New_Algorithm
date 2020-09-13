import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 라인2 {
	static class Info {
		int num;
		int time;

		public Info(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}

	public static void main(String[] args) {

		int[] ball = { 11, 2, 9, 13, 24 };
		int[] order = { 9, 2, 13, 24, 11 };

		int answer[] = solution(ball, order);
		System.out.println(Arrays.toString(answer));
	}

	static public int[] solution(int[] ball, int[] order) {
		int[] answer = new int[order.length];
		int idx = 0;
		ArrayList<Integer> list = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();

		// deque에 ball 담기
		for (int i = 0; i < ball.length; i++) {
			deque.offer(ball[i]);
		}

		// order 순으로 양쪽 peek 확인해서 맞으면 빼고, 아니면 새로운 보류 list에 추가
		for (int i = 0; i < order.length; i++) {
			int o = order[i];
			if (deque.peekFirst() == o) {
				answer[idx++] = deque.pollFirst();
			} else if (deque.peekLast() == o) {
				answer[idx++] = deque.pollLast();
			} else
				list.add(o);

			// 보류 list에 있는 애가 맨 끝 peek 에 있는지 먼저 확인해서 있으면 빼기
			while (true) {
				boolean flag = false;
				if (list.size() != 0) {
					if (!deque.isEmpty()) {
						int first = deque.peekFirst();
						int last = deque.peekLast();
						if (list.contains(first)) {
							int index = list.indexOf(first);
							list.remove(index);
							answer[idx++] = deque.pollFirst();
							flag = true;
						} else if (list.contains(last)) {
							int index = list.indexOf(last);
							list.remove(index);
							answer[idx++] = deque.pollLast();
							flag = true;
						}
					}
				}
				if(!flag)
					break;
			}
		}

		return answer;
	}
}
