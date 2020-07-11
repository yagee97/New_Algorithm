import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj10825_국영수 {
	static class Info implements Comparable<Info>{
		String name;
		int korean;
		int english;
		int math;
		
		public Info(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Info info) {
			if(this.korean < info.korean) 
				return 1;
			else if(this.korean > info.korean)
				return -1;
			else if(this.korean == info.korean) {
				if(this.english < info.english)
					return -1;
				else if(this.english > info.english)
					return 1;
				else if(this.english == info.english){
					if(this.math < info.math)
						return 1;
					else if(this.math > info.math)
						return -1;
					else if(this.math == info.math){
						
						// 이름이 사전순으로 증가하는 순서로
						if(this.name.compareTo(info.name) < 0)
							return -1;
						else if(this.name.compareTo(info.name) > 0)
							return 1;
					}
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		ArrayList<Info> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			String name= st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			list.add(new Info(name, kor, eng, math));
		}
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).name).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
