package leetcode.String;

/**
 * Created by longwei on 6/30/15.
 * the 3 conditions need to be that specific order, because condition 2 actually could cover condition1
 * and condition 3 need to be behind condition 2 for out of bound protection
 */

public class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle ==null) return  -1;
        if(haystack.isEmpty() && needle.isEmpty()) return 0;
        for(int i = 0; ;++i){
            for(int j = 0; ; ++j ){
                if(j == needle.length()) return i;
                if( (i+j) == haystack.length()) return -1;//can't find it
                if(haystack.charAt(i+j) != needle.charAt(j)) break;//not this one;
            }
        }
    }
}