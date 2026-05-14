package io.github.owrmille.leetcode.p0002_add_two_numbers;

import java.util.Scanner;

/*
- LeetCode 2: Add Two Numbers
- Difficulty: medium
- Topics:
Principal
Linked List
Math
Recursion
- Approach:
since numbers are reversed, we can start summing their digits from the beginning (from lowest base to highest);
be carefull with proceeding list, check nulls, keep head and tail (head to return, head to keep adding nodes);
- Time: O(max(n,m))   Space: O(max(n,m))
*/

class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;

        ListNode head = null;
        ListNode tail = null;

        ListNode nextL1 = l1;
        ListNode nextL2 = l2;
        while (nextL1 != null || nextL2 != null) {

            int val1 = nextL1 != null ? nextL1.val : 0;
            int val2 = nextL2 != null ? nextL2.val : 0;

            int sumOfDigits = val1 + val2 + extra;
            extra = sumOfDigits / 10;

            ListNode newNode = new ListNode(sumOfDigits % 10);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            nextL1 = nextL1 != null ? nextL1.next : null;
            nextL2 = nextL2 != null ? nextL2.next : null;
        }

        if (extra > 0) {
            tail.next = new ListNode(extra);
        }

        return head;
    }

    public ListNode createListFromArray(String[] nums) {
        ListNode head = null;
        ListNode tail = null;

        for (String s : nums) {
            ListNode newNode = new ListNode(Integer.parseInt(s));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public void printList(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val);

            if (cur.next != null) {
                System.out.print(" -> ");
            }

            cur = cur.next;
        }

        System.out.println();
     }

    public static void main(String[] args) {
        Solution sol = new Solution();
        try (Scanner scanner = new Scanner(System.in)) {
            String[] n1 = scanner.nextLine().split(" ");
            String[] n2 = scanner.nextLine().split(" ");

            ListNode l1 = sol.createListFromArray(n1);
            ListNode l2 = sol.createListFromArray(n2);

            sol.printList(sol.addTwoNumbers(l1, l2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
