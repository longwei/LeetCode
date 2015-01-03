package cc150.ch1;

import utils.*;

import java.util.Arrays;

/**
 * Created by longwei on 1/3/15.
 * 1.1 determine if a string has all unique chars
 */
public class IsUniqueChar {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", null, "", "a"};
        for(String w: words){
            System.out.println(isUniqueChar2(w));
        }
    }

    public static boolean isUniqueChar(String input) {
        if (input == null || input.length() == 0) return false;
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for(int i = 1; i < input.length() - 1; i++){
            if (chars[i-1] == chars[i] ) return false;
        }
        return true;
    }

    //assume it is ascii
    public static boolean isUniqueChar2(String input){
        if (input == null || input.length() == 0) return false;
        int length = input.length();
        if (length > 256) return false;
        boolean[] ascii_hit = new boolean[256];
        for(int i = 0; i < length; ++i ) {
            int val = input.charAt(i);
            if(ascii_hit[val]) return false;
            ascii_hit[val] = true;
        }
        return true;
    }
}
