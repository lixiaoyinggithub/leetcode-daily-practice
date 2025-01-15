package com.per.leetcode.round.first.range0to99;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * @author Xavier
 * @date 2025/2/7 17:58
 */
public class LinkDel88 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode q = head;
        while (q != null) {
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
            } else {
                p.next = q;
                p = p.next;
            }
            ListNode temp = q.next;
            q.next = null;
            q = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = deleteDuplicates(n1);

        ListNode p = listNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
