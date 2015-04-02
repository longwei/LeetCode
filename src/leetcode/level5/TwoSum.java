package leetcode.level5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by longwei on 1/3/15.
 */
public class TwoSum {

    //n running time with n space
    public int[] twoSumHash(int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; ++i){
            int x = numbers[i];
            if(map.containsKey(target-x)){
                return new int[] {map.get(target-x)+1, i+1};
            }
            map.put(x,i);
        }
        throw new IllegalArgumentException("now two sum solution");
    }

    //what if the input is sorted
    //b search
    public int[] twoSumSorted(int[] numbers, int target){
        for(int i = 0; i < numbers.length; ++i){
            int j = bsearch(numbers, target- numbers[i],i+1);
            if(j != -1){
                return new int[]{i+1,j+1};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    private int bsearch(int[] A, int key, int start){
        int L = start, R= A.length-1;
        while (L < R){
            int M = (L+R)/2;
            if(A[M] < key){
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && A[L]==key)? L:-1;
    }

    //n runtime, constant space
    //two pointer
    public int[] twoSumTwoPointer(int[] numbers, int target){
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
            } else if (sum > target){
                j--;
            } else {
                return new int[]{i+i,j+1};
            }
        }
        throw new IllegalArgumentException("no solution");
    }


    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] input = {1,2,3,4,5};
        System.out.println(Arrays.toString(test.twoSumSorted(input, 6)));
    }




}
