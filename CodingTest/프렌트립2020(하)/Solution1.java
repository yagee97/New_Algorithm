package 프렌트립;

public class Solution1 {
	public static void main(String[] args) {
		int[][] location = { { 0, 3 }, { 1, 1 }, { 1, 5 }, { 2, 2 }, { 3, 3 }, { 4, 0 } };
		int[] s = { 3, 4 };
		int[] e = { 0, 0 };

		System.out.println(solution(location, s, e));
	}

	static public int solution(int[][] location, int[] s, int[] e) {
		int answer = 0;

		int sx = s[0];
		int sy = s[1];
		int ex = e[0];
		int ey = e[1];
		
		for (int i = 0; i < location.length; i++) {
			int x = location[i][0];
			int y = location[i][1];
			
			// 1번
			if(sx < ex && sy > ey) {
				if( (sx <= x && x <=ex) && (ey <= y && sy >= y) ) {
					System.out.println(x + " " + y);
					answer++;
				}
			}
			// 2번 
			else if(sx > ex && sy > ey) {
				if((sx >= x && x >= ex) && (ey <= y && sy >= y))
					answer++;
			}
			// 3번
			else if(ex < sx && ey > sy) {
				if((sx >= x && x >= ex) && (ey >= y && sy <= y)) {
					answer++;
				}
			}
			// 4번
			else if( ex > sx && ey > sy) {
				if((sx <= x && x <=ex) && (ey >= y && sy <= y)) {
					answer++;
				}
			}

        }
		return answer;
	}
}
