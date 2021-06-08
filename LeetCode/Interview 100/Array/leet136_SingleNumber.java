package Array;

import java.util.HashMap;
import java.util.Map;

public class leet136_SingleNumber {
    public int singleNumber(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
       
        for(int x : map.keySet()){
            if(map.get(x) == 1){
                return x;
            }
        }
 
        return 0;
    }
}
