class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n][k + 1];
        long[][] open = new long[n][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j]   = (dp[i-1][j] + open[i-1][j]) % MOD;
                open[i][j] = (open[i-1][j] + dp[i-1][j-1] + open[i-1][j-1]) % MOD;
            }
        }
        return (int) ((dp[n-1][k] + open[n-1][k]) % MOD);
    }
}