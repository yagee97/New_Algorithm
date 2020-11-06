import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2504_괄호의값 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Stack<Character> stack = new Stack<>();

		int ans = 0;
		int tmp = 1;
		boolean flag = false;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if(ch != '(' && ch != ')' && ch != '[' && ch != ']') {
				flag = true;
				break;
			}
				
			if (ch == '(') {
				stack.push(ch);
				tmp *= 2; // 분배법칙 쓰려고
			} else if (ch == '[') {
				stack.push(ch);
				tmp *= 3;
			} else if (ch == ')') {
				if (stack.isEmpty()) { // 짝이되는 괄호가 없을때
					flag = true;
					break;
				}

				if (stack.peek() == '(') {
					if (input.charAt(i - 1) == '(')
						ans += tmp;
					stack.pop();
					tmp /= 2;
				} else { // 괄호가 안맞을때
					flag = true;
					break;
				}
			} else if (ch == ']') {
				if (stack.isEmpty()) {
					flag = true;
					break;
				}
				if (stack.peek() == '[') {
					if (input.charAt(i - 1) == '[')
						ans += tmp;
					stack.pop();
					tmp /= 3;
				} else {
					flag = true;
					break;
				}
			}

		}
		if (flag || !stack.isEmpty())
			System.out.println("0");
		else
			System.out.println(ans);
	}
}
