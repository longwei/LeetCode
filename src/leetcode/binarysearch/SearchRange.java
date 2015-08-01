package leetcode.binarysearch;

/**
 * Created by longwei on 7/27/15.
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int[] bound = new int[2];

        //left bound
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target){
            bound[0] = start;
        } else if (nums[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }
        //right bound
        start = 0;
        end = nums.length -1;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = -1;
            bound[1] = -1;;
        }
        return bound;
    }
}
