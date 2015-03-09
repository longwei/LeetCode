package leetcode.level5;

/**
 * Created by longwei on 3/9/15.
 */
public class strStrBruteForce {

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle ==null) return  -1;
        if(haystack.isEmpty() || needle.isEmpty()) return 0;
        for(int i = 0; ;++i){
            for(int j = 0; ; ++j ){
                if(j == needle.length()) return i;
                if( (i+j) == haystack.length()) return -1;//can't find it
                if(haystack.charAt(i+j) != needle.charAt(j)) break;//not this one;
            }
        }
    }

    public static void main(String[] args) {


    }
}
