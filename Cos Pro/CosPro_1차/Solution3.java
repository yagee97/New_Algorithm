package CosPro_1차;

class Solution3 {
	
	int[] dx = {-2,-1,1,2,-2,-1,1,2};
	int[] dy = {-1,-2,-2,-1,1,2,2,1};
	public int solution(String pos) {
		// Write code here.
		int answer = 0;

		int x = pos.charAt(0) - 'A';
		int y = pos.charAt(1) -'0' - 1;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 8 || ny >= 8 || nx < 0 || ny < 0)
				continue;
			else
				answer++;
		}
		return answer;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String pos = "A7";
		int ret = sol.solution(pos);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret + " .");
	}
}