package cc150.ch1;

import utils.TestHelper;
/**
 * Created by longwei on 1/4/15.
 */
public class SetZero {
    public static void main(String[] args) {
        int[][] matrix = TestHelper.randomMatrix(3, 5, 0, 5);
        TestHelper.printMatrix(matrix);
        setZeros(matrix);
        System.out.println();
        System.out.println();
        TestHelper.printMatrix(matrix);
    }

    public static void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; ++i){
            for(int j =0; j < matrix[0].length; ++j){
                if(matrix[i][i] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; ++i){
            for(int j =0; j < matrix[0].length; ++j){
                if(row[i] || column[j]){
                    matrix[i][j] =0;
                }
            }
        }
    }
}
