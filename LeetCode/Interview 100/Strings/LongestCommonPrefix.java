package Strings;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		
		System.out.println(longestCommonPrefix(strs));
		
	}

	static public String longestCommonPrefix(String[] strs) {

		if(strs.length == 0)
			return "";
		
		for (int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(i == strs[j].length() || strs[j].charAt(i) != ch) {
					return strs[0].substring(0,i);
				}
			}
		}
		
		
		return strs[0];
	}
}
