package leetcode;

/**
 * Created by longwei on 1/11/15.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n < 3) return n;
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;

        for(int i = 2; i <= n; i++){
            cache[i] = cache[i-1] + cache[i-2];

        }
        return cache[n];

    }

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        System.out.println(test.climbStairs(5));
    }



}
