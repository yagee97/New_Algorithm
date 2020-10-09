package coopang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution2 {
	static class Info {
		int no; // 몇번째 키오스크
		int idle_time; // 운영되지 않은 시간
		Date fin_time; // 고객 업무 끝나는 시간
		int cnt; // 고객 몇명째

		public Info(int no, int idle_time, Date fin_time, int cnt) {
			this.no = no;
			this.idle_time = idle_time;
			this.fin_time = fin_time;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Info [no=" + no + ", idle_time=" + idle_time + ", fin_time=" + fin_time + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws ParseException {
		int n = 3;
		String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };

		System.out.println(solution(n, customers));
	}

	static public int solution(int n, String[] customers) throws ParseException {
		int answer = 0;
		boolean[] kio = new boolean[n]; // 운영 true 운영x false
		Info info[] = new Info[n];
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date zero = new SimpleDateFormat("HH:mm:ss", Locale.KOREA).parse("00:00:00");
		for (int i = 0; i < info.length; i++) {
			info[i] = new Info(i, 0, zero, 0);
		}
		int current = 0;
		
		for (int t = 0; t < customers.length; t++) {
			// 고객정보 파싱
			String customer = customers[t];
			StringTokenizer st = new StringTokenizer(customer, " ");
			String date = "";
			String arrivalTime = "";
			int time = 0;

			date = st.nextToken();
			arrivalTime = st.nextToken();
			time = Integer.parseInt(st.nextToken());

			ArrayList<Integer> indexList = new ArrayList<>();

			Date date1 = format.parse(arrivalTime);

			// 반납
			for (int i = 0; i < info.length; i++) {
				if (date1.compareTo(info[i].fin_time) >= 0) {
					info[i] = new Info(i, 0, zero, info[i].cnt);
					kio[i] = false;
				}
			}
			for (int i = 0; i < kio.length; i++) {
				// 현재 운영되지 않는 키오스크가 하나라도 있는지 확인
				if (kio[i] == false) {
					indexList.add(i);
				}
			}

			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			cal.add(Calendar.MINUTE, time);
			int idx = 0;
			// 비어 있는 키오스크가 있으면
			if (indexList.size() >= 1) {
				
				if (indexList.size() == 1) {
					idx = indexList.get(0);
				}
				// 비교 해야함 운영 x 인 시간
				else {
					int max = -1;
					for (int j = 0; j < indexList.size(); j++) {
						if (max < info[indexList.get(j)].idle_time) {
							max = info[indexList.get(j)].idle_time;
							idx = indexList.get(j);
						} else if (max == info[indexList.get(j)].idle_time) {
							continue;
						}
					}
				}

				info[idx] = new Info(idx, 0, cal.getTime(), info[idx].cnt + 1);
				kio[idx] = true;
			}

			// 비어있는 키오스크가 없으면
			else if (indexList.size() == 0) {
				// 제일 빨리 끝날 키오스크에게 할당
				Date min = info[0].fin_time;
				int minIdx = 0;
				for (int i = 0; i < n; i++) {
					if (min.compareTo(info[i].fin_time) > 0) {
						min = info[i].fin_time;
						minIdx = i;
					} else if (min.compareTo(info[i].fin_time) == 0) {
						continue;
					}
				}
				info[minIdx] = new Info(minIdx, 0, cal.getTime(), info[minIdx].cnt + 1);
				kio[minIdx] = true;
			}
			
			// 운영x인 시간 계산 
			current++;
			for (int i = 0; i < info.length; i++) {
				if(kio[i] == false) {
					info[i] = new Info(i, current, info[i].fin_time, info[i].cnt);
				}
			}
			System.out.println(current);
			for (int i = 0; i < info.length; i++) {
				if(answer < info[i].cnt)
					answer = info[i].cnt;
//				System.out.println(info[i].toString());
			}
		}

		return answer;
	}
}