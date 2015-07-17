package leetcode.String;

/**
 * Created by longwei on 7/1/15.
 * " ".join(s.split()[::-1])
 */

public class ReverseWord {
    //this failed because it didn't handle multiple space and only spaces edge case well
    //the solution with
    // if(s.charAt(i) == ' ') j = i
    // is triming the all the extra space first
    // so the s[i]== ' ' case must reserved for skip
    // and put append in s[i-1] = ' ' case
    public String reverseWordsfailed(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for(int i = s.length()-1; i>= 0; --i) {
            if( i == 0){
                reversed.append(s.substring(i, j));
            }
            else if (s.charAt(i) == ' ') {

                reversed.append(s.substring(i+1, j));
                reversed.append(' ');
                j = i;

            }
        }
        return reversed.toString();
    }

    //  word
    //  i   j
    //i always point to the first of the word, while j point to the one off the end
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder(); int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }

    public String reverseWordsTwoPass(String s){
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        if(parts.length > 0){
            for(int i = parts.length -1; i >0 ; i--){
                sb.append(parts[i]).append(" ");
            }
            sb.append(parts[0]);
        }
        return sb.toString();
    }

    public void testbundle(String s){
        System.out.println(reverseWords(s));
        System.out.println(reverseWordsTwoPass(s));
        System.out.println(reverseWordsfailed(s));
        System.out.println("---");
    }


    // in-place without allocating extra space for trimed string
    //I don't like the solution, because its edge case are handled in reverse not in reverseWordsInPlace
    //it is very easy to misuse this special reverse function(that's why it must declared as private)
    public void reverseWordsInPlace(char[] s){
        //reverse whole and reverse each word
        reverse(s,0, s.length-1);
        int i = 0;
        for(int j=0; j< s.length -1; ++j){
            if(s[j] == ' '){
                reverse(s,i,j-1);
                i = j+1;
            }
        }
        reverse(s,i,s.length-1);
    }

    public void reverse(char[] s, int begin, int end) {
        char tmp;
        while(begin < end){
            tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            ++begin;
            --end;
        }
    }

    public static void main(String[] args) {
        ReverseWord tst = new ReverseWord();
//        tst.testbundle("the sky is blue");
//        tst.testbundle("the sky is  blue");
//        tst.testbundle("the sky is  blue ");
//        tst.testbundle(" the sky is  blue");
//        tst.testbundle("*" + "  " + "*");
        tst.testbundle(" 1");
//        System.out.println("*" + tst.reverseWordsfailed("  ") + "*");
        String input = "5the sky is blue";
        char[] s = input.toCharArray();
        tst.reverseWordsInPlace(s);
        System.out.println(s);
        char five = '5';
        int x = five - '0';
        System.out.println(x);
    }
}
