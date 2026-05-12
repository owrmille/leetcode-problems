package io.github.owrmille.leetcode.p0011_container_with_most_water;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        assertEquals(49, s.maxArea(height));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] height = new int[] {1,3,2,5,25,24,5};
        assertEquals(24, s.maxArea(height));
    }
}

