package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longwei on 7/31/15.
 */
public class RotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */

    //if allow duplicated eleemnts then we have to linear search.
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int pivot = findPivot(nums);
        reverse(nums, 0, pivot-1);
        reverse(nums, pivot, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    private static int findPivot(ArrayList<Integer> A) {
        if (A.size() == 0) return -1;
        int L = 0;
        int R = A.size()- 1;

        while (A.get(L) > A.get(R)) {
            int M = L + (R - L) / 2;
            if (A.get(M) > A.get(R))
                L = M + 1;
            else
                R = M;
        }
        return L;
    }

    private static int findPivot(int[] A) {
        if (A.length == 0) return -1;
        int L = 0;
        int R = A.length - 1;

        while (A[L] > A[R]) {
            int M = L + (R - L) / 2;
            if (A[M] > A[R])
                L = M + 1;
            else
                R = M;
        }
        return L;
    }

    public static void main(String[] arg){
        int[] input = new int[]{1,1,1,1,1,1,-1, 1,1,1,1,1};
//        int[] input = new int[]{4,5,1,2,3};
        System.out.println(findPivot(input));
    }

}
