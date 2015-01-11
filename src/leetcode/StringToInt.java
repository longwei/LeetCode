package leetcode;

/**
 * Created by longwei on 1/4/15.
 */
public class StringToInt {
    public static void main(String[] args) {
        System.out.println(atoi("123"));
        System.out.println(atoi("  123"));
        System.out.println(atoi("  -123"));
    }

    public static int atoi(String str) {
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
}
