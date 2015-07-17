package leetcode.Math;



/**
 * Created by longwei on 7/5/15.
 * TODO read solution agian
 */
public class ReverseInt {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int reverse(int x){
        int ret = 0;
        while(x != 0){
            if( Math.abs(ret) > maxDiv10) return 0;
            int edgeLastDigit = x < 0 ? 8 : 7;
            if( Math.abs(ret) == maxDiv10 && ( x % 10 > edgeLastDigit) ) return 0;
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
