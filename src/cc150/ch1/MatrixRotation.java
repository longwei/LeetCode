package cc150.ch1;

import utils.TestHelper;

/**
 * Created by longwei on 1/4/15.
 */
public class MatrixRotation {
    public static void main(String[] args) {
        int[][] matrix = TestHelper.randomMatrix(5, 5, 0, 5);
        TestHelper.printMatrix(matrix);
        rotate(matrix, 5);
        System.out.println("*****");
        TestHelper.printMatrix(matrix);
    }


    public static void rotate(int[][] matrix, int n){
        for(int layer = 0; layer < n/2; layer++){
            int mirror_layer = n - 1 - layer;
            for(int i = layer; i < mirror_layer; i++) {
                int mirror_i = n - 1 - i;
                int tmp = matrix[layer][i];
                matrix[layer][i] = matrix[mirror_i][layer];
                matrix[mirror_i][layer] = matrix[mirror_layer][mirror_i];
                matrix[mirror_layer][mirror_i] = matrix[i][mirror_layer];
                matrix[i][mirror_layer] = tmp;
            }
        }

    }


}
