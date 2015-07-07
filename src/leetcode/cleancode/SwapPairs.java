package leetcode.cleancode;
import utils.ListNode;
/**
 * Created by longwei on 7/6/15.
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        //the code is much more cleaner with dummpy head
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;//r could be null;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r; }
        return dummy.next;
    }
}
