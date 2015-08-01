package leetcode.binarysearch;

/**
 * Created by longwei on 7/31/15.
 */
public class SearchRotatedArray {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        } // while
        return -1;
    }

    //find pivot
    //think [) , then only -> will +1
    int FindSortedArrayRotation(int A[], int N) {
        int L = 0;
        int R = N - 1;

        while (A[L] > A[R]) {
            int M = L + (R - L) / 2;
            if (A[M] > A[R])
                L = M + 1;
            else
                R = M;
        }
        return L;
    }
}
