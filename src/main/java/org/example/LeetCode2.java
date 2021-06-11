package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/4/17
 * Time:下午5:38
 *
 *
 * 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode2 {

    static int a = 0;

    public static void main(String[] args) {

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9, n1);
        ListNode n3 = new ListNode(9, n2);

        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9, n4);
        ListNode n6 = new ListNode(9, n5);

        ListNode result = new LeetCode2().addTwoNumbers(n3, n6);

        while (null != result) {

            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode pre = null;

        while(null != l1 || null != l2 || a != 0) {

            int currentResult = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + a;

            ListNode current =
                    new ListNode(currentResult % 10);

            a = currentResult / 10;

            if(null == head) {

                head = current;
            }
            else {

                pre.next = current;
            }
            pre = current;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
