package com.anon;

/*
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * example 1:
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * example 2:
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * example 3:
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author anon
 * @since 2019-12-03 19:49
 **/
class LinkedListCycle {
    /**
     * 经典解法，快慢指针
     * 环的检测，问题在于遍历过程中很容易死循环。
     * 快指针一次走两步，慢指针一次走一步。如果存在环，那么快慢指针肯定会在环中的某个结点相遇；如果不存在环，遇到尾结点退出循环。
     * 时间复杂度：O(n)
     * · 如果不存在环，时间复杂度为O(n)。
     * · 如果存在环，把链表分为两部分，直线m和环k(m+k=n)，那么在环中经过"两指针距离差"/"相对速度"的时间，就可以相遇，从而退出循环。而距离差最大为k，因此最坏时间复杂度为O(n)
     * 空间复杂度：O(1)
     */
    public boolean hasCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解法二：哈希表
     * 把每个结点的引用放到哈希表中，如果已存在该结点，说明有环，否则完成遍历，返回false
     * 时间复杂度：O(n)，最多访问每个一次，加入到哈希表的复杂度为O(1)
     * 空间复杂度：O(n)，当最后一个元素有环时，哈希表最多加入n个元素
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
