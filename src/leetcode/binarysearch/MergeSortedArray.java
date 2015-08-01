package leetcode.binarysearch;

/**
 * Created by longwei on 7/31/15.
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    //because we need to do it in space, we have to do in from behind
    //because swap won't help me if the insert from index 0
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i>=0 && j >=0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        if(i>=0){
            while (i >= 0) A[index--] = A[i--];
        } else {
            while( j >= 0) A[index--] = B[j--];
        }
    }
}
