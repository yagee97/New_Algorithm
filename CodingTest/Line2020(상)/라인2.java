
public class 라인2 {
	public static void main(String[] args) {
		
		// 객관식 5지선다
		// 두 응시자의 부정행위 가능성 지수 계산하자
		// 의심문항 = 같은 선택지를 골랐으나 오답인 문항
		// 부정행위 가능성 지수 = 총 의심 문항의 수 + (가장 긴 연속된 의심문항의 수)^2
		
		// 가장 높은 부정행위 가능성 지수를 찾자.
		//String answer_sheet= "4132315142";
		//String sheets[] = new String[] {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};
//		String answer_sheet = "53241";
//		String sheets[] = new String[] {"53241", "42133", "53241", "14354"};
		String answer_sheet = "24551";
		String sheets[] = new String[] {"24553", "24553", "24553", "24553"};
		
		int N = sheets.length; // 총 몇명
		int testN = answer_sheet.length(); // 몇문제
		int ans = 0;
		
		// 모든 참가자 쌍을 대조해서, 부정행위 가능성 지수 판별!
		for (int i = 0; i < N; i++) {
			String student1 = sheets[i];
			int cnt = 0;
			int maxCnt = 0;
			for (int j = 0; j < N; j++) {
				cnt = 0; // 의심문항 개수
				int longCnt = 0; // 가장 긴 의심문항
				maxCnt = 0;
				if(i == j) // 같은 참가자
					continue;
				String student2 = sheets[j];
				// 각 문제마다 틀렸는데 같은 지
				for (int k = 0; k < testN; k++) {
					char answer = answer_sheet.charAt(k);
					if(student1.charAt(k) != answer) {
						if(student1.charAt(k) == student2.charAt(k)) {
							// 의심문항 추가
							cnt++;
							longCnt++;
							if(maxCnt < longCnt)
								maxCnt = longCnt;
						}
						else
							longCnt = 0;
					}else {
						longCnt = 0;
					}
				}
				// 부정행위 가능성 지수 = 총 의심 문항의 수 + (가장 긴 연속된 의심문항의 수)^2
				int p =  (int)(cnt + Math.pow(maxCnt, 2));
				if(ans < p)
					ans = p;
			}
		}
		System.out.println(ans);
	}
}
