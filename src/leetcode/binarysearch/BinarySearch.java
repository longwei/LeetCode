package leetcode.binarysearch;

/**
 * Created by longwei on 7/22/15.
 */
public class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */

    //this is the solution from programming perls that find ANY target
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


    //this is quite hard to understand but turn out to be a good solutions
    //it maintain the invariant so that the target always in the to search range
    //the each iteration reduce the size of problems by 2
    //the only exit condition for the while loop is start + 1 < end (so exclude start = end which may result infinite loop)
    //but because the range hold the truth of always have the target, it must be either start or end or not found.
    // we don't know whether we are approaching the problem, could be from left side or from right side
    //that's why it need to check both start and end position
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
     * this is a elegant solution for find the first occurrence, found in SO
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

    //This is STL's implementation on binary search

    public int binarySearch_lowbound(int[] nums, int target) {
        //write your code here
        int start = 0;
        int end = nums.length -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) { //I am search first element that >= target
                end = mid; //new best, including mid
            } else {
                start = mid + 1;//overshot, keep the old one. don't include mid
            }
        }
        //here start == end, but need to check not found issue.
        return nums[start] == target ? start : -1;
    }

    public int binarySearch_upperbound(int[] nums, int target) {
        //write your code here
        int start = 0;
        int end = nums.length -1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        //here start == end, but need to check not found issue.
        return nums[end] == target ? end : -1;
    }


    public static void main(String[] arg){
        int[] input = new int[]{3,4,5,8,8,8,10,13,14};
        System.out.println(BinarySearch.binarySearch(input, 8));
    }
}
