package leetcode.level5;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by longwei on 3/9/15.
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        HashMap<String, Integer> dist = new HashMap<String, Integer>();
        dist.put(start, 1);

        Queue<String> q = new LinkedList<String>();
        q.add(start);

        while(!q.isEmpty()){
            String word = q.remove();
            if(word == end){
                break;
            }

            for(int i=0; i < word.length(); i++){
                char[] buffer = word.toCharArray();
                for(char c='a';c <= 'z'; c++){
                    buffer[i] = c;
                    String tmp = String.valueOf(buffer);
                    if(dict.contains(tmp) && dist.get(tmp) == null ){
                        dist.put(tmp, dist.get(word) +1 );
                        q.add(tmp);
                    }
                }
            }
        }
        System.out.println(dist.toString());
        return dist.containsKey(end)? dist.get(end): 0 ;
    }


    public static void main(String[] args) {
        String start =  "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        WordLadder x = new WordLadder();
        System.out.println(x.ladderLength(start,end,dict));

    }
}
