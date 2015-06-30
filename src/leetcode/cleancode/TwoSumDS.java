package leetcode.cleancode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longwei on 6/30/15.
 * design a two sum class, it will support
 * void add(value)
 * bool find(target)
 */
public class TwoSumDS {
    private Map<Integer, Integer> mHash = new HashMap<>();//<value and its_count>
    public void add(int value){
        int count = (mHash.containsKey(value)) ? mHash.get(value): 0;
        mHash.put(value, count);
    }
    //http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
    public boolean find(int target){
        //becasue API allow duplicate value, so i need to access both key and value
        //using entry, if API says merge duplicate value, then it only need to access the key
        for(Map.Entry<Integer, Integer> entry: mHash.entrySet()){
            int num = entry.getKey();
            int x = target - num;
            if(x == num){
                if(entry.getValue() >=2 ) return true;//trick edge case
            } else {
                if(mHash.containsKey(x)) return true;
            }
        }
        return false;

    }

}
