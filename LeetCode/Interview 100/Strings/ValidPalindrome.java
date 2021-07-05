package Strings;

public class ValidPalindrome {
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("0P"));
	}
	
    static public boolean isPalindrome(String s) {
    	
    	String str = "";
    	
    	// 공백 떼고 쉼표 떼고, 특수문자 다 떼고, 대문자는 소문자로
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		
    		if(ch == ' ') {
    			continue;
    		}
    		
    		else if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
    			str += Character.toLowerCase(ch);
    		}
		}
    	System.out.println(str);
    	
    	// 회문 검사: 투 포인터
    	int left = 0; int right = str.length()-1;
    	
    	while(left < right) {
    		if(str.charAt(left++) != str.charAt(right--))
    			return false;
    		
    	}
    	
        return true;
    }
}
