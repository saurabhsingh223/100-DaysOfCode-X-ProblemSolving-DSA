class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // palindrome[i][j] = true if s[i...j] is palindrome
        boolean[][] palindrome = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || palindrome[i + 1][j - 1])) {

                    palindrome[i][j] = true;
                }
            }
        }

        // dp[i] = maximum palindromes from i onwards
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // Option 1: skip current character
            dp[i] = dp[i + 1];

            // Option 2: take a palindrome starting at i
            for (int j = i + k - 1; j < n; j++) {

                if (palindrome[i][j]) {
                    dp[i] = Math.max(
                        dp[i],
                        1 + dp[j + 1]
                    );
                }
            }
        }

        return dp[0];
    }
}