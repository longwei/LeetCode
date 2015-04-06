package leetcode.level5;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by longwei on 4/1/15.
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordInString {
    //trying to familiar with JAVA API
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
//        for(int i = 0; i < words.length;++i){
//            words[i] = new StringBuilder(words[i]).reverse().toString();
//        }
        int i = 0; int j = words.length -1;
        String tmp;
        while(i< j){
            tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
            i++;j--;
        }
        return String.join(" ", words);
    }

    //i j alway point to [ ) of a word, same as substring
    public String reverserWords(String s){
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for(int i = s.length()-1; i>= 0; --i){
            if(s.charAt(i) == ' '){
                j = i;
            } else if (i == 0 || s.charAt(i-1) == ' '){
                if(reversed.length() != 0) reversed.append(' ');
                reversed.append(s.substring(i,j));
            }
        }
        return reversed.toString();
    }



    //If the input string does not contain leading or trailing spaces and the words are
    //separated by a single space, could you do it in-place without allocating extra space?
    //sol: reverse whole string to reverse the space, then reverse the word to make it back
    public void reverseWordSimple(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            } }
    }

    private void reverse(char[] s, int begin, int end){
        char tmp;
        end = end - 1;//[) ignore the lasting one
        while(begin < end){
            tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;end--;
        }
    }

//    Rotate an array to the right by k steps in-place without allocating extra space.
//    For instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3].
    //reverse 0 n-1
    //reverse 0 k-1
    //reverse k n-1


    public static void main(String[] args) {
        ReverseWordInString test = new ReverseWordInString();
//        System.out.println("test.reverseWords(the sky is blue) = " + test.reverseWords("the sky is blue"));
        String txt = "the sky is blue";
        char[] input = txt.toCharArray();
        test.reverseWordSimple(input);
        System.out.println(new String(input));
    }
}
