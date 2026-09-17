import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int left = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currLen = right - left + 1;

                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[left - 1] + currLen);
                }

                dp[right] = (right > 0) ? Math.min(dp[right - 1], currLen) : currLen;
            } else {
                dp[right] = (right > 0) ? dp[right - 1] : Integer.MAX_VALUE;
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}