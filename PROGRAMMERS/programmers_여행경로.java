import java.util.ArrayList;
import java.util.Collections;

public class programmers_여행경로 {
	
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		
		System.out.println(solution(tickets));
	}
	static boolean[] visited; // 방문 여부
	static ArrayList<String> result;
	
    static public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        // dfs 돌면서 모든 티켓을 다 쓰는 경로를 백트래킹
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(result);

        // result.get(0)에 문자열로 저장되어있는 경로를, string[] 형식으로 쪼갬
        return result.get(0).split(" ");
    }
    
    static void dfs(String now, String nodes, int cnt, String[][] tickets) {
    	// 모든 공항 방문했을 때
    	if(cnt == tickets.length) {
    		// 경로 저장
    		result.add(nodes);
    		return;
    	}
    	
    	// 티켓 배열 순회
    	for (int i = 0; i < tickets.length; i++) {
    		// 방문 x 한 공항이고, 티켓의 출발지가 현재 있는곳과 같은 경우
			if(!visited[i] && tickets[i][0].equals(now)) {
				// 티켓 쓰고, 도착지로 이동
				visited[i] = true;
				// 이동했다치면, 다음 dfs는 위의 도착지가 현재위치가 되고, 지금까지의 경로에 위의 도착지 경로를 추가해줘야한다. 
				dfs(tickets[i][1], nodes+" " + tickets[i][1], cnt+1, tickets);
				visited[i] = false;
			}
		}
    }
}
