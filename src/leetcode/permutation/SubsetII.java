package leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longwei on 7/20/15.
 *
 */
public class SubsetII {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelper(path, nums, 0);
        return result;
    }

    private void subsetHelper(ArrayList<Integer> path, int[] nums, int pos){
        result.add(new ArrayList<>(path));//oops, should pass a copy not a reference
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            subsetHelper(path, nums, i + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
        SubsetII t = new SubsetII();
        int[] input = {1,2,2};
        List<List<Integer>> ret = t.subsetsWithDup(input);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}
