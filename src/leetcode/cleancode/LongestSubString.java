package leetcode.cleancode;

import java.util.Arrays;

/**
 * Created by longwei on 7/1/15.
 *
 * solution is two pointer to keep a invariant sliding window, so that it contains no duplicate char
 * and the real question is what to do when we add a [j] to the windows that break the invariant?
 * 1. keep move i -> i+1 until invariant is met
 * 2. jump i to last time seeing index plus 1, char[s[j]]+1
 */
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            int lastseen = charMap[s.charAt(j)];
            if (lastseen >= i) {
                i = lastseen + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
}
