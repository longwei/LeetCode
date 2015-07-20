package leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longwei on 7/19/15.
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * 递归树
 *
 */
public class Subset {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public  List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        System.out.print(path);
        subsetHelper(path, nums, 0);
        return result;
    }

    private void subsetHelper(ArrayList<Integer> path, int[] nums, int pos){
        result.add(path);
        System.out.print(path);
        for(int i = pos; i < nums.length; i++){
            path.add(nums[i]);
            subsetHelper(path, nums, i + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
        Subset t = new Subset();
        int[] input = {1,2,3};
        System.out.println(Arrays.toString(input));
        List<List<Integer>> ret = t.subsets(input);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}
