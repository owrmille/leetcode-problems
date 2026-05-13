package io.github.owrmille.leetcode.p0002_add_two_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private static Solution.ListNode list(Solution s, int... values) {
        Solution.ListNode head = null;
        Solution.ListNode tail = null;

        for (int value : values) {
            Solution.ListNode node = s.new ListNode(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static int[] toArray(Solution.ListNode head) {
        int length = 0;
        Solution.ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int[] values = new int[length];
        current = head;
        for (int i = 0; i < length; i++) {
            values[i] = current.val;
            current = current.next;
        }

        return values;
    }

    @Test
    void example1() {
        Solution s = new Solution();

        Solution.ListNode actual = s.addTwoNumbers(
                list(s, 2, 4, 3),
                list(s, 5, 6, 4));

        assertArrayEquals(new int[] {7, 0, 8}, toArray(actual));
    }

    @Test
    void example2() {
        Solution s = new Solution();

        Solution.ListNode actual = s.addTwoNumbers(
                list(s, 0),
                list(s, 0));

        assertArrayEquals(new int[] {0}, toArray(actual));
    }

    @Test
    void example3() {
        Solution s = new Solution();

        Solution.ListNode actual = s.addTwoNumbers(
                list(s, 9, 9, 9, 9, 9, 9, 9),
                list(s, 9, 9, 9, 9));

        assertArrayEquals(new int[] {8, 9, 9, 9, 0, 0, 0, 1}, toArray(actual));
    }

    @Test
    void differentLengthsWithoutCarry() {
        Solution s = new Solution();

        Solution.ListNode actual = s.addTwoNumbers(
                list(s, 1, 2, 3),
                list(s, 4));

        assertArrayEquals(new int[] {5, 2, 3}, toArray(actual));
    }
}
