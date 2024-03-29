package com.bnitech.java.leetcode.Q_2;

import com.bnitech.java.Utils.ListNode;

// 2. Add Two Numbers
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode result = new ListNode();
        ListNode node = result;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + up;
            node.val = sum % 10;
            up = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 == null && l2 == null) {
                node.next = up == 1 ? new ListNode(1) : null;
                break;
            }

            node.next = new ListNode();
            node = node.next;
        }

        return result;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
}


