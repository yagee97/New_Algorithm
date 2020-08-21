import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj11723_집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0;tc<M;tc++) {
			st = new StringTokenizer(br.readLine());
			String D = "";
			int num = 0;
			D = st.nextToken();	
			if(st.countTokens() == 1) {
				num = Integer.parseInt(st.nextToken());
			}
			switch(D) {
			case "add":
				if(!list.contains(num))
					list.add(num);
				break;
			case "remove":
				if(list.contains(num)) {
					int idx = list.indexOf(num);
					list.remove(idx);
				}
				break;
			case "check":
				if(list.contains(num))
					sb.append("1").append("\n");
				else if(!list.contains(num))
					sb.append("0").append("\n");
				break;
			case "toggle":
				if(list.contains(num)) {
					int idx = list.indexOf(num);
					list.remove(idx);
				}else
					list.add(num);
				break;
			case "all":
				list.clear();
				for(int i = 1;i<=20;i++)
					list.add(i);
				break;
			case "empty":
				list.clear();
				break;
			}	
		}
		System.out.println(sb.toString());
		
	}
}
