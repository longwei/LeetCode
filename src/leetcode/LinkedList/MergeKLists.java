package leetcode.LinkedList;

import utils.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by longwei on 7/6/15.
 */
public class MergeKLists {

//    private static final Comparator<ListNode> listComparator =
//            new Comparator<ListNode>() {
//                @Override
//                public int compare(ListNode x, ListNode y) {
//                    return x.val - y.val;
//                }
//            };
    //use lambda instead


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        Queue<ListNode> queue = new PriorityQueue<>(lists.length,
                (ListNode l, ListNode r)-> l.val - r.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            } }
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummyHead.next;
    }

    //another way is divide and conquer
    //klogk * n, with constant memory space
    //TODO
}
