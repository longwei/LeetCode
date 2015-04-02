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
        return String.join(" ",words);
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

//    If the input string does not contain leading or trailing spaces and the words are
//    separated by a single space, could you do it in-place without allocating extra space?
    //sol: reverse whole string to reverse the space, then reverse the word to make it back



    public static void main(String[] args) {
        ReverseWordInString test = new ReverseWordInString();
//        System.out.println("test.reverseWords(the sky is blue) = " + test.reverseWords("the sky is blue"));
        String output = test.reverserWords("   a   b ");
        System.out.println("output = " + output);
    }
}
