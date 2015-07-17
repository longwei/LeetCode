package leetcode.String;

/**
 * Created by longwei on 4/13/15.
 *
 * solution is two pointer to keep a invariant sliding windows,
 * and the real question is what to do when we add a [j] to the windows that break the invariant?
 */
public class LongestSubstringWithMostDistinctChar {


    //why it can't optimazed to one pass instead of 2 pass.
    //because the char j+1 pointer to is not one the [i j] should kick out
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int[] count = new int[256];
        int i = 0, numDistict = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++){
            if(count[s.charAt(j)] == 0) numDistict++;
            count[s.charAt(j)]++;
            while(numDistict > 2){
                count[s.charAt(i)] --;
                if(count[s.charAt(i)] == 0) numDistict--;
                i++;
            }
            maxLen = Math.max(j-i+1, maxLen);
        }
        return maxLen;
    }



    public static void main(String[] args) {
        LongestSubstringWithMostDistinctChar test = new LongestSubstringWithMostDistinctChar();
        int output = test.lengthOfLongestSubstringTwoDistinct("abaac");
        System.out.println("4 = " + output);
    }
}
