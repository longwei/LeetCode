package cc150.ch2;

import utils.LinkedListNode;

/* 2.3
 * delete a node in the middle of a single linked list, given only access to that node
 * sol:
 * because we can't go to the previous node to update the next pointer.
 * we could deep copy currrent node as its.next node, and delete the next node
 */
public class DeleteNode {
    public static boolean deleteNode(LinkedListNode n){
        if(n == null || n.next == null){
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next.next;
        return true;
    }

}