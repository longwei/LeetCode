package leetcode.level5;

/**
 * Created by longwei on 1/11/15.
 */
public class ValidatePalindrome {
    //this is for strict palindrome
    public boolean isPalindrome2(String s) {
        if(s == null) return false;
        if(s.isEmpty()) return true;
        return isPalindromeRec(s, 0);
    }

    public boolean isPalindromeRec(String s, int p){
        if( s.length() -1 - 2 * p == 1) return true;
        if( s.charAt(p) != s.charAt(s.length() -1 - p )){return false; }
        return isPalindromeRec(s, (p + 1));
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() -1;
        while( i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i) ) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidatePalindrome test = new ValidatePalindrome();
        String input = "A man, a plan, a canal: Panama";
        boolean output = test.isPalindrome(input);
        System.out.println(output);
    }
}
