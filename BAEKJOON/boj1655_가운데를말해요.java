import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2- o1;
			}
		});
		
		Queue<Integer> minQueue = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			if(minQueue.size() == maxQueue.size()) {
				minQueue.add(Integer.parseInt(br.readLine()));
			}
			else {
				maxQueue.add(Integer.parseInt(br.readLine()));
			}
			if(i == 0) { // 첫번째꺼는 바로 출력
				System.out.println(minQueue.peek());
				continue;
			}
			
			// 큐를 통해 각각 정렬한뒤 peek()을 이용해 가장 앞의 값들을 비교해서 필요하다면 swap해 정렬을 유지한다.
			if(!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if(minQueue.peek() < maxQueue.peek()) {
					int tmp = minQueue.poll();
					minQueue.add(maxQueue.poll());
					maxQueue.add(tmp);
				}
			}
			
			if(minQueue.size() == maxQueue.size()) {
				System.out.println(Math.min(minQueue.peek(), maxQueue.peek()));
			}else if(minQueue.size() < maxQueue.size()) {
				System.out.println(maxQueue.peek());
			}else {
				System.out.println(minQueue.peek());
			}
			
		}
		
		
	}
}
