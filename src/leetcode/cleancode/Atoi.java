package leetcode.cleancode;

/**
 * Created by longwei on 7/1/15.
 * the tricky part is dealing with overflow
 */
public class Atoi {
    //偷懒了，待会再补
    public int atoi(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++; }
        long num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            num = num * 10 + digit;
            i++;
        }
        long ret = sign * num;
        return (int)ret;
    }
}


