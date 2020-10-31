import java.util.Arrays;

public class winter2 {
	public static void main(String[] args) {

		String str = "qyyigoptvfb";
		String key = "abcdefghijk";
		int r = 3;
		System.out.println(solution(str, key, r));
	}

	static public String solution(String encrypted_text, String key, int rotation) {
		String answer = "";
		String str = encrypted_text;
		StringBuilder sb = new StringBuilder();
		if (rotation >= 0) {
			for (int i = 0; i < rotation; i++) {
				str = str.substring(1);
				str += encrypted_text.charAt(0);
				encrypted_text = str;
			}
		} else {
			for (int i = 0; i < -rotation; i++) {
				str = str.substring(0, str.length() - 1);
				str = encrypted_text.charAt(encrypted_text.length() - 1) + str;
				encrypted_text = str;
			}

		}

		System.out.println(encrypted_text);

		for (int i = 0; i < key.length(); i++) {

			char ch = (char)(encrypted_text.charAt(i) -'a');
			char kch = key.charAt(i);

			int n = kch - 'a' + 1;
			if((char) ch - n < 97)
				answer += (char) ((ch - (n % 96)) % 26 + 'a');
			else
				answer+= (char)(ch-n);

		}

		return answer;

	}
}
