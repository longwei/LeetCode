package cc150.ch1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by longwei on 1/3/15.
 * 1.3 if a string a permutation of another string
 */
public class IsPermutation {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] pairs = {
                {"apple", "papel"},
                {"carrot", "tarroc"},
                {"hello", "llloh"},
                {"", ""},
                {null, null}
        };
        for(String[] pair: pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + " - "+word2 + ": " + anagram);
        }
    }

    //I could use a array of 256 if it is ASCII encoding
    public static boolean isPermutation(String s1, String s2){
        if (s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(256);
        for(int i =0; i < s1.length(); i++){
            int val = s1.charAt(i);
            if(!record.containsKey(val)) {
                record.put(val, 1);
            } else {
                int newValue = record.get(val) + 1;
                record.put(val, newValue);
            }
        }
        for(int i =0; i < s2.length(); i++){
            int val = s2.charAt(i);
            if(!record.containsKey(val)){
                return false;
            } else {
                int newValue = record.get(val) - 1;
                if(newValue < 0) {return false;}
                record.put(val, newValue);
            }
        }
        return true;
    }

}
