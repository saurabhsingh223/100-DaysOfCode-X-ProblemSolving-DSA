class Solution {
    public long countCommas(long n) {
        long total = 0;
        long lower = 1000;
        int commas = 1;
        while (lower <= n) {
            long upper = lower * 1000 - 1;
            long segEnd = Math.min(upper, n);
            total += (segEnd - lower + 1) * commas;
            lower = upper + 1;
            commas++;
        }
        return total;
    }
}