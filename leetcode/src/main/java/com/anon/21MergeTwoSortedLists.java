package com.anon;
/*
 * app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * example：
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class MergeTwoSortedLists {
    /*
     * 通过迭代的方式
     *
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 声明一个头部节点
        ListNode preHead = new ListNode(-1);
        // 指针，指向前一个节点
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            // 前一个节点指向l1和L2中较小的一个；指针向下移动
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // prev指针向下移动
            prev = prev.next;
        }
        // 其中一个链表遍历完成，将另一个链表剩下的节点附在末尾
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /*
     * 通过递归的方法
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode result = mergeTwoLists1(l11, l21);

        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}