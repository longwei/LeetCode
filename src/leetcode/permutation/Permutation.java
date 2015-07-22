package leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longwei on 7/21/15.
 */
public class Permutation {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if( nums == null || nums.isEmpty() ) return result;
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.size()];
        backtrace(path, nums, visited);
        return result;

    }

    private void backtrace(ArrayList<Integer> path, ArrayList<Integer> nums, boolean[] visited){
        if(path.size() == nums.size()){
            result.add(new ArrayList<>(path));//oops, should pass a copy not a reference
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(visited[i]){
                continue;
            } else {
                path.add(nums.get(i));
                visited[i] = true;
                backtrace(path, nums, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Permutation t = new Permutation();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        ArrayList<ArrayList<Integer>> ret = t.permute(input);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
        }
    }

    /*
    Permutations II
    * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    * [1,2,2] ==>
    * [ [1,2,2],

    [2,1,2],

    [2,2,1]]

     */
}
