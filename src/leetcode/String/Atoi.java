package leetcode.String;

/**
 * Created by longwei on 7/1/15.
 * the tricky part is dealing with overflow
 */
public class Atoi {
    //偷懒了，待会再补
    private static int maxDiv10 = Integer.MAX_VALUE / 10;
    public int atoi(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            int lastMaxMinDigit = sign == 1 ? 7: 8;
            if(num > maxDiv10 || (num == maxDiv10 && digit> lastMaxMinDigit )) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }
}


