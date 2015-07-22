package leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by longwei on 7/21/15.
 *
 Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * [1,2,2] ==>
 * [ [1,2,2],

 [2,1,2],

 [2,2,1]]
 *
 */

public class PermutationII {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[]  nums) {
        if( nums == null || nums.length == 0 ) return result;
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(path, nums, visited);
        return result;
    }

    private void backtrace(ArrayList<Integer> path, int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if( visited[i] || (i != 0 && nums[i] == nums[i-1] && !visited[i-1])){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrace(path, nums, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args){
        PermutationII t = new PermutationII();
        int[] input = {1, 2, 2};
        List<List<Integer>> ret = t.permuteUnique(input);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
    }
    }
}
