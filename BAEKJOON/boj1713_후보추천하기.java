import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1713_후보추천하기 {
	static class Info implements Comparable<Info>{
		int no;
		int cnt;
		int time;

		public Info(int no, int cnt, int time) {
			this.no = no;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			if(o.no > this.no)
				return -1;
			else if(o.no < this.no)
				return 1;
			return 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());

		int[] recommend = new int[count];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < count; i++) {
			recommend[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Info> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			int num = recommend[i];
			boolean flag = false;
			if (list.size() != N) {
				// 이미 틀에 걸려있나 확인
				int idx = 0;
				for (int j = 0; j < list.size(); j++) {
					if (num == list.get(j).no) {
						flag = true;
						idx = j;
						break;
					}
				}
				if (flag) {
					int t = list.get(idx).cnt;
					int t2 = list.get(idx).time;
					list.remove(idx);
					list.add(new Info(num, t + 1, t2));
				} else {
					list.add(new Info(num, 1, i));
				}
			} else if (list.size() == N) {
				// 다 걸려있으면
				// 이미 틀에 걸려있나 확인
				boolean flag2 = false;
				int idx2 = 0;
				for (int j = 0; j < list.size(); j++) {
					if (num == list.get(j).no) {
						flag2 = true;
						idx2 = j;
						break;
					}
				}
				if (flag2) {
					int t = list.get(idx2).cnt;
					int t2 = list.get(idx2).time;
					list.remove(idx2);
					list.add(new Info(num, t + 1, t2));
				} else {
					// 제일 적게 추천된 애 찾기
					int minV = Integer.MAX_VALUE;
					for (int j = 0; j < list.size(); j++) {
						if (minV > list.get(j).cnt)
							minV = list.get(j).cnt;
					}
					// 소팅하자
					Collections.sort(list, new Comparator<Info>() {
						@Override
						public int compare(Info o1, Info o2) {
							// TODO Auto-generated method stub
							if (o1.time > o2.time)
								return 1;
							else if (o1.time < o2.time)
								return -1;
							return 0;
						}
					});
					
					for (int j = 0; j < list.size(); j++) {
						if(minV == list.get(j).cnt) {
							list.remove(j);
							list.add(new Info(num, 1, i));
							break;
						}
					}
				}
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).no + " ");
		}
	}
}
