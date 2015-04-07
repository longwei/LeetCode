package leetcode.level2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by longwei on 4/6/15.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3.
 * For “bbbbb” the longest substring is “b”, with the length of 1.
 */
public class LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exists = new boolean[256];
        int i = 0;
        int maxlength = 0;
        for(int j = 0; j<s.length(); ++j){
            while(exists[s.charAt(j)]){
                exists[s.charAt(i)] = false;
                i++;
            }
            exists[s.charAt(j)] = true;
            maxlength = Math.max(maxlength,j-i+1);
        }
        return maxlength;
    }

    //because we don't need to loop until pop enough for duplicate char
    //we could save the location, and jump to that location + 1
    public int lengthOfLongestSubstringOptimazed(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0;
        int maxlength = 0;
        for(int j = 0; j < s.length(); ++j){
            if(charMap[s.charAt(j)] >= i){
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxlength = Math.max(maxlength,j-i+1);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChar test = new LongestSubStringWithoutRepeatingChar();
//        System.out.println("1 = " + test.lengthOfLongestSubstring("aa"));
//        System.out.println("2 = " + test.lengthOfLongestSubstring("aab"));
//        System.out.println("3 = " + test.lengthOfLongestSubstring("dvdf"));
//        System.out.println("5 = " + test.lengthOfLongestSubstring("abcdeab"));
//        System.out.println("5 = " + test.lengthOfLongestSubstring("abcdcedf"));
        System.out.println("3 = " + test.lengthOfLongestSubstring("pwwkew"));

    }
}
