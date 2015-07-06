package leetcode.cleancode;

import java.util.List;

/**
 * Created by longwei on 7/5/15.
 */
public class PlusOne {
    public void plusOne(List<Integer> digits) {
        for(int i = digits.size() -1; i >= 0; --i){
            int digit = digits.get(i);
            if(digit < 9){
                digits.set(i, digit+1);
                return;
            } else {
                digits.set(i,0);
            }
        }
        digits.add(0,1);
    }
    public int[] plusOne(int[] digits) {
        for(int i = digits.length -1; i >= 0; --i){
            int digit = digits[i];
            if(digit < 9){
                digits[i] = digit+1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] ret = new int[digits.length + 1];
        System.arraycopy(digits,0,ret,1,digits.length-1);
        ret[0] = 1;
        return ret;
    }
}
