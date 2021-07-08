package Strings;

import java.util.Arrays;

public class ReverseInteger {
	public static void main(String[] args) {

		System.out.println(reverse(-123));
	}

	static public int reverse(int x) {

		
		// 주의) result의 값이 int의 범위를 벗어날 수 있기때문에 long 타입으로 선언한 후에
		// 나중에 int로 바꿔야한다.
		
		long result = 0;
		
		while(x != 0) {
			result *= 10;
			result += x % 10;
			x /= 10;
		}
		
		if(Integer.MIN_VALUE <= result && Integer.MAX_VALUE >= result) {
			return (int) result;
		}else {
			return 0;
		}
	}
}
