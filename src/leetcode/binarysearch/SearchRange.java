package leetcode.binarysearch;

/**
 * Created by longwei on 7/27/15.
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int[] bound = {-1,-1};

        //left bound. first element that >= target
        while (start < end) {
            mid = (end + start) / 2;
            if(nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] != target) {
            return bound;
        } else {
            bound[0] = start;
            bound[1] = start;
        }

        //right bound. last element that <= target
        end = nums.length -1;
        while(start < end) {
            mid = (end + start + 1) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid -1;
            }
        }
        if (nums[end] == target) {
            bound[1] = end;
        }
        return bound;
    }

    /*
     * actually I prefer this solution better, because it is math symmetric tree
     * for finding left boundary
     * there are three possibilities:
     *  If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
     *  If A[mid] > target, it means the range must begins on the left of mid (j = mid-1)
     *  If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
     *  merge so that A[mid] >= target, j = mid;
     * No matter what the sequence originally is, as we narrow down the search range,
     * eventually we will be at a situation where there are only two elements in the search range.
     * Suppose our target is 5, then we have only 7 possible cases:
     * case 1: [5 7] (A[i] = target < A[j])
     * case 2: [5 3] (A[i] = target > A[j])
     * case 3: [5 5] (A[i] = target = A[j])  ,then we set j = mid next iteration, then terminate, ptr to first 5
     * case 4: [3 5] (A[j] = target > A[i])  set i = mid + 1, terminated
     * case 5: [3 7] (A[i] < target < A[j])
     * case 6: [3 4] (A[i] < A[j] < target)
     * case 7: [6 7] (target < A[i] < A[j])  A[i] is not the target
     * In conclusion, when the loop terminates, if A[i]==target, then i is the left boundary of the range; otherwise, just return -1;
     *
     * For the right of the range, we can use a similar idea. Again we can come up with several rules:
     * If A[mid] > target, then the range must begins on the left of mid (j = mid-1)
     * If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
     * If A[mid] = target, then the range must begins on the right of or at mid (i= mid)
     * case 1: [5 7] (A[i] = target < A[j]) i = mid, then infinite loop
     * case 2: [5 3] (A[i] = target > A[j])
     * case 3: [5 5] (A[i] = target = A[j])
     * case 4: [3 5] (A[j] = target > A[i])
     * case 5: [3 7] (A[i] < target < A[j])
     * case 6: [3 4] (A[i] < A[j] < target)
     * case 7: [6 7] (target < A[i] < A[j])
     * that's why (i+j+1)/2, so the mid biased to the right.
     *
     * when search left boundary, mid is biased to left, so the i could be mid, but j will never equal to mid, so it is ok for j to be mid.
     * so in order to avoid infinite loop, we need to make sure new i is set something diff than mid. so i = mid + 1
     * when search right boundary, mid is biased to right, so the j could be mid, but i will never == mid, so it is ok for us to set i to mid,
     * for the same reason, we need to set new j that will diff than mid, so j = mid - 1;
     */


}
