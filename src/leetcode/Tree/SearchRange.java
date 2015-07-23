package leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by longwei on 7/22/15.
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 */
public class SearchRange {
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        int start = -1;
        int end = -1;
        for (int i=0; i < A.size(); ++i ) {
            if(A.get(i) == target){
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1){
                    end = i - 1;
                    break;
                }
            }
        }
        //what if skip off
        if(start != -1 && end == -1) {
            end = A.size() - 1;
        }
        return new ArrayList<Integer>(Arrays.asList(start, end));
    }

    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] a = new int[256];
        int[] b = new int[256];
        for (char c: A.toCharArray()) {
            a[c]++;
        }
        for (char c: B.toCharArray()) {
            b[c]++;
        }
        for(int i =0; i < a.length; i++) {
            if ( b[i] > a[i]) {
                return false;
            }
        }
        return true;
    }
}
