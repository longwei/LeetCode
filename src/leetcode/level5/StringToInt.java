package leetcode.level5;

/**
 * Created by longwei on 1/4/15.
 */
public class StringToInt {
    public static void main(String[] args) {
        System.out.println(atoi("123"));
        System.out.println(atoi("  123"));
        System.out.println(atoi("  -123"));
    }

    public static int atoi_old(String str) {
        char[] input = str.toCharArray();
        boolean negative = false;
        boolean overflow = false;
        int i = 0;
        int n = input.length;
        int ans = 0;
        while(i < n && input[i] == ' '){
            i++;
        }

        if( i < n && input[i] == '-'){
            negative = true;
            i++;
            if(input[i]  < '0' || input[i] > '9'){
                return 0;
            }
        } else if (i < n && input[i] == '+'){
            i++;
            if(input[i]  < '0' || input[i] > '9'){
                return 0;
            }
        }

        while(i < n && input[i] >= '0' && input[i] <= '9'){
            int digit = input[i] - '0';

            if(negative) {
                if (-1 * ans < (Integer.MIN_VALUE + digit) / 10) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if(ans > (Integer.MAX_VALUE - digit)/10 ){
                    return Integer.MAX_VALUE;
                }
            }
            i++;
            ans = ans * 10 + digit;
        }
        return negative? -1*ans : ans;
    }


    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public static int atoi(String str) {
        int i = 0;
        int n = str.length();
        while( i < n && str.charAt(i) == ' ') i++;
        int sign = 1;
        if(i < n && str.charAt(i) == '+') {
            i++;
        } else if ( i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int overflow_lastbig = (sign == 1)? 7:8;

        int num = 0;
        while(i < n && Character.isDigit(str.charAt(i))){
            int digit = str.charAt(i) - '0';
            if(num > maxDiv10 || (num == maxDiv10 && digit > overflow_lastbig)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign*num;
    }
}
