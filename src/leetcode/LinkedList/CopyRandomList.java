package leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longwei on 7/11/15.
 */


public class CopyRandomList {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        while( runner != null ){
            prev.next = new RandomListNode(runner.label);
            map.put(runner, prev.next); //<original, new_copy>
            prev = prev.next;
            runner = runner.next;
        }
        //reset to head, update random ptr
        runner = head;
        prev = dummy;
        while(runner != null){
            prev.next.random = map.get(runner.random);
            runner = runner.next;
            prev = prev.next;
        }
        return dummy.next;
    }

    //the other solution is way to tricky
    //TODO
}
