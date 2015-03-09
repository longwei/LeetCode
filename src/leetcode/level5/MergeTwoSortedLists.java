package leetcode.level5;

/**
 * Created by longwei on 1/4/15.
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
             val = x;
             next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);//dumbhead
        ListNode runner = head;
        while(l1 != null && l2 != null ) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
                runner = runner.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
                runner = runner.next;
            }
        }
        if(l1 != null){
            runner.next = l1;
        } else if (l2 != null){
            runner.next = l2;
        }
        return head.next;
    }
}
