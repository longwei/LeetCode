package leetcode.Math;

/**
 * Created by longwei on 7/5/15.
 * Palindrome is either expand from the middle or compare from the two ends
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10; }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div /= 100; }
        return true;
    }
}
