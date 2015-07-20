package leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longwei on 7/20/15.
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        subsetHelper(path, 0, candidates, target, 0);
        return result;
    }

    private void subsetHelper(ArrayList<Integer> path, int sum, int[] nums, int target, int pos){
        for(int i = pos; i < nums.length; i++){
            int newSum = sum + nums[i];
            if(newSum > target){
                return;
            } else{
                path.add(nums[i]);
                if(newSum == target){
                    result.add(new ArrayList<>(path));
                }
                subsetHelper(path, newSum, nums, target, i);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args){
        CombinationSum t = new CombinationSum();
        int[] input = {2,3,6,7};
        List<List<Integer>> ret = t.combinationSum(input, 7);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}
