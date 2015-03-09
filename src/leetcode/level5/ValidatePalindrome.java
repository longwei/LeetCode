package leetcode.level5;

/**
 * Created by longwei on 1/11/15.
 */
public class ValidatePalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.isEmpty()) return true;
        return isPalindromeRec(s, 0);

    }

    public boolean isPalindromeRec(String s, int p){
        if( s.length() -1 - 2 * p == 1) return true;
        if( s.charAt(p) != s.charAt(s.length() -1 - p )){return false; }
        return isPalindromeRec(s, (p + 1));
    }

    public static void main(String[] args) {
        ValidatePalindrome test = new ValidatePalindrome();
        String input = "A man, a plan, a canal: Panama";
        boolean output = test.isPalindrome(input);
        System.out.println(output);
    }
}
