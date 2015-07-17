package leetcode.String;

/**
 * Created by longwei on 7/5/15.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return isOneEditDistance(t, s);
        if (n - m > 1) return false;
        int editdistance = n-m;
        for(int i = 0, j =0; i < m; ++i, ++j){
            if(s.charAt(i) != t.charAt(j)){
                if(n > m) {
                    i--;
                } else {
                    editdistance++;
                    if(editdistance > 1) return false;
                }
            }
        }
        return editdistance == 1;
    }


    /* if s match all t, check if append
     * if | n-m | == 0, skip one mismatch, and make sure the rest are match, modify
     * if | n- m| == 1, insert, skip non-matching in t with shift offset, and rest of them must match
     */
    public boolean isOneEditDistance2(String s, String t){
        int m = s.length(), n = t.length();
        if (m > n) return isOneEditDistance(t, s);
        if (n - m > 1) return false;
        int shift = n-m;
        int i =0;
        while( i < m && s.charAt(i) == t.charAt(i)) i++;
        if( i == m) return shift ==1;//append
        if(shift == 0) i++;
        while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
        return i ==m;
    }

    public static void main(String[] args){
        OneEditDistance x = new OneEditDistance();
        assert x.isOneEditDistance("abcd","abc");
        assert !x.isOneEditDistance("abcd","abcd");
        assert x.isOneEditDistance("abcd","abcde");
        assert x.isOneEditDistance("abcd","abxd");
        assert !x.isOneEditDistance("abcd","abxdeee");
        assert x.isOneEditDistance("abcd","abXcd");
    }
}
