package leetcode.String;

import java.util.Arrays;

/**
 * Created by longwei on 4/6/15.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3.
 * For “bbbbb” the longest substring is “b”, with the length of 1.
 *
 * solution is two pointer to keep a invariant sliding window, so that it contains no duplicate char
 * and the real question is what to do when we add a [j] to the windows that break the invariant?
 * 1. keep move i -> i+1 until invariant is met
 * 2. jump i to last time seeing index plus 1, char[s[j]]+1
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
