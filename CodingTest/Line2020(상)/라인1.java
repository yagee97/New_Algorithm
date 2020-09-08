import java.util.ArrayList;

public class 라인1 {
	public static void main(String[] args) {
		String inputString = "line [plus]";
		
		// 괄호가 정상사용되었는지 검증한 결과 반환
		// 정상이면 총 괄호 쌍의 수, 비정상이면 -1 출력
		int cnt = 0;
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			
			// 열린거면 list에 넣고, 닫힘괄호면 list에서 개랑 짝되는애 있는지 보자
			// 있으면 +1, 없으면 break;
			if(ch == '(' || ch == '{' || ch == '[' || ch == '<') {
				list.add(ch);
			}
			else if(ch == ')' ){
				if(list.contains('(')) {
					int idx = list.indexOf('(');
					list.remove(idx);
					cnt++;
				}
			}
			else if(ch == '}' ){
				if(list.contains('{')) {
					int idx = list.indexOf('{');
					list.remove(idx);
					cnt++;
				}
			}
			else if(ch == ']' ){
				if(list.contains('[')) {
					int idx = list.indexOf('[');
					list.remove(idx);
					cnt++;
				}
			}
			else if(ch == '>' ){
				if(list.contains('<')) {
					int idx = list.indexOf('<');
					list.remove(idx);
					cnt++;
				}
			}
		}
		if(list.size() == 0)
			System.out.println(cnt);
		else
			System.out.println("-1");
	}
}
