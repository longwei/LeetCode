package leetcode.level5;

/**
 * Created by longwei on 1/8/15.
 */
public class RKSearch {
    private long needleHash;    // pattern hash value
    private long Q = 997;          // a large prime, small enough to avoid long overflow
    private int R = 256;           // radix
    private long RM;         // R^(M-1) % Q

    private long hash(String key, int M){
        long h = 0;
        for(int j = 0; j < M; j++){
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }


    private boolean check(String haystack, String needle, int i){
        for (int j = 0; j < needle.length(); j++) {
            if (needle.charAt(j) != haystack.charAt(i + j))
                return false;
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();
        if (N < M ) return -1;
        RM = 1;
        for(int i= 1; i < M; i++){
            RM = (R * RM) % Q;
        }
        needleHash = hash(needle, M); //signature of needle;
        long txtHash = hash(haystack, M);


        if ((needleHash == txtHash) && check(haystack, needle, 0))
            return 0;

        for(int i = M; i< N; ++i){
            txtHash = (txtHash + Q - RM*haystack.charAt(i-M) % Q) % Q;
            txtHash = (txtHash * R + haystack.charAt(i)) % Q;

            // match
            int offset = i - M + 1;
            if ((needleHash == txtHash) && check(haystack, needle, offset))
                return offset;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abbbaaaaaaabbababbbbabababbbbbbbaaaaaaabbaaabbaababbbbababababaabbbbbbaaaaababbbbaaabababbbaaaabbbaabbbbbbabababbabaaaaabaabaaababbbaaabaababbaaabaaababbabbbbababaaaaaaababaabaabbaabbbaaabaaaaaa";
        String needle = "aabaaaabababbbabababbbaabaabaaaaabaabbbaabbbbba";
//        String haystack = "";
//        String needle = "";
        RKSearch rollinghash = new RKSearch();
        int pos = rollinghash.strStr(haystack, needle);
        System.out.println(pos);
        System.out.print(haystack.indexOf(needle));
    }
}
