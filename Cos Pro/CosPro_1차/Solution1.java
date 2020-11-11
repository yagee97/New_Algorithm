package CosPro_1차;

//You may use import as below.
//import java.util.*;

class Solution1 {
 public long solution(long num) {
     // Write code here.
     long answer = 0;
     
     while(true) {
    	 long tmp = num + 1;
    	 String str = tmp + "";
    	 if(str.contains("0")) {
    		 num += 1;
    		 continue;
    	 }
    	 else {
    		 answer = tmp;
    		 break;
    	 }
    		 
     }
     
     return answer;
 }

 // The following is main method to output testcase.
 public static void main(String[] args) {
     Solution1 sol = new Solution1();
     long num = 9949999;
     long ret = sol.solution(num);

     // Press Run button to receive output. 
     System.out.println("Solution: return value of the method is " + ret + " .");
 }
}