package leetcode.cleancode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longwei on 6/30/15.
 */


public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();//diamond operator from java 7
        for(int i = 0; i < numbers.length; ++i){
            int x = numbers[i];
            if(map.containsKey(target-x)){
                return new int[] {map.get(target-x)+1, i+1};
            } else {
                map.put(x,i);
            }
        }
        return new int[]{-1, -1};//not found
    }

    /*
     * two pointer
     */
    public int[] twoSumSorted(int[] numbers, int target){
        int i = 0, j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                ++i;
            } else if (sum > target){
                --j;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};//not found
    }

}