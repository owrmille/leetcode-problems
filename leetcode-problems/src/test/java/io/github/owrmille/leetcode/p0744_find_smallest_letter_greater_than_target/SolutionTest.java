package io.github.owrmille.leetcode.p0744_find_smallest_letter_greater_than_target;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void basicGreater() {
        Solution s = new Solution();
        assertEquals('c', s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }

    @Test
    void midTarget() {
        Solution s = new Solution();
        assertEquals('f', s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }

    @Test
    void repeatedElems() {
        Solution s = new Solution();
        assertEquals('g', s.nextGreatestLetter(new char[]{'a', 'a', 'd', 'd', 'g', 'g', 'g', 'h', 'i'}, 'd'));
    }

    @Test
    void wrapAround() {
        Solution s = new Solution();
        assertEquals('c', s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    @Test
    void targetBetweenLetters() {
        Solution s = new Solution();
        assertEquals('f', s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

    @Test
    void singleElementPresent() {
        Solution s = new Solution();
        assertEquals('b', s.nextGreatestLetter(new char[]{'b', 'c'}, 'a'));
    }

    @Test
    void singleElementAbsent() {
        Solution s = new Solution();
        assertEquals('d', s.nextGreatestLetter(new char[]{'d', 'e'}, 'z'));
    }
}
