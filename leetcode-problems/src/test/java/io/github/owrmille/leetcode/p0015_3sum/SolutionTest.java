package io.github.owrmille.leetcode.p0015_3sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static List<List<Integer>> normalize(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            list.sort(Integer::compareTo);
        }
        lists.sort(Comparator
                .comparing((List<Integer> list) -> list.get(0))
                .thenComparing(list -> list.get(1))
                .thenComparing(list -> list.get(2)));
        return lists;
    }

    @Test
    void example1() {
        Solution s = new Solution();

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1));

        assertEquals(
                normalize(expected),
                normalize(s.threeSum(new int[] {-1, 0, 1, 2, -1, -4})));
    }
}
