package cc150.ch2;

import utils.LinkedListNode;
/*
 * 2.1 remove duplicates from a unsorted linked list
 * sol:
 * 1. with hashtable,ez
 * 2. without hashtable,
 *
 * invariant: node in clearzone don't have duplicate node is dirtyzone
 * foreach node cur [begin, end]
 *    foreach node runner [ cur, end]
 *        if duplicate, delete this node.
 *
 * [clearzone|dirtyzone]
 *        cur   runner
 *
 */
public class RmDuplicate {
    public static void rmduplicate(LinkedListNode n){
        boolean[] seen = new boolean[256];
        LinkedListNode prev = null;
        while(n != null) {
            if(seen[n.data] == true){
                prev.next = n.next;
            } else {
                seen[n.data] = true;
                prev = n;
            }
            n = n.next;
        }
    }

}
