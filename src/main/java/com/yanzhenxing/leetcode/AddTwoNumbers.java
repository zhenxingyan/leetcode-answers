package com.yanzhenxing.leetcode;

/**
 * problem 2
 *
 * @author Jason Yan
 * @date 23/11/2018
 */
public class AddTwoNumbers {

    /**
     * original
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        boolean over10 = false;
        while (l1 != null && l2 != null) {
            int value = over10 ? (l1.val + l2.val + 1) : (l1.val + l2.val);

            ListNode currentNode = new ListNode(value % 10);
            if (temp == null) {
                temp = currentNode;
                result = currentNode;
            } else {
                temp.next = currentNode;
            }

            if (temp.next != null) {
                temp = temp.next;
            }

            l1 = l1.next;
            l2 = l2.next;
            over10 = value >= 10;
        }

        if (l1 == null && l2 == null) {
            if (over10) {
                temp.next = new ListNode(1);
                over10 = false;
            }
        } else if (l1 != null) {
            while (l1 != null) {
                int value = over10 ? (l1.val + 1) : l1.val;
                temp.next = new ListNode(value % 10);
                temp = temp.next;
                l1 = l1.next;
                over10 = value >= 10;
            }
        } else if (l2 != null) {
            while (l2 != null) {
                int value = over10 ? (l2.val + 1) : l2.val;
                temp.next = new ListNode(value % 10);
                temp = temp.next;
                l2 = l2.next;
                over10 = value >= 10;
            }
        }

        if(over10){
            temp.next = new ListNode(1);
        }

        return result;
    }

    /**
     * better
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * best
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return recursive(l1, l2, 0);
    }

    public ListNode recursive(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0){
            return null;
        }
        carry += l1 == null ? 0 : l1.val;
        carry += l2 == null ? 0 : l2.val;
        ListNode now = new ListNode(carry % 10);
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        carry /= 10;
        now.next = recursive(l1, l2, carry);
        return now;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers.addTwoNumbers1(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
