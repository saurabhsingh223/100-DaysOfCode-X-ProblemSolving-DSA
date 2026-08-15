class Solution {
    public int longestSubsequence(int[] nums) {
        int xorAll = 0, countZero = 0;
        for (int x : nums) {
            xorAll ^= x;
            if (x == 0) countZero++;
        }

        int n = nums.length;
        if (xorAll != 0) return n;
        if (countZero == n) return 0;
        return n - 1;
    }
}