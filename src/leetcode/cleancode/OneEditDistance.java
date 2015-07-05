package leetcode.cleancode;

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
                if(m<n) j++;
                editdistance++;
                if(editdistance > 1) return false;
            }
        }
        return editdistance == 1;
    }

    public static void main(String[] args){
        OneEditDistance x = new OneEditDistance();
        assert x.isOneEditDistance("abcd","abc");
        assert !x.isOneEditDistance("abcd","abcd");
        assert x.isOneEditDistance("abcd","abcde");
        assert x.isOneEditDistance("abcd","abxd");
        assert !x.isOneEditDistance("abcd","abxdeee");
    }
}
