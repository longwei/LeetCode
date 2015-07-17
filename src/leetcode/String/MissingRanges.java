package leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longwei on 4/13/15.
 * finish the main code path, then consider the edge case
 * 1. what if prev and end?
 * 2. what if only one as range
 * 3. 
 */
public class MissingRanges {

    private String addRange(int from, int to){
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }

    public List<String> missingRange(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start - 1;
        for(int i = 0; i <= vals.length; ++i){
            int curr = (i == vals.length) ? (end + 1) : vals[i];
            if(curr - prev > 1 ) {
                ranges.add(addRange(prev+1, curr-1));
            }
            prev = curr;
        }
        return ranges;
    }
}
