
public class 카카오1 {
	public static void main(String[] args) {

	}

public String solution(String new_id) {
    String answer = "";
    new_id = new_id.toLowerCase();

    String tmp = new_id;

    for (int i = 0; i < tmp.length(); i++) {
       char ch = tmp.charAt(i);
       if (!(Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.')) {
          new_id = new_id.replace(ch + "", "");
       }
    }
    int len = new_id.length();

     String a = "..";
       while(true) {
          if(new_id.contains(a)) {
             new_id = new_id.replace(a, ".");
          }
          else {
             break;
          }
       }

    tmp = "";
    boolean check = false;
    if (new_id.length() > 0 && new_id.charAt(0) == '.') {
       tmp = new_id.substring(1);
       check = true;
    }
    if (check) {
       new_id = tmp;
    }

    check = false;
    len = new_id.length() - 1;
    if (new_id.length() > 0 && new_id.charAt(len) == '.') {
       tmp = new_id.substring(0, len);
       check = true;
    }
    if (check) {
       new_id = tmp;
    }

    if (new_id.equals("")) {
       new_id = "a";
    }

    if (new_id.length() >= 16) {
       new_id = new_id.substring(0, 15);
    }

    check = false;
    len = new_id.length() - 1;
    if (new_id.length() > 0 && new_id.charAt(len) == '.') {
       tmp = new_id.substring(0, len);
       check = true;
    }
    if (check) {
       new_id = tmp;
    }

    len = new_id.length() - 1;
    char ch = new_id.charAt(len);
    if (len + 1 <= 2) {
       while (new_id.length() < 3) {
          new_id += ch;
       }
    }
    answer = new_id;

    return answer;
 }
}