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
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        if( nums == null || nums.isEmpty() ) return result;
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.size()];
        Collections.sort(nums);
        backtrace(path, nums, visited);
        return result;
    }
//    private void backtrace(ArrayList<Integer> path, ArrayList<Integer> nums){
//        if(nums.isEmpty()){
//            result.add(new ArrayList<>(path));//oops, should pass a copy not a reference
//            return;
//        }
//        for(int i = 0; i < nums.size(); i++){
//            if(i > 0 && nums.get(i) == nums.get(i-1)){
//                continue;
//            }
//            path.add(nums.remove(i));
//            backtrace(path, nums);
//            nums.add(i, path.remove(path.size()-1));
//        }
//    }

    private void backtrace(ArrayList<Integer> path, ArrayList<Integer> nums, boolean[] visited){
        if(path.size() == nums.size()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(visited[i]){
                continue;
//            } if(i > 0 && nums.get(i) == nums.get(i-1)){
//                continue;
                //TODO don't works
            }else {
                path.add(nums.get(i));
                visited[i] = true;
                backtrace(path, nums, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        PermutationII t = new PermutationII();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(2);
        ArrayList<ArrayList<Integer>> ret = t.permuteUnique(input);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
    }
    }
}
