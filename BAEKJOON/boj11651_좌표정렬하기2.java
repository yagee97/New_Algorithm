import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj11651_좌표정렬하기2 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		List<Pos> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pos(x,y));
		}
		Collections.sort(list);
		for(Pos p : list)
			System.out.println(p.x + " " + p.y);
		
	}
	static class Pos implements Comparable<Pos>{
		int x,y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pos p) {
			if(this.y > p.y) return 1;
			else if(p.y == this.y) {
				if(this.x > p.x)
					return 1;
				else
					return -1;
			}
			return -1;
		}
	}
}
