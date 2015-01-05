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

            if (ans > Integer.MAX_VALUE / 10) {
                overflow = true;
                break;
            }
            if (ans == Integer.MAX_VALUE / 10 ){
                if( (!negative && digit >=7) || (negative && digit >=8)) {
                    overflow = true;
                    break;
                }
            }
            i++;
            ans = ans * 10 + digit;
        }


        if (negative){
            return overflow ? Integer.MIN_VALUE : ans * -1;
        } else {
            return overflow ? Integer.MAX_VALUE : ans;
        }
    }
}
