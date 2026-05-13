package io.github.owrmille.leetcode.p0003_longest_substring_without_repeating_characters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void example4() {
        Solution s = new Solution();
        assertEquals(2, s.lengthOfLongestSubstring("aab"));
    }

    @Test
    void example5() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void example6() {
        Solution s = new Solution();
        assertEquals(3, s.optimizedLengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void example7() {
        Solution s = new Solution();
        assertEquals(1, s.optimizedLengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void example8() {
        Solution s = new Solution();
        assertEquals(3, s.optimizedLengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void example9() {
        Solution s = new Solution();
        assertEquals(2, s.optimizedLengthOfLongestSubstring("aab"));
    }

    @Test
    void example10() {
        Solution s = new Solution();
        assertEquals(3, s.optimizedLengthOfLongestSubstring("dvdf"));
    }
}

