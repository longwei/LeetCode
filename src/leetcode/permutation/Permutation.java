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
            }
            path.add(nums.get(i));
            visited[i] = true;
            backtrace(path, nums, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args){
        Permutation t = new Permutation();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
//        ArrayList<ArrayList<Integer>> ret = t.permute(input);
        int[] arrayInput = new int[]{1,2,3};
        ArrayList<ArrayList<Integer>> ret = t.permute(arrayInput);
        for( List<Integer> row : ret){
            System.out.println(Arrays.toString(row.toArray()));
        }
    }

    /*
     * Recusive, but use swap method to mark picked zone and toPick zone
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        permute(num, 0, ret);
        return ret;
    }

    private void permute(int[]num, int start, ArrayList<ArrayList<Integer>> ret){
        if(start == num.length) {
            ret.add(convertArrayToList(num));
        }

        for (int i = start; i < num.length; ++i) {
            swap(num, start, i);//shuffle
            permute(num, start+1, ret);
            swap(num, start, i);
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

}
