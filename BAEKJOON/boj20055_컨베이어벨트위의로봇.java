import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2*N];
		robot = new boolean[2*N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 2*N; i++) {
			// 내구도 담겨있음
			int tmp = Integer.parseInt(st.nextToken());
			belt[i] = tmp;
		}
		
		int step = 0;
		while(true) {
			step++;
			
			rotate();
			moveRobot();
			// 첫칸에 로봇 추가
			if(!robot[0] && belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			// 내리기
			if(robot[N-1]) 
				robot[N-1] = false;
			
			if(isK())
				break;
			
		}
		System.out.println(step);
		
	}
	
	// 1. 벨트가 한칸 회전한다.
	public static void rotate() {
		
		int lastIdx = 2*N -1;
		int lastBelt = belt[lastIdx];
		for(int i = lastIdx; i> 0;i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = lastBelt;
		
		// 로봇도 한칸 이동
		boolean lastRobot = robot[lastIdx];
		for (int i = lastIdx; i > 0; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = lastRobot;
		
		// 내려가는 칸에 있는 로봇은 ㅂㅇ
		if(robot[N-1])
			robot[N-1] = false;
	}
	
	// 2. 로봇 움직이기 
	public static void moveRobot() {
		
		// 가장 먼저 벨트에 올라간 로봇부터 한칸 이동
		// N-2부터가 가장 먼저 올라간 로봇임
		
		for (int i = N-2; i >=0 ; i--) {
			int next = i+1;
			// 내구도가 0이 아니고, 로봇이 없는 칸이면
			if(!robot[i])
				continue;
			
			if(belt[next] > 0 && !robot[next]) {
				robot[next] = true;
				robot[i] = false;
				belt[next]--;
			}
		}
	}
	
	public static boolean isK() {
		int cnt = 0;
		for (int i = 0; i < 2*N; i++) {
			if(belt[i] == 0)
				cnt++;
		}
		if(K <= cnt)
			return true;
		
		return false;
	}
}
