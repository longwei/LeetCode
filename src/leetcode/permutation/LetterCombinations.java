package leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longwei on 7/20/15.
 */
public class LetterCombinations {
    private String[] dic={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> ret = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        ArrayList<Character> path = new ArrayList<>();
        if(digits.isEmpty() || digits == null) return ret;//forget this again
        backtrace(path, digits,0);
        return ret;
    }

    private String arrayCharToString(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    private void backtrace(ArrayList<Character> path, String digits, int pos){
        if(path.size() == digits.length()){
            ret.add(arrayCharToString(path));
            return;
        }
        for(int i = pos; i < digits.length(); i++){
            int cur = Integer.parseInt(digits.substring(i, i+1));
            if(cur == 1 || cur == 0) continue;
            char[] charmap = dic[cur].toCharArray();
            for (char c : charmap){
                path.add(c);
                backtrace(path, digits, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args){
        LetterCombinations t = new LetterCombinations();
        List<String> ret = t.letterCombinations("");
        assert ret.size() == 0;
        for(String row: ret){
            System.out.println(row);
        }
    }
}
