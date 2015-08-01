package leetcode.binarysearch;

/**
 * Created by longwei on 7/30/15.
 *
 * @param matrix, a list of lists of integers
 * @param target, an integer
 * @return a boolean, indicate whether matrix contains target
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int column = matrix[0].length - 1;

        // find the row index, the last number <= target
        int start = 0, end = row;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }

        // find the column index, the number equal to target
        start = 0;
        end = column;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }

    public static int searchMatrixII(int[][] matrix, int target) {
        // write your code here
        int count = 0;
        int row = matrix.length -1;
        int col = 0;
        while( row >= 0 && col <= matrix[0].length -1 ) {
            int cur = matrix[row][col];
            if (cur == target) count++;
            if (cur > target) {
                row--;
            } else {
                col++;
            }
        }
        return count;
    }
}
