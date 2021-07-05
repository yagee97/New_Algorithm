package Strings;

import java.util.Arrays;

public class ValidAnagram {
	public static void main(String[] args) {
	
		System.out.println(isAnagram("anagram", "nagaram"));
	}

	static public boolean isAnagram(String s, String t) {

		
		if(s.length() != t.length())
			return false;
		
		char[] chArr1 = s.toCharArray();
		char[] chArr2 = t.toCharArray();
		
		Arrays.sort(chArr1);
		Arrays.sort(chArr2);
		
		for (int i = 0; i < chArr1.length; i++) {
			if(chArr1[i] != chArr2[i])
				return false;
		}
		
		// Arrays.equals(chArr1, chArr2);
		return true;
	}

}
