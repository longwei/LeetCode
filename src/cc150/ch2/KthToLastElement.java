package cc150.ch2;

import utils.LinkedListNode;

/* 2.2
 * implement a algorithm to find the kth to last element of a single linked list
 */
public class KthToLastElement {
    public static LinkedListNode nthToLast(LinkedListNode head, int k){
        LinkedListNode first = head;
        LinkedListNode last = head;
        for(int i = 0; i < k -1 ; ++i){
            if(last == null){return null;}//error less than k
            last = last.next;
        }
        if(last == null){return first;}
        while(last.next != null){
            first = first.next;
            last = last.next;
        }
        return first;
    }

}
