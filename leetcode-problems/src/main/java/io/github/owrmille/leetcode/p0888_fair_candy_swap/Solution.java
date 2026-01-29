package io.github.owrmille.leetcode.p0888_fair_candy_swap;

import java.util.HashSet;
import java.util.Set;

/*
- LeetCode 888: Fair Candy Swap
- Difficulty: easy
- Topics:

- Approach:
for optimal solution:
0. need to figure out the formulas -> 
        sumA - a + b = targetSum  (a - # of candies that Alice will give away, b - # of candies that she will recieve from Bob)
        sumB + a - b = targetSum  (likewise)
        Then subtract -> get something like: a = b + (sumA - sumB)/2
1. 
- Time: O(n + m)  Space: 
*/

class Solution {
    public int[] fairCandySwapV1(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        for (int el : aliceSizes) sumA += el;

        int sumB = 0;
        for (int el : bobSizes) sumB += el;

        int targetSum = (sumA + sumB) / 2;
        // how much Alice need to gain/lose in general (NOT recieve from Bob!) compared to her current sumA
        int targetA = targetSum - sumA;
        
        int[] answer = new int[2];
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                // the relation between the swapped values for Alice
                if (bobSizes[j] - aliceSizes[i] == targetA) {
                    answer[0] = aliceSizes[i];
                    answer[1] = bobSizes[j];
                    return answer;
                }
            }
        }
        return answer;
    }

    public int[] fairCandySwapV2(int[] aliceSizes, int[] bobSizes) {
        // how much candies Alica has
        int sumA = 0;
        for (int el : aliceSizes) sumA += el;

        // how much candies Bob has
        int sumB = 0;
        for (int el : bobSizes) sumB += el;

        // difference between two values that will be swapped (it was found from equations in desciption above)
        int delta = (sumA - sumB)/2;

        // create a HashSet -> useful for a fast lookup later.
        // here we will store possible candidates for each swap with Alice
        Set<Integer> candidatesForBob = new HashSet<>();
        // traversing: O(n), n - # of elements in Alice's array
        for (int a : aliceSizes) {
            // for each Alice's box we calculate the possible value of Bob's box, using formula: a = b + delta
            candidatesForBob.add(a - delta);
        }

        // if some possible swap with Alice is one of the actual Bob's values, we are done.
        // traversing: O(m)
        for (int b : bobSizes) {
            // lookup: O(1) 
            if (candidatesForBob.contains(b)) {
                // if found a suitable candidate (it's guaranteed, that there is at least one) -> return result.
                // to track back to Alice's value -> again use the formula: a = b + delta
                return new int[]{b + delta, b};
            }
        }
        // if nothing was found, return [0,0] -> even though guaranteed it won't happen
        return new int[]{0};
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        return fairCandySwapV2(aliceSizes, bobSizes);
    }
}
