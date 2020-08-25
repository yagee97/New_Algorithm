import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj3568_iSharp {
	public static void main(String[] args) throws IOException {
		// 배열,참조,포인터 순서 상관x
		// int&&[]* => 가능
		// 여러개의 변수를 한 줄에 정의할 수 있다. 
		// 공통된 변수형을 제일 먼저 쓰고, 그 다음에 각 변수의 이름과 추가적인 변수형을 쓰면 된다.
		// int& a*[]&, b, c*;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String common = st.nextToken(); // 공통 변수형
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int tokenSize = st.countTokens();
		
		while(tokenSize-- > 0) {
			// 변수의 오른편에 있는 변수형을 모두 왼쪽으로 옮기고, 한줄에 하나씩 선언하는 프로그램만들기
			String valName = "";
			String str = st.nextToken();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(Character.isAlphabetic(ch)) {
					valName += ch;
				}
				if(!Character.isAlphabetic(ch) && ch != ',' && ch != ';') {
					stack.add(ch);
				}
			}
			String type = "";
			while(!stack.isEmpty()) {
				char c = stack.pop();
				if(c == '[')
					c = ']';
				else if(c == ']')
					c = '[';
				type += c;
			}
			sb.append(common).append(type).append(" ").append(valName).append(";");
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
