import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1662_압축 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// 문자열 하나하나 다시 만들게끔 풀었더니 메모리초과나서 재귀로 풉니다..
		Stack<Integer> stack = new Stack<>();
		char[] str = input.toCharArray();
		int[] arr = new int[50];

		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(')
				stack.push(i); // 열림 괄호 위치
			else if (str[i] == ')')
				arr[stack.pop()] = i; // 쌍이되는 괄호의 인덱스에 닫힘 괄호 인덱스 추가
		}
		
		System.out.println(solve(0, str.length, str, arr));
	}
	
	// 열림 괄호 만나면 그 전 숫자랑 문자열길이 곱하고, 괄호길이 -1
	private static int solve(int start, int end, char[] str, int[] arr) {
		int len = 0;
		
		for (int i = start; i < end; i++) {
			if(str[i] == '(') {
				int pre = str[i-1]-'0';
				len += pre * solve(i+1, arr[i], str, arr)-1;
				i = arr[i];
			}else {
				len++;
			}
		}
		return len;
	}
}
