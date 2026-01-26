package io.github.owrmille.leetcode.p0278_first_bad_version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();

        VersionControl.setFirstBad(3);
        assertEquals(3, s.firstBadVersion(4));
    }

    @Test
    void firstIsBad() {
        Solution s = new Solution();
        VersionControl.setFirstBad(1);

        assertEquals(1, s.firstBadVersion(1));
    }

    @Test
    void lastIsBad() {
        Solution s = new Solution();
        VersionControl.setFirstBad(7);

        assertEquals(7, s.firstBadVersion(7));
    }

    @Test
    void midIsBad() {
        Solution s = new Solution();
        VersionControl.setFirstBad(3);

        assertEquals(3, s.firstBadVersion(10));
    }
}

