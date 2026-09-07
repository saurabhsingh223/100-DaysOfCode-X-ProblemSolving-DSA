class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] last = new long[26];
        long total = 1; // empty subsequence

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newTotal = (2 * total - last[idx] + MOD) % MOD;
            last[idx] = total;
            total = newTotal;
        }

        return (int) ((total - 1 + MOD) % MOD);
    }
}