package Strings;

import java.util.Arrays;

public class StringToInteger {
	public static void main(String[] args) {

		System.out.println(myAtoi("4193 with words"));
	}

	static public int myAtoi(String s) {

		double res = 0;
		char flag = '+';

		// null or empty
		if (s == null || s.length() < 1)
			return 0;

		s = s.trim(); // 앞뒤에 있는 공백만 제거
		
	    if(s.length() < 1)
	        return 0;

		// check negative or positive
		int i = 0;
		if (s.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (s.charAt(0) == '+') {
			i++;
		}
		
		// calculate value
		// index가 문자열 길이 이내고, 지금 탐색하는 문자가 숫자면
		while(s.length() > i && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			res = res * 10 + (s.charAt(i)-'0'); // 계속 10씩 곱하고 지금 탐색한 애 더하면 값됨
			i++;
		}
		
		if(flag == '-')
			res = -res;
		
		if(res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(res < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) res;

	}

}
