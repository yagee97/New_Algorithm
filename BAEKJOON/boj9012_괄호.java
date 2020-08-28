import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호
public class boj_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String input = br.readLine();
			boolean flag = true;
			Stack<Character> stack = new Stack<>();
			// input 길이만큼 돌면서 열린괄호는 stack에 넣자
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if(c == '(')
					stack.push(c);
				// 닫힘괄호가 나오면 stack에서 제일 위에꺼 꺼내자.
				else if(c == ')') {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			// 다 돌았을때 stack에 뭐가 남아있거나, 닫힘괄호인데 더이상 꺼낼게 없으면 No
			if(stack.size()!=0) {
				flag = false;
			}
			if (flag) {
				System.out.println("YES");
			}else
				System.out.println("NO");
		}
	}
}
