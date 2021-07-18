package Strings;

public class strStr {
	public static void main(String[] args) {

		System.out.println(strStr("", ""));
	}
	
    static public int strStr(String haystack, String needle) {
        
    	if(needle == null || needle.length() == 0)
    		return 0;
    	
    	int idx = haystack.indexOf(needle);
    	
    	
    	return idx;
    }
}
