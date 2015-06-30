package leetcode.cleancode;

/**
 * Created by longwei on 6/30/15.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() -1;
        //while(i < j) will cover cabac case, clean!
        while( i < j){
            //enforce i < j to avoid edge case like ",j", index will slip out of bound
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i) ) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}