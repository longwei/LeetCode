package leetcode.level5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longwei on 4/1/15.
 * support add and find
 * #1 add n runtime, find constant, n^2 space, store pair sums in hashtable
 * #2 add logn, find n, n space, maintain a sorted array of numbers
 * #3 add const, find n, n space. store input in hashtable, handle duplicate!
 */
public class TwoSumDesign {

    public Map<Integer, Integer> table = new HashMap<>();

    public void add(int input){
        int count =  table.containsKey(input)? table.get(input): 0;
        table.put(input, count);
    }

    public boolean find(int val){
        for( Map.Entry<Integer, Integer> entry: table.entrySet()){
            int num = entry.getKey();
            int y = val - num;
            if(y == num && entry.getValue() >=2){
                return true;
            } else if (table.containsKey(y)){
                return true;
            }
        }
        return false;
    }
}
