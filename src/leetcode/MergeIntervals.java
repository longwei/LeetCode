package leetcode;

/**
 * Created by longwei on 1/9/15.
 * Given a collection of intervals, merge all overlapping intervals.
 */

import java.util.*;

public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        public String toString() { return String.format("[%d %d]", start, end);}
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                if(interval.start == t1.start) return 0;
                if( interval.start > t1.start){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for(int i = 1; i < intervals.size(); i++){
            if( intervals.get(i-1).end >= intervals.get(i).start){
                intervals.get(i-1).end = Math.max(intervals.get(i).end, intervals.get(i-1).end);
                intervals.remove(i);
                --i;
            }
        }
        return intervals;
    }


    public static void main(String[] args) {
        Interval a = new Interval(1,3);
        Interval b = new Interval(2,6);
        Interval c = new Interval(8,10);
        Interval d = new Interval(15,18);
        List<Interval> input = new ArrayList<Interval>();
        input.add(a);
        input.add(b);
        input.add(c);
        input.add(d);

        MergeIntervals test = new MergeIntervals();
        System.out.println(input.toString());
        System.out.println(test.merge(input).toString());
    }

}