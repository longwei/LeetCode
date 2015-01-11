package leetcode;

/**
 * Created by longwei on 1/11/15.
 */
public class SetMatrix {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                System.out.println(i + " " + j);
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if(row[i] || column[j]){
                    matrix[i][j] =0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] x = {{0}, {1}};
        SetMatrix test = new SetMatrix();
        test.setZeroes(x);
//        System.out.println(x[1][0]);
        System.out.println(x);
    }
}
