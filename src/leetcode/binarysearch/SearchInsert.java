package leetcode.binarysearch;

/**
 * Created by longwei on 7/27/15.
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length -1;

        while( start + 1 < end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }

        // version 1: find the first position >= target
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    //find the last element < target
    //the other method, find the first element that >= is prefered,
    //as it has less edge case
    public int searchInsert2(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length -1;

        if (target < A[0]) {
            return 0;
        }
        while( start + 1 < end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        // version 2: find the last position < target
        if (A[end] == target) {
            return end;
        }
        if (A[end] < target) {
            return end + 1;
        }
        if (A[start] == target) {
            return start;
        }
        return start + 1;
    }
}
