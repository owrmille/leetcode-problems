package io.github.owrmille.leetcode.p0374_guess_number_higher_or_lower;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        s.setPick(6);

        assertEquals(6, s.guessNumber(10));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        s.setPick(1);

        assertEquals(1, s.guessNumber(1));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        s.setPick(1);

        assertEquals(1, s.guessNumber(2));
    }

    @Test
    void upperBoundPick() {
        Solution s = new Solution();
        s.setPick(20);

        assertEquals(20, s.guessNumber(20));
    }

    @Test
    void midPick() {
        Solution s = new Solution();
        s.setPick(500);

        assertEquals(500, s.guessNumber(1000));
    }
}
