package io.github.owrmille.leetcode.p0441_arranging_coins;

/*
- LeetCode 441: Arranging Coins
- Difficulty: easy
- Topics:
Math
Binary Search
- Approach:
for optimal solution(v2): use binary search to find the largest possible value k that satisfies this condition k(k+1)/2 <= n.
on the LHS of it - is the sum of all elems from 1 to k. it should be <= than n, so it is possible to subtract it from n
IMPORTANT:
type casting of one operand to prevent overflow: (long)mid * (mid + 1) / 2 <= n 
-> type cast to long ANY one operand that is involved into overflowing process (before oveflow happens): here_mid * here_(here_mid + here_1) / 2
reason: we need to cast at least one operand before the overflow-prone operation, because Java promotes both operands to a common type before performing the arithmetic.
- Time: O(sqrt n) for v1;  O(log n) for v2
- Space: O(1) for v1; O(1) for v2
P.S.(for v1):
After k iterations I subtract:
1 + 2 + ... + k = k(k+1)/2 <= n
-> k ~ O(sqrt n)
*/


/*
Insight: when we have a condition(for example, x^2 + 2x - 1 >= 0) for some variable x, 
and we need to find the value of this variable x in some range [a, b] that meets the condition
-> use binary search
 */

class Solution {
    public int arrangeCoinsV1(int n) {
        int cnt = 1;
        while (n >= cnt) {
            n -= cnt;
            cnt++;
        }
        return cnt - 1;
    }

    public int arrangeCoinsV2(int n) {
        int left = 1;
        int right = n;
        int firstFeasible = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * (mid + 1) / 2 <= n) {
                firstFeasible = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstFeasible;
    }

    public int arrangeCoins(int n) {
        return arrangeCoinsV2(n);
    }
}
