package leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by longwei on 7/22/15.
 */
public class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high ) {
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];
            if (midValue > target) {
                high = mid - 1;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch_jiuzhang(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start +1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }


    /*
     * this is a elegant solution for find the first occurrence
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (start != mid) { //equal but range is not fully scanned
                end = mid; //Set upper bound to current number and rescan
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] arg){
        int[] input = new int[]{3,4,5,8,8,8,10,13,14};
        System.out.println(BinarySearch.binarySearch(input, 8));
    }
}
