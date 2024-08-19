package com.test;


public class test_lxhy_0817_1 {

    public static void main(String[] args) {
//        {1,2,3,4,5},2
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode res = exchange(p1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode exchange(ListNode head, int k) {
        // write code here
        ListNode pre_l = head;
        ListNode pre_r = head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        int index = 0;
        while (cur != null) {
            if (index == k - 1) {
                pre_l = cur;
            }
            cur = cur.next;
            index++;
        }
        int r_index = index - k;
        cur = newHead;
        for (int i = 0; i <= r_index; i++) {
            if (i == r_index - 1) {
                pre_r = cur;
            }
            cur = cur.next;
        }
        ListNode cur_l = pre_l.next;
        ListNode cur_r = pre_r.next;
        int val = cur_l.val;
        cur_l.val = cur_r.val;
        cur_r.val = val;
//        ListNode next_l = cur_l.next;
//        ListNode next_r = cur_r.next;
//        pre_l.next = cur_r;
//        cur_r.next = next_l;
//        pre_r.next = cur_l;
//        next_r.next = next_l;
        return newHead.next;
    }
}
