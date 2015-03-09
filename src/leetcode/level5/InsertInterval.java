package leetcode.level5;

/**
 * Created by longwei on 1/9/15.
 */

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for(Interval interval: intervals){
            if(interval.end > newInterval.start){
                //end of it
                result.add(interval);
            } else if (interval.start > newInterval.end){
                //before
                result.add(newInterval);
                newInterval = interval;
            } else if( interval.end >= newInterval.start){
                newInterval = new Interval(Math.min(interval.start, interval.end), Math.max(interval.end, interval.end));
            }
        }

        result.add(newInterval);
        return  result;
    }
}
