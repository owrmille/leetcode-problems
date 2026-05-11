package io.github.owrmille.leetcode.p0001_two_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SolutionTest {

    private static void assertTwoSum(int[] nums, int target, int[] actual) {
        assertEquals(2, actual.length);
        assertNotEquals(actual[0], actual[1]);
        assertEquals(target, nums[actual[0]] + nums[actual[1]]);
    }

    @Test
    void example1() {
        Solution s = new Solution();
        int[] nums = {2, 7, 11, 15};

        assertTwoSum(nums, 9, s.twoSum(nums, 9));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] nums = {3, 2, 4};

        assertTwoSum(nums, 6, s.twoSum(nums, 6));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[] nums = {3, 3};

        assertTwoSum(nums, 6, s.twoSum(nums, 6));
    }

    @Test
    void usesNegativeNumbers() {
        Solution s = new Solution();
        int[] nums = {-3, 4, 3, 90};

        assertTwoSum(nums, 0, s.twoSum(nums, 0));
    }

    @Test
    void usesZeroTwice() {
        Solution s = new Solution();
        int[] nums = {0, 4, 3, 0};

        assertTwoSum(nums, 0, s.twoSum(nums, 0));
    }

    @Test
    void noSolution() {
        Solution s = new Solution();

        assertEquals(0, s.twoSum(new int[] {1, 2, 3}, 7).length);
    }
}
