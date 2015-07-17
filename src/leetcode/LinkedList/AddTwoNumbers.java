package leetcode.LinkedList;

import utils.ListNode;
/**
 * Created by longwei on 7/6/15.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int digit = carry + x + y;
            carry = digit / 10;
            curr.next = new ListNode(digit % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    //recursive solution
//    ListNode *addTwoNumbersR(ListNode *l1, ListNode *l2, int carry) {
//        //both l1 and l2 could be null
//        if(l1== NULL && l2 == NULL && carry == 0) return NULL;
//        int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
//        ListNode* ret = new ListNode(sum % 10);
//        ret->next = addTwoNumbersR(l1?l1->next:NULL, l2?l2->next:NULL, sum/10);
//        return ret;
//    }
//
//    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
//        ListNode* result = addTwoNumbersR(l1, l2,0);
//        return result;
//    }
}



