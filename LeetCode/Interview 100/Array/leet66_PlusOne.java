package Array;

import java.util.Arrays;

public class leet66_PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length -1;
        int[] ans = Arrays.copyOf(digits, digits.length);
        while(i >= 0) {
            if(digits.length == 1 && digits[i] + 1 == 10) {
                    ans = Arrays.copyOf(digits, digits.length + 1);
        			ans[i] = 1;
        			ans[i+1] = 0;
        			break;
        		}
            
            if(digits[i] + 1 == 10 && i == 0){
                ans = Arrays.copyOf(digits, digits.length + 1);
                ans[i] = 1;
                for(int j = 1;j<ans.length;j++){
                    ans[j] = 0;
                }
                break;
            }
        	if(digits[i] + 1 == 10) {
        		ans[i] = 0;
        		i--;
        	}
        	else {
        		ans[i] += 1;
        		break;
        	}
        }
        		
        return ans;
    }
}
