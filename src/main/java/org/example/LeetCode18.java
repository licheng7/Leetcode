package org.example;

import java.util.Stack;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/22
 * Time:上午11:36
 *
 *
 * 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 **/
public class LeetCode18 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (head != null) {
            stack1.push(head);
            head = head.next;
        }

        while (!stack1.isEmpty()) {
            ListNode ln = stack1.pop();

            n--;
            if(n == 0) {
                continue;
            }

            ln.next = null;
            stack2.push(ln);
        }

        ListNode newHead = null;
        ListNode pre = null;
        while (!stack2.isEmpty()) {
            ListNode ln = stack2.pop();
            if(newHead == null) {
                newHead = ln;
            }
            if(pre != null) {
                pre.next = ln;
            }
            pre = ln;
        }

        return newHead;
    }

    public static void main(String[] args) {
        //ListNode n1 = new ListNode(5);
        //ListNode n2 = new ListNode(4, n1);
        //ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1, n4);

        System.out.println(new LeetCode18().removeNthFromEnd(n5, 1));
    }
}
