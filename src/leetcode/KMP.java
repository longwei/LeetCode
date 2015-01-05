package leetcode;

import utils.TestHelper;
/**
 * Created by longwei on 1/4/15.
 */
public class KMP {

    public int[][] dfa;

    public void generateDFA(String pattern){
        int M = pattern.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for(int X = 0, j = 1 ; j < M; j++){
            //copy mismatch
            for(int c = 0; c < R; c++){
                dfa[c][j] = dfa[c][X];
            }
            //setmatch
            dfa[pattern.charAt(j)][j] = j+1;
            //update X
            X = dfa[pattern.charAt(j)][X];
        }
    }

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        if(haystack.length() == 0 || needle.length() == 0) return -1;
        if(needle.length() > haystack.length()) return -1;

//        generateDFA(needle);
        int M = needle.length();
        int N = haystack.length();
        int i , j;
        for (i = 0, j = 0; i < N && j < M; i++){
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == M) return i - M;
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abacadabrabracabracadabrabrabracad";
        String needle = "abracadabra";
//        String haystack = "";
//        String needle = "";
        KMP kmp = new KMP();
        kmp.generateDFA(needle);
        int pos = kmp.strStr(haystack, needle);
        System.out.println(pos);
    }
}
